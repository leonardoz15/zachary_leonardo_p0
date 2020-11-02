package BankingManagment.Service;

import java.util.Set;
import java.util.function.Predicate;

public interface CustomCacheService<T> {

	
	public void addToCache(T obj); 
	
	public void removeFromCache(T obj);
	
	public T retrieveItem(T obj);
	
	public void emptyCache();
	
	public boolean contains(T obj);
	
	public Set<T> retrieveAllItems();
	
	public Set<T> retrieveMatching(Predicate<T> p);
	
}
