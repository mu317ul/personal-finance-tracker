package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transcation")
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date")
    private String date;
	
	@Column(name="amount")
    private double amount;
	
	@Column(name="type")
    private String type; // INCOME or EXPENSE
	
	@Column(name="category")
    private String category;
	
	@Column(name="description")
    private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Transaction(Long id, String date, double amount, String type, String category, String description) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.category = category;
		this.description = description;
	}
	public Transaction() {
		
	}
}
