package com.fintech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fintech.model.Transaction;
import com.fintech.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository repo;

	// Save transaction
	public Transaction save(Transaction t) {
		return repo.save(t);
	}

	// Get all transactions
	public List<Transaction> getAll() {
		return repo.findAll();
	}

	// Get total income
	public Double getTotalIncome() {
		return repo.getTotalIncome() != null ? repo.getTotalIncome() : 0;
	}

	// Get total expense
	public Double getTotalExpense() {
		return repo.getTotalExpense() != null ? repo.getTotalExpense() : 0;
	}

	// Get net balance
	public Double getNetBalance() {
		return getTotalIncome() - getTotalExpense();
	}

	public List<Transaction> getByType(String type) {
		return repo.findByTypeIgnoreCase(type);
	}

	public List<Transaction> getByCategory(String category) {
		return repo.findByCategoryIgnoreCase(category);
	}

	public List<Transaction> getByDateRange(LocalDate start, LocalDate end) {
		return repo.findByDateBetween(start, end);
	}
}
