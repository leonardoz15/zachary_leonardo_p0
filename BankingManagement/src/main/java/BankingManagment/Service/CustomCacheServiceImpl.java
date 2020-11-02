package BankingManagment.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CustomCacheServiceImpl<T> implements CustomCacheService<T> {
	
	private Set<T> cache = new HashSet<T>();
	
	public CustomCacheServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomCacheServiceImpl(Set<T> cache) {
		super();
		this.cache = cache;
	}


	public void setCache(Set<T> cache) {
		this.cache = cache;
	}


	@Override
	public void addToCache(T obj) {
		cache.add(obj);
	}

	@Override
	public void removeFromCache(T obj) {
		cache.remove(obj);
		
	}

	@Override
	public T retrieveItem(T obj) {
		if(cache.contains(obj)) {
			for (T inSet : cache) {
				if (inSet.equals(obj)) {
					return inSet;
				}
			}
		}
		return null;
	}

	@Override
	public void emptyCache() {
		cache.clear();
	}

	@Override
	public boolean contains(T obj) {
		if( cache.contains(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Set<T> retrieveAllItems() {
		return cache;
	}

	@Override
	public Set<T> retrieveMatching(Predicate<T> p) {
		// TODO Auto-generated method stub
		return null;
	}

}
