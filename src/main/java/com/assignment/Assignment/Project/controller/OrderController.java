package com.assignment.Assignment.Project.controller;

import com.assignment.Assignment.Project.model.*;
import com.assignment.Assignment.Project.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderHeaderRepository orderRepo;

    @Autowired
    private OrderItemRepository itemRepo;

    // 1. Create an Order (Updated Logic)
    @PostMapping
    public ResponseEntity<OrderHeader> createOrder(@RequestBody OrderHeader order) {
        // Save the OrderHeader first to generate the Order ID
        OrderHeader savedOrder = orderRepo.save(order);

        // If there are items, link them to the new Order ID and save them
        if (order.getOrderItems() != null && !order.getOrderItems().isEmpty()) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrderId(savedOrder.getOrder_id()); // Link item to the order
                itemRepo.save(item); // Save the item explicitly
            }
        }
        
        return ResponseEntity.ok(savedOrder);
    }

    // 2. Retrieve Order Details
    @GetMapping("/{id}")
    public ResponseEntity<OrderHeader> getOrder(@PathVariable Integer id) {
        return orderRepo.findById(id)
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Update an Order (e.g., Shipping Address)
    @PutMapping("/{id}")
    public ResponseEntity<OrderHeader> updateOrder(@PathVariable Integer id, @RequestBody OrderHeader details) {
        return orderRepo.findById(id).map(order -> {
            order.setShipping_contact_mech_id(details.getShipping_contact_mech_id());
            order.setBilling_contact_mech_id(details.getBilling_contact_mech_id());
            return ResponseEntity.ok(orderRepo.save(order));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. Delete an Order
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        return orderRepo.findById(id).map(order -> {
            orderRepo.delete(order);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. Add a single Order Item to an existing order
    @PostMapping("/{id}/items")
    public OrderItem addOrderItem(@PathVariable Integer id, @RequestBody OrderItem item) {
        item.setOrderId(id); // Link item to the order
        return itemRepo.save(item);
    }
    
 // 6. Update an Order Item (Scenario 3)
    @PutMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable Integer orderId,
            @PathVariable Integer itemId,
            @RequestBody OrderItem itemDetails) {
            
        return itemRepo.findById(itemId).map(item -> {
            item.setQuantity(itemDetails.getQuantity()); // Update quantity
            item.setStatus(itemDetails.getStatus());     // Update status
            return ResponseEntity.ok(itemRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 7. Delete an Order Item (Scenario 5)
    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<?> deleteOrderItem(
            @PathVariable Integer orderId,
            @PathVariable Integer itemId) {
            
        return itemRepo.findById(itemId).map(item -> {
            itemRepo.delete(item);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}