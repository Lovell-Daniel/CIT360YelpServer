package edu.byui.cit360.yelpserver.model;

import java.util.concurrent.LinkedBlockingQueue;

public class RecentSearches {
	private LinkedBlockingQueue<String> lastThree = new LinkedBlockingQueue<>(3);
	
	public RecentSearches() {
		
	}

	public String[] getLastThree() {
		return lastThree.toArray(new String[lastThree.size()]);
	}

	public void setLastThree(String last) {
		try {
			if (lastThree.remainingCapacity() > 0) {
				lastThree.put(last);
				persistLastThree();
			} else {
				lastThree.put(last);
				lastThree.take();
				persistLastThree();
			};
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void persistLastThree() {
		//figure out how to use Hibernate
	}
	
}
