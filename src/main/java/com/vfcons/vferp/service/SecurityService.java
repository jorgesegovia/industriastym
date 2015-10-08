package com.vfcons.vferp.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.vfcons.vferp.dao.UserDao;

/**
 * 
 * @author jsegovia
 * @version 1.0, 23/05/15
 *
 */
@Service
public class SecurityService extends SpringBeanAutowiringSupport implements
		Serializable {

	private static final long serialVersionUID = 2542028772401348590L;

	private static final Logger logger = LogManager
			.getLogger(SecurityService.class.getName());

	@Autowired
	private UserDao userDao;

	public User findUser(Integer idUser) {
		return null;
	}

	public void saveUser(User user) {

	}

	public void removeUser(Integer idUser) {

	}

	public List<User> listActivesUser(Integer indxIni, Integer indxEnd) {
		return null;
	}
}
