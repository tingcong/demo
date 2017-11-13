package com.example.demo.Controller;

import com.example.demo.converter.OrderForm2OrderDTO;
import com.example.demo.entity.sell.ProductCategory;
import com.example.demo.entity.sell.ProductInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.form.OrderForm;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.exception.SellException;
import com.example.demo.order.service.OrderMasterService;
import com.example.demo.service.BuyerService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductInfoService;
import com.example.demo.utils.ResultVOUtil;
import com.example.demo.vo.ProductInfoVO;
import com.example.demo.vo.ProductVo;
import com.example.demo.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hutingcong on 2017/10/10.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    private final static Logger log = LoggerFactory.getLogger(BuyerProductController.class);
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     */
    @PostMapping(value = "/create", produces = {"application/json;charset=UTF-8"})
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),   //将OrderForm中注解的message返回
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】，购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderMasterService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    /**
     * 订单列表
     *
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderMasterService.findList(openid, request);
        return ResultVOUtil.success(orderDTOPage);
    }

    /**
     * 订单详情（查看单个订单）
     *
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)) {
            log.error("【查询详细订单】openid或orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping(value = "/cancel", produces = {"application/json;charset=UTF-8"})
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        //TODO 不安全的做法，改进
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }


    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public ResultVO list_() {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //一次性查询类目
        //传统方法
//        List<Integer> categoryTypeList=new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼装
        List<ProductVo> productVos = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);

                }
            }
            productVo.setProductInfoVOList(productInfoVOS);
            productVos.add(productVo);
        }

        return ResultVOUtil.success(productVos);
    }
}
