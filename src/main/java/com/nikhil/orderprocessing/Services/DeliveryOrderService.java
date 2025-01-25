package com.nikhil.orderprocessing.Services;


import com.nikhil.orderprocessing.Entities.DeliveryOrder;
import com.nikhil.orderprocessing.Repository.DeliveryOrderRepository;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryOrderService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    public DeliveryOrder addOrder(DeliveryOrder order) {
        order.setCreatedAt(LocalDateTime.now());
        return deliveryOrderRepository.save(order);
    }

    public List<DeliveryOrder> getOrdersByStatus(DeliveryStatus status) {
        return deliveryOrderRepository.findByDeliveryStatus(status);
    }

    public Page<DeliveryOrder> getOrdersByStatusWithPagination(DeliveryStatus status, int page, int size) {
        return deliveryOrderRepository.findByDeliveryStatus(status, PageRequest.of(page, size));
    }
}