package com.vfcons.vferp.web.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.vfcons.vferp.domain.User;
import com.vfcons.vferp.service.LoginService;
import com.vfcons.vferp.service.constant.LoginServiceConstant;
import com.vfcons.vferp.service.exception.LoginServiceException;

import static com.vfcons.vferp.web.view.constant.PagesConstant.*;
import static com.vfcons.vferp.web.view.util.ControllersUtil.*;

/**
 * 
 * @author jsegovia
 * @version 1.0, 23/06/15
 *
 */
@Named
@RequestScoped
public class LoginView extends SpringBeanAutowiringSupport implements
		Serializable {

	private static final long serialVersionUID = -8989968344550605535L;

	private static final Logger logger = LogManager.getLogger(LoginView.class);

	@Autowired
	private LoginService loginService;

	/**
	 * Variables
	 */

	private User user;

	/**
	 * Constructor
	 */

	@PostConstruct
	public void construct() {
		user = new User();
	}

	/**
	 * Actions and Events
	 */

	public void login() {
		try {
			logger.debug("Doing login");
			logger.debug("Doing login 2");

			loginService.verifyUser(user);

			redirectPage(MAIN_PAGE);

		} catch (LoginServiceException e) {
			if (LoginServiceConstant.CODE_USER_PASS_NOT_FOUND == e
					.getErrorCode()) {
				stackMessages(FacesMessage.SEVERITY_ERROR, e.getMessage());
				user = new User();
			} else {
				logger.error(e);
			}
		}
	}


	/**
	 * Getters an Setters
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
