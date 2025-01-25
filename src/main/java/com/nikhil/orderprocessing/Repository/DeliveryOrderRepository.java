package com.nikhil.orderprocessing.Repository;


import com.nikhil.orderprocessing.Entities.DeliveryOrder;
import com.nikhil.orderprocessing.enums.DeliveryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
    List<DeliveryOrder> findByDeliveryStatus(DeliveryStatus status);
    Long countByDeliveryStatus(DeliveryStatus status);
    Page<DeliveryOrder> findByDeliveryStatus(DeliveryStatus status, Pageable pageable);

}
