package org.okcoder.app.task_result.config.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AccountDetailsService implements UserDetailsService {

	private AccountProperties properties;
	private PasswordEncoder passwordEncoder;

	public AccountDetailsService(AccountProperties properties, PasswordEncoder passwordEncoder) {
		this.properties = properties;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = this.properties.getPassword().getOrDefault(username, "");

		if (StringUtils.isEmpty(password)) {
			throw new UsernameNotFoundException("user not found");
		}
		AccountDetails accountDetails = new AccountDetails(username, this.passwordEncoder.encode(password));
		return accountDetails;
	}

}
