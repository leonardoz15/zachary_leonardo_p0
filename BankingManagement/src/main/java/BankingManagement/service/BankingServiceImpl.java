package BankingManagement.service;

import java.util.ArrayList;
import java.util.Scanner;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;

public class BankingServiceImpl implements BankingService {

	Scanner scan = new Scanner(System.in);
	
	private CustomCacheServiceImpl<Banking> bankingCache = new CustomCacheServiceImpl<Banking>();	
	

	public BankingServiceImpl() {
		super();
	}
	
	public BankingServiceImpl(CustomCacheServiceImpl<Banking> bankingCache) {
		super();
		this.bankingCache = bankingCache;
	}

	/**
	 * @param bankingCache the bankingCache to set
	 */
	public void setBankingCache(CustomCacheServiceImpl<Banking> bankingCache) {
		this.bankingCache = bankingCache;
	}
	
	/*
	 * Add funds to designated account in banking cache
	 */
	@Override
	public void deposit(Account account, int amount) {
		
		for( Banking bank : bankingCache.retrieveAllItems()) {
			if(bank.getAccount().equals(account)) {
				bank.setCurrentBalance(bank.getCurrentBalance() + amount);
			}
			else {
				Banking newBank = new Banking(account,amount);
				bankingCache.addToCache(bank);	
			}
		}
	}
	
	/*
	 * Take funds out of designated account in banking cache
	 */
	@Override
	public void withdrawl(Account account, int amount) {
		for( Banking bank : bankingCache.retrieveAllItems()) {
			if(bank.getAccount().equals(account)) {
				bank.setCurrentBalance(bank.getCurrentBalance() - amount);
			}
			else {
				System.out.println("No account found");
			}
		}
		
	}
	
	/*
	 * return the balance of the designated account in banking cache
	 */
	@Override
	public double retrieveBalance(Account account) {
		for( Banking bank : bankingCache.retrieveAllItems()) {
			if(bank.getAccount().equals(account)) {
				return bank.getCurrentBalance();
			}
			else {
				System.out.println("No account found");
				return 0;
			}
		}
		return 0;
	}
	

}
