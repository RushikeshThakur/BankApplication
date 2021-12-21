package com.amdocs.bankapplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amdocs.bankapplication.dao.AccountRepository;
import com.amdocs.bankapplication.dao.UserRepository;
import com.amdocs.bankapplication.entity.Accounts;
import com.amdocs.bankapplication.entity.Users;
import com.amdocs.bankapplication.helperobject.ResponseMessage;

@Service
public class BankApplicationServiceImpl implements BankApplicationService {

	private static final Logger logger = LoggerFactory.getLogger(BankApplicationServiceImpl.class);
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private AccountRepository accountRepository;

	/*
	 * Method used to save the user
	 */
	public ResponseMessage saveUser(Users user) {
		try {
			Users userInfo = userrepository.save(user);
			return new ResponseMessage(userInfo, true, "User created successfully",HttpStatus.OK);
		}catch(Exception ex) {
			logger.error(ex.toString(),"Exception occured while creating the new user");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	/*
	 * Method used to get single user details
	 */
	public ResponseMessage getUser(int userId) {
		try {
			Users existingUser = userrepository.findById(userId).orElse(null);
			if (existingUser == null) {
				return new ResponseMessage(null, false, "User not present", HttpStatus.NOT_FOUND);
			}
			return new ResponseMessage(existingUser, true, "User details are", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.toString(),"Exception occured while getting user info");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 * Method used to updated user
	 */
	public ResponseMessage updateUser(int userID, Users user) {
		try {
			Users existingUser = userrepository.findById(userID).orElse(null);
			if (existingUser != null) {
				existingUser.setName(user.getName());
				existingUser.setEmailid(user.getEmailid());
				existingUser.setGender(user.getGender());
				existingUser.setSecondarymobile(user.getSecondarymobile());
				existingUser.setDob(user.getDob());
				existingUser.setAccounts(null);
				
				userrepository.save(existingUser);
				return new ResponseMessage(existingUser, true, "User updated successfully", HttpStatus.OK);
			}
			return new ResponseMessage(null, false, "User not present", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception ex) {
			logger.error(ex.toString(),"Exception occured while updating user info");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	/*
	 * Method used to updated account
	 */
	public ResponseMessage updateAccount(int accountID, Accounts account) {
		try {
			Accounts isAccountPresent = accountRepository.findById(accountID).orElse(null);
			if(isAccountPresent != null) {
				isAccountPresent.setBranchname(account.getBranchname());
				isAccountPresent.setAccounttype(account.getAccounttype());
				isAccountPresent.setAccountbalance(account.getAccountbalance());
				
				accountRepository.save(isAccountPresent);
				return new ResponseMessage(null, true, "Account updated successfully", HttpStatus.OK);
			}
			return new ResponseMessage(null, false, "Account not present..", HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			logger.error(ex.toString(),"Exception occured while updating account info");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Method used to delete user
	 */
	public ResponseMessage deleteUser(int userId) {
		try {
			Users isUserPresent = userrepository.findById(userId).orElse(null);
			if (isUserPresent != null) {
				userrepository.deleteById(userId);
				return new ResponseMessage(null, true, "user deleted successfully", HttpStatus.OK);
			}
			return new ResponseMessage(null, false, "User not present..", HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			logger.error(ex.toString(),"Exception occured while deleting user info");
			return new ResponseMessage(null, false, ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method used to delete account
	 */
	public ResponseMessage deleteAccount(int accountId) {
		try {
			Accounts isAccountPresent = accountRepository.findById(accountId).orElse(null);
			if(isAccountPresent != null) {
				accountRepository.deleteById(accountId);
				return new ResponseMessage(null, true, "Account deleted successfully", HttpStatus.OK);
			}
			return new ResponseMessage(null, false, "Account not present..", HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			logger.error(ex.toString(),"Exception occured while deleting account info");
			return new ResponseMessage(null, false, ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method is used to get details of all user
	 */
	public ResponseMessage allUserDetails() {
		try {
			List<Users> userdata = userrepository.findAll();
			if(userdata.isEmpty()) {
				return new ResponseMessage(null, false, "No user available",HttpStatus.NOT_FOUND);
			}
			return new ResponseMessage(userdata, true, "All user details are:",HttpStatus.OK);
		}catch(Exception ex) {
			logger.error(ex.toString(),"Exception occured while getting all user info");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
