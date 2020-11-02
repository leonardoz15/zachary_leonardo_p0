package BankingManagment.Service;

import java.util.Scanner;

import BankingManagment.pojos.Account;

public class AccountServiceImpl implements AccountService {

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
		return null;
		
	}

	/*
	 *  Creates a new account and adds to cache
	 */
	@Override
	public void createAccount(String name, String password) {
		
		int id = (int)Math.random()* 100;
		Account account = new Account(name, password, id);
		cache.addToCache(account);
		
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