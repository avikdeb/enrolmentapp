package com.avik.enrolmentapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avik.enrolmentapp.beans.Release;

public class ReleaseDAO {
	
	public ReleaseDAO() {
		
	}
	
	public List<Release> getAllReleases() {
		
		List<Release> releases = new ArrayList<Release>();
		
		return releases;
	}
	
	public Release getReleaseByName(String releasename) {
		
		Release release = new Release();
		
		return release;
	}
	
	public List<Release> getReleasesByDateRange(Date startdate, Date enddate) {
		
		List<Release> releases = new ArrayList<Release>();
		
		return releases;
	}

}
