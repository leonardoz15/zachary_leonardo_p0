package BankingManagement.service;

import java.util.Scanner;

import BankingManagement.pojos.Account;

public class BankingServiceImpl implements BankingService {

	Scanner scan = new Scanner(System.in);
	
	CustomCacheServiceImpl<Account> cache = new CustomCacheServiceImpl<>();	
	
	public BankingServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Add funds to designated account
	 */
	@Override
	public void deposit(Account account, int amount) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Take funds out of designated account
	 */
	@Override
	public void withdrawl(Account account, int amount) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * return the balance of the designated account
	 */
	@Override
	public double retrieveBalance(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	 * Add funds to specified account in cache
	 */



}
