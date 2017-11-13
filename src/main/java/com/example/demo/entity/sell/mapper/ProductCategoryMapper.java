package com.example.demo.entity.sell.mapper;

import com.example.demo.entity.sell.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.ws.rs.DELETE;
import java.util.List;
import java.util.Map;

/**
 * Created by hutingcong on 2017/11/1.
 */
@Repository
public interface ProductCategoryMapper {

    //通过map写入
    @Insert("insert into product_category(category_name,category_type) values (#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    //通过对象写入
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    //查单挑数据
    @Select("select * from product_category where category_type=#{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    //查多条数据
    @Select("select * from product_category where category_name=#{categoryName}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    //根据字段更新数据
    @Update("update product_category set category_name=#{categoryName,jdbcType=VARCHAR} where category_type=#{categoryType,jdbcType=INTEGER}")
    int updateCategory(@Param("categoryType") Integer categoryType,@Param("categoryName") String categoryName);

    //根据对象更新数据
    @Update("update product_category set category_name=#{categoryName,jdbcType=VARCHAR} where category_type=#{categoryType,jdbcType=INTEGER}")
    int updateByObject(ProductCategory productCategory);

    //删除数据
    @Delete("delete from product_category where category_type=#{categoryType,jdbcType=INTEGER}")
    int deleteByCategoryType(Integer categoryType);


    //使用XML文件查询
    ProductCategory selectByCategoryType(Integer categoryType);
}
