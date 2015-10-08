package com.vfcons.vferp.web.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.vfcons.vferp.domain.User;
import com.vfcons.vferp.service.LoginService;

/**
 * 
 * @author jsegovia
 * @version 1.0, 01/07/15
 *
 */
@Named
@ViewScoped
public class UserView extends SpringBeanAutowiringSupport implements
		Serializable {

	private static final long serialVersionUID = 314858975176465584L;

	private static final Logger logger = LogManager.getLogger(UserView.class);

	/**
	 * Variables
	 */
	@Autowired
	private LoginService loginService;

	private User currentUser;

	private String secondPw;

	/**
	 * Constructor
	 */
	@PostConstruct
	public void init() {
		currentUser = new User();
		logger.debug("paso constructor");
		logger.debug(loginService);
	}

	/**
	 * Actions
	 */

	public void register() {
		logger.debug("nombre: "+currentUser.getName());
		logger.debug("pw: "+currentUser.getPw());
		logger.debug("pw2: "+secondPw);
		logger.debug("email: "+currentUser.getEmail());
		logger.debug("nombre: "+currentUser.getName());
	}

	/**
	 * Getters ans Setters
	 */

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getSecondPw() {
		return secondPw;
	}

	public void setSecondPw(String secondPw) {
		this.secondPw = secondPw;
	}

}
