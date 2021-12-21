package com.amdocs.bankapplication.service;

import com.amdocs.bankapplication.entity.Accounts;
import com.amdocs.bankapplication.entity.Users;
import com.amdocs.bankapplication.helperobject.ResponseMessage;

public interface BankApplicationService {
	
	public ResponseMessage saveUser(Users user);
	public ResponseMessage getUser(int userId);
	public ResponseMessage updateUser(int userID, Users user);
	public ResponseMessage updateAccount(int accountID, Accounts account);
	public ResponseMessage deleteUser(int userId);
	public ResponseMessage deleteAccount(int accountId);
	public ResponseMessage allUserDetails();
}
