package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Transaction;
import com.example.demo.repositary.TransactionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TransactionController {
	
	@Autowired
    private TransactionRepository transRepository;
	
	@GetMapping("/transaction")
	public List<Transaction> getAllTransaction()
	{
		return transRepository.findAll();
	}
	
	@PostMapping("/transaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transRepository.save(transaction);
	}
	
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTransaction(@PathVariable Long id)
	{
		Transaction trans= transRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :"+id ));
		
		transRepository.delete(trans);
		Map<String, Boolean> response= new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
