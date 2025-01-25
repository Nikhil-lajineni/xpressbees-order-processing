package com.nikhil.orderprocessing.Services;


import com.nikhil.orderprocessing.Repository.DeliveryOrderRepository;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderStatusMonitoringService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    public Map<DeliveryStatus, Long> getOrderStatusCounts() {
        Map<DeliveryStatus, Long> statusCounts = new HashMap<>();
        for (DeliveryStatus status : DeliveryStatus.values()) {
            statusCounts.put(status, deliveryOrderRepository.countByDeliveryStatus(status));
        }
        return statusCounts;
    }
}