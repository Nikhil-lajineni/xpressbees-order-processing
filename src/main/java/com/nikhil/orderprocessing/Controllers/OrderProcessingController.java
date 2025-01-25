package com.nikhil.orderprocessing.Controllers;


import com.nikhil.orderprocessing.Services.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderProcessingController {

    @Autowired
    private OrderProcessingService orderProcessingService;

    @PostMapping("/process")
    public void processOrders() {
        orderProcessingService.processOrders();
    }
}