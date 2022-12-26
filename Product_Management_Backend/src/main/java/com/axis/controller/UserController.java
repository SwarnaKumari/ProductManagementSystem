package com.axis.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Transaction;
import com.axis.model.User;
import com.axis.service.ProductService;
import com.axis.service.TransactionService;
import com.axis.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;
    
    @PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
    
    @GetMapping("/getUserWithId/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
	}
    
    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
        transaction.setPurchaseDate(LocalDateTime.now());
         transactionService.saveTransaction(transaction);
         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllProduct")
	public ResponseEntity<?> getAllProduct() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}


}
