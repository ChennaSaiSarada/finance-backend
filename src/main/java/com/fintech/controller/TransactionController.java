package com.fintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fintech.model.Transaction;
import com.fintech.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;

	// Create transaction
	@PostMapping
	public String create(@RequestBody Transaction t, @RequestParam String role) {

		if (!role.equals("ADMIN")) {
			return "Access Denied: Only ADMIN can create transactions";
		}

		service.save(t);
		return "Transaction Created";
	}

	// Get all transactions
	@GetMapping
	public Object getAll(@RequestParam String role) {

		if (role.equals("ADMIN") || role.equals("ANALYST") || role.equals("VIEWER")) {
			return service.getAll();
		}

		return "Access Denied";
	}

	// Get total income
	@GetMapping("/income")
	public Object getIncome(@RequestParam String role) {

		if (role.equals("ADMIN") || role.equals("ANALYST")) {
			return service.getTotalIncome();
		}

		return "Access Denied";
	}

	// Get total expense
	@GetMapping("/expense")
	public Object getExpense(@RequestParam String role) {

		if (role.equals("ADMIN") || role.equals("ANALYST")) {
			return service.getTotalExpense();
		}

		return "Access Denied";
	}

	// Get total balance
	@GetMapping("/balance")
	public Object getBalance(@RequestParam String role) {

		if (role.equals("ADMIN") || role.equals("ANALYST")) {
			return service.getNetBalance();
		}

		return "Access Denied";
	}

	@GetMapping("/filter")
	public Object filter(@RequestParam(required = false) String type, @RequestParam(required = false) String category,
			@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate,
			@RequestParam String role) {

		// Only ADMIN & ANALYST allowed
		if (!(role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("ANALYST"))) {
			return "Access Denied";
		}

		// Filter by type
		if (type != null) {
			return service.getByType(type);
		}

		// Filter by category
		if (category != null) {
			return service.getByCategory(category);
		}

		// Filter by date range
		if (startDate != null && endDate != null) {
			return service.getByDateRange(java.time.LocalDate.parse(startDate), java.time.LocalDate.parse(endDate));
		}
		System.out.println("Type: " + type);
		System.out.println("Category: " + category);
		System.out.println("Start: " + startDate);
		System.out.println("End: " + endDate);

		return "No filter applied";
	}
}