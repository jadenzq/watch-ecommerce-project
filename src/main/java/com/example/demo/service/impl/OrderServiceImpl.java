package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.OrderService;

import jakarta.transaction.Transactional;

@Service 
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepo;
	
	public OrderServiceImpl(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrderById(Long id) {
		orderRepo.deleteById(id);
	}
}
