package com.vfcons.vferp.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vfcons.vferp.domain.User;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public class VFerpUserDetailService implements UserDetailsService {

	private static final Logger logger = LogManager
			.getLogger(VFerpUserDetailService.class.getName());

	private HashMap<String, User> memory = new HashMap<String, User>();

	public VFerpUserDetailService() {
		memory.put("jorge", new User("jorge", "123", "jsegoviad@gmail.com",
				Arrays.asList("admin", "free")));
		memory.put("victor", new User("victor", "123", "vfelipe@gmail.com",
				Arrays.asList("free")));
	}

	public UserDetails loadUserByUsername(String nameUser)
			throws UsernameNotFoundException {

		logger.debug("Validating User {} ", nameUser);

		if (!memory.containsKey(nameUser)) {
			throw new UsernameNotFoundException("No user found with username: "
					+ nameUser);
		}

		User user = memory.get(nameUser);

		logger.debug("User found {} ", nameUser);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPw().toLowerCase(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getGrantedAuthorities(user.getRoles()));
	}

	private static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
