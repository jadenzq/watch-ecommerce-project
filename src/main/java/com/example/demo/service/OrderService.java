package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderService {

	List<Order> getAllOrders();
	
	Order saveOrder(Order order);
	
	Order getOrderById(Long id);
	
	Order updateOrder(Order order);
	
	void deleteOrderById(Long id);
}