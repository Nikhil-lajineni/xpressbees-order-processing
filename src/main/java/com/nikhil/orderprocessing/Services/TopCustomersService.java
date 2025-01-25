package com.nikhil.orderprocessing.Services;


import com.nikhil.orderprocessing.Entities.DeliveryOrder;
import com.nikhil.orderprocessing.Repository.DeliveryOrderRepository;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TopCustomersService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    public List<Map.Entry<String, Long>> getTopCustomers() {
        List<DeliveryOrder> deliveredOrders = deliveryOrderRepository.findByDeliveryStatus(DeliveryStatus.DELIVERED);
        return deliveredOrders.stream()
                .collect(Collectors.groupingBy(DeliveryOrder::getCustomerName, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .collect(Collectors.toList());
    }
}