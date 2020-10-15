package com.mft.general.service.imp;

import com.mft.general.entities.FUser;
import com.mft.general.service.CurrentUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.stream.Collectors;

@Component
public class CurrentUserDefault implements CurrentUser {

	/**
	 *
	 * @return
	 */
	@Override
	public FUser currentUser() {
		try {
			FUser user = new FUser();
			if (SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
				UsernamePasswordAuthenticationToken userPassAuth = (UsernamePasswordAuthenticationToken) SecurityContextHolder
						.getContext().getAuthentication();
				user = (FUser) userPassAuth.getPrincipal();
			} else {
				OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
						.getAuthentication();
				HashMap<String, Object> details = (HashMap<String, Object>) authentication.getUserAuthentication()
						.getDetails();
				if (details == null) {
					user.setUsername(authentication.getUserAuthentication().getPrincipal().toString());
				} else {
					HashMap<String, Object> principal = (HashMap<String, Object>) details.get("principal");
					user.setId(Long.parseLong(principal.get("id").toString()));
					user.setUsername(principal.get("userName").toString());
				}
			}
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean isAdmin() {
		OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
				.getAuthentication();
		return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())
				.contains("ROLE_ADMINUSER");
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String getToken() {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken userPassAuth = (UsernamePasswordAuthenticationToken) SecurityContextHolder
					.getContext().getAuthentication();
			return "bearer "  /*((FUser) userPassAuth.getPrincipal()).getToken()*/;
		} else {
			OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
					.getAuthentication();
			OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
			return details.getTokenType() + " " + details.getTokenValue();
		}

	}

	/**
	 *
	 * @return
	 */
	@Override
	public String[] getAuthorities() {
		//TODO: return authorities of user current.
		return null;
	}

	/**
	 *
	 * @param role
	 * @return
	 */
	@Override
	public Boolean hasRole(String role) {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken userPassAuth = (UsernamePasswordAuthenticationToken) SecurityContextHolder
					.getContext().getAuthentication();
			FUser user = (FUser) userPassAuth.getPrincipal();
			for (GrantedAuthority auth : user.getAuthorities()) {
				if (auth.getAuthority().equals(role)) {
					return true;
				}
			}
			return false;
		} else {
			OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
					.getAuthentication();
			return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList()).contains(role);
		}
	}
}
