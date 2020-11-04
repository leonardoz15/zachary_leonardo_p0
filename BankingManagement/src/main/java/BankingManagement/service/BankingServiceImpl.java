package BankingManagement.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;

public class BankingServiceImpl implements BankingService {
	
	private static Logger log = Logger.getRootLogger();
	Scanner scan = new Scanner(System.in);
	
	private CustomCacheServiceImpl<Banking> bankingCache = new CustomCacheServiceImpl<Banking>();	
	

	public BankingServiceImpl() {
		super();
	}
	
	public BankingServiceImpl(CustomCacheServiceImpl<Banking> bankingCache) {
		super();
		this.bankingCache = bankingCache;
		bankingCache.emptyCache();
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
		setBankingCache(bankingCache);
		
		for( Banking bank : bankingCache.retrieveAllItems()) {
			if(bank.getAccount().equals(account)) {
				bank.setCurrentBalance(bank.getCurrentBalance() + amount);
				log.info("Added " + amount + " to account " + account.toString());
			}
			else {
				Banking newBank = new Banking(account,amount);
				bankingCache.addToCache(newBank);	
				log.info("Created new account with balance " + amount);
			}
		}
	}
	
	/*
	 * Take funds out of designated account in banking cache
	 */
	@Override
	public void withdrawl(Account account, int amount) {
		setBankingCache(bankingCache);

		for( Banking bank : bankingCache.retrieveAllItems()) {
			if(bank.getAccount().equals(account)) {
				bank.setCurrentBalance(bank.getCurrentBalance() - amount);
				log.info("Removed " + amount + " from account " + account.toString());
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
		setBankingCache(bankingCache);

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
