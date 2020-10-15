package com.mft.general.service;

import com.mft.general.entities.FUser;

public interface CurrentUser {

	FUser currentUser();

	String getToken();

	String[] getAuthorities();

	Boolean hasRole(String role);
	
	boolean isAdmin();
}
