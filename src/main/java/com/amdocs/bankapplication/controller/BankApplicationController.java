package com.amdocs.bankapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.bankapplication.entity.Accounts;
import com.amdocs.bankapplication.entity.Users;
import com.amdocs.bankapplication.helperobject.ResponseMessage;
import com.amdocs.bankapplication.service.BankApplicationService;

@RestController
@RequestMapping("/user")
public class BankApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(BankApplicationController.class);

	@Autowired
	private BankApplicationService bankApplicationService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to bank application";
	}
	
	@GetMapping("/all")
	public ResponseMessage getAllUserDetails() {
		ResponseMessage response = bankApplicationService.allUserDetails();
		if (response.isSuccess()) {
			logger.info("All user info");
			return response;
		}
		return response;
	}
	

	@PostMapping("/create")
	public ResponseMessage createUser(@RequestBody Users user) {
		ResponseMessage response = bankApplicationService.saveUser(user);
		if (response.isSuccess()) {
			logger.info("New user created");
			return response;
		}
		return response;
	}

	@GetMapping("/get/{userID}")
	public ResponseMessage getUser(@PathVariable int userID) {
		ResponseMessage response = bankApplicationService.getUser(userID);
		if (response.isSuccess()) {
			logger.info("Get info of user");
			return response;
		}
		return response;
	}
	
	@PutMapping("/update/{userID}")
	public ResponseMessage updateUser(@PathVariable int userID, @RequestBody Users user) {
		ResponseMessage response = bankApplicationService.updateUser(userID, user);
		if (response.isSuccess()) {
			logger.info("User info updated");
			return response;
		}
		return response;
	}
	
	@PutMapping("/account/update/{accountID}")
	public ResponseMessage updateAccount(@PathVariable int accountID, @RequestBody Accounts account) {
		ResponseMessage response = bankApplicationService.updateAccount(accountID, account);
		if (response.isSuccess()) {
			logger.info("Account info updated");
			return response;
		}
		return response;
	}

	@DeleteMapping("/delete/{userID}")
	public ResponseMessage deleteUser(@PathVariable int userID) {
		ResponseMessage response = bankApplicationService.deleteUser(userID);
		if (response.isSuccess()) {
			logger.info("User info deleted");
			return response;
		}
		return response;
	}
	
	@DeleteMapping("/account/delete/{accountID}")
	public ResponseMessage deleteAccount(@PathVariable int accountID) {
		ResponseMessage response = bankApplicationService.deleteAccount(accountID);
		if (response.isSuccess()) {
			logger.info("Account info deleted");
			return response;
		}
		return response;
	}

}
