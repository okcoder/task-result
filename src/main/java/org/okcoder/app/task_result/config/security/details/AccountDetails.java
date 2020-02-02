package org.okcoder.app.task_result.config.security.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4013230893059609231L;
	
	String username;
	String password;
	
	public AccountDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("USER");
	}
	@Override
	public boolean isAccountNonExpired() {
        return true;
	}
	@Override
	public boolean isAccountNonLocked() {
        return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
        return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	

	
	

}
