package com.nikhil.orderprocessing.Controllers;


import com.nikhil.orderprocessing.Services.OrderStatusMonitoringService;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderStatusMonitoringController {

    @Autowired
    private OrderStatusMonitoringService orderStatusMonitoringService;

    @GetMapping("/status-count")
    public Map<DeliveryStatus, Long> getOrderStatusCounts() {
        return orderStatusMonitoringService.getOrderStatusCounts();
    }
}