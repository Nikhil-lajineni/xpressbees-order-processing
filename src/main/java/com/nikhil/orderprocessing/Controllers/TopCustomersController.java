package com.nikhil.orderprocessing.Controllers;


import com.nikhil.orderprocessing.Services.TopCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class TopCustomersController {

    @Autowired
    private TopCustomersService topCustomersService;

    @GetMapping("/top")
    public List<Map.Entry<String, Long>> getTopCustomers() {
        return topCustomersService.getTopCustomers();
    }
}