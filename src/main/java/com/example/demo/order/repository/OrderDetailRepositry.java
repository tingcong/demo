package com.example.demo.order.repository;

import com.example.demo.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hutingcong on 2017/10/11.
 */
public interface OrderDetailRepositry extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
