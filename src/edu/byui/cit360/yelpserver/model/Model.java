package edu.byui.cit360.yelpserver.model;

public class Model {
	
	private RecentSearches recentSearches = new RecentSearches();
	
	public Model() {
		
	}

	public RecentSearches getRecentSearches() {
		return recentSearches;
	}

	public void setRecentSearches(RecentSearches recentSearches) {
		this.recentSearches = recentSearches;
	}
	
}
