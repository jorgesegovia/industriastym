package com.vfcons.vferp.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.vfcons.vferp.dao.CompanyDao;
import com.vfcons.vferp.dao.UserDao;
import com.vfcons.vferp.domain.Company;
import com.vfcons.vferp.domain.User;
import com.vfcons.vferp.service.constant.LoginServiceConstant;
import com.vfcons.vferp.service.exception.LoginServiceException;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
@Service
public class LoginService extends SpringBeanAutowiringSupport implements
		Serializable {

	private static final long serialVersionUID = -8568741738170193433L;

	private static final Logger logger = LogManager
			.getLogger(LoginService.class.getName());

	@Autowired
	private UserDao userDao;

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	@Qualifier("encoder")
	private StandardPasswordEncoder encoder;

	public void verifyUser(User user) throws LoginServiceException {
		try {
			User userBd = userDao.findByName(user.getName());

			// String encoded = encoder.encode(user.getPw());
			// logger.debug(encoded);

			logger.debug("User: {}", user.getPw());

			if (userBd == null
					|| !encoder.matches(user.getPw(), userBd.getPw())) {
				throw new LoginServiceException(
						LoginServiceConstant.CODE_USER_PASS_NOT_FOUND,
						"Usuario o password no coinciden");
			}

			userDao.modifyLastLogin(userBd);

			logger.info("Validacion satisfactoria para usuario {}",
					user.getName());

		} catch (PersistenceException e) {
			logger.error(e);
			throw new LoginServiceException(
					LoginServiceConstant.CODE_SERVICE_ERROR, e.getMessage());
		}
	}

	public List<Company> getCompanies() throws LoginServiceException {
		try {
			List<Company> companies = companyDao.findAll();
			int amountCompanies = 0;

			if (companies != null) {
				amountCompanies = companies.size();
			}

			logger.debug("Obteniendo {} companias ", amountCompanies);

			return companies;

		} catch (PersistenceException e) {
			throw new LoginServiceException(
					LoginServiceConstant.CODE_SERVICE_ERROR, e.getMessage());
		}
	}

}
