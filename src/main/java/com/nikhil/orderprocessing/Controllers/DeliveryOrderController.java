package com.nikhil.orderprocessing.Controllers;


import com.nikhil.orderprocessing.Entities.DeliveryOrder;
import com.nikhil.orderprocessing.Services.DeliveryOrderService;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class DeliveryOrderController {

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @PostMapping
    public DeliveryOrder addOrder(@RequestBody DeliveryOrder order) {
        return deliveryOrderService.addOrder(order);
    }

    @GetMapping("/status")
    public List<DeliveryOrder> getOrdersByStatus(@RequestParam DeliveryStatus status) {
        return deliveryOrderService.getOrdersByStatus(status);
    }

    @GetMapping("/status/paginated")
    public Page<DeliveryOrder> getOrdersByStatusWithPagination(
            @RequestParam DeliveryStatus status,
            @RequestParam int page,
            @RequestParam int size) {
        return deliveryOrderService.getOrdersByStatusWithPagination(status, page, size);
    }
    }