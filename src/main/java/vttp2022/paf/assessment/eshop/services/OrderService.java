package vttp2022.paf.assessment.eshop.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.paf.assessment.eshop.exception.OrderException;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.repositories.LineItemRepository;

@Service
public class OrderService {

    @Autowired
    private Order oRepo;

    @Autowired 
    private LineItemRepository liRepo;


    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(Order o) throws OrderException {

        // Generate orderId
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        System.out.printf(">>>> OrderId: %s\n", orderId);

        o.setOrderId(orderId);

        oRepo.insertOrder(o);
        System.out.printf(">>>> order quantity: %s\n", o.getLineItems().size());
        if (o.getLineItems().size() > 5)
            throw new OrderException("Cannot order more than 5 items");
        // Create the associated line items
        liRepo.addLineItems(o.getLineItems(), orderId);

    }
}
