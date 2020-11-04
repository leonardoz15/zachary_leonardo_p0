package BankingManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import BankingManagement.pojos.Account;

public class AccountServiceImpl implements AccountService {
	
	private static Logger log = Logger.getRootLogger();
	Scanner scan = new Scanner(System.in);
	
	CustomCacheServiceImpl<Account> cache = new CustomCacheServiceImpl<>();
	
	public AccountServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Checks if user exists in the cache based on login information
	 */
	@Override
	public Account authenticate(String name, String password) {
		
		
		for (Account inCache : cache.retrieveAllItems()) {
			if (inCache.getName().equals(name) & inCache.getPassword().equals(password)) {
				return inCache;
			}
		}
		System.out.println("Failed to authenticate, incorrect name / password.");
		log.warn("Failed login attempt");
		return null;
		
	}

	/*
	 *  Creates a new account and adds to cache
	 */
	@Override
	public void createAccount(String name, String password) {
		Random r = new Random();
		int id = (r.nextInt(100));
		Account account = new Account(name, password, id);
		cache.addToCache(account);
		System.out.println("Created new account " + account.toString());
		log.info("Successfully created new account" + account.toString());
		
	}
	
	/*
	 *  Authenticates and then removes account from cache
	 */
	@Override
	public void removeAccount(String name, String password) {
		
		Account toRemove = authenticate(name,password);
		cache.removeFromCache(toRemove);
		
	}
	
}
