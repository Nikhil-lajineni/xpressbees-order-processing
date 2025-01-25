package com.nikhil.orderprocessing.Services;

import com.nikhil.orderprocessing.Entities.DeliveryOrder;
import com.nikhil.orderprocessing.Repository.DeliveryOrderRepository;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class OrderProcessingService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void processOrders() {
        List<DeliveryOrder> pendingOrders = deliveryOrderRepository.findByDeliveryStatus(DeliveryStatus.PENDING);

        for (DeliveryOrder order : pendingOrders) {
            executorService.submit(() -> processOrder(order));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processOrder(DeliveryOrder order) {
        synchronized (order) {
            if (order.getDeliveryStatus() == DeliveryStatus.PENDING) {
                order.setDeliveryStatus(DeliveryStatus.IN_PROGRESS);
                deliveryOrderRepository.save(order);

                try {
                    // Simulate delivery time
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                order.setDeliveryStatus(DeliveryStatus.DELIVERED);
                deliveryOrderRepository.save(order);
            }
        }
    }
}