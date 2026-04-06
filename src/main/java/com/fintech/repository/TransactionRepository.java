package com.fintech.repository;

import java.time.LocalDate;
import java.util.List;

import com.fintech.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'INCOME'")
	Double getTotalIncome();

	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'EXPENSE'")
	Double getTotalExpense();
	
	List<Transaction> findByTypeIgnoreCase(String type);

	List<Transaction> findByCategoryIgnoreCase(String category);

	List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);}
