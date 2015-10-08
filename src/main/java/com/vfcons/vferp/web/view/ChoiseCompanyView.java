package com.vfcons.vferp.web.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.vfcons.vferp.domain.Company;
import com.vfcons.vferp.service.LoginService;
import com.vfcons.vferp.service.exception.LoginServiceException;

import static com.vfcons.vferp.web.view.constant.PagesConstant.*;
import static com.vfcons.vferp.web.view.util.ControllersUtil.*;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
@Named(value = "companyView")
@SessionScoped
public class ChoiseCompanyView extends SpringBeanAutowiringSupport implements
		Serializable {

	private static final Logger logger = LogManager
			.getLogger(ChoiseCompanyView.class);

	private static final long serialVersionUID = 7726901444635065829L;

	@Autowired
	private transient LoginService loginService;

	/**
	 * Variables
	 */

	private List<Company> companies;

	private int sizeCompanies;

	private Company selectedCompany;

	/**
	 * Constructor
	 */

	public ChoiseCompanyView() {

	}

	/**
	 * Actions and Events
	 */

	public void preRenderView() {
		boolean isPostBack = FacesContext.getCurrentInstance().isPostback();

		if (isPostBack) {
			return;
		}

		try {
			companies = loginService.getCompanies();

			sizeCompanies = (companies == null) ? 0 : companies.size();

			logger.debug("preRenderView ejecutado");
		} catch (LoginServiceException e) {
			logger.error(e);
		}
	}

	public void onSelectCompany() {
		logger.debug("company selected: {}", selectedCompany);
		redirectPage(MAIN_PAGE);
	}

	/**
	 * Getters and setters
	 */

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(Company selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public int getSizeCompanies() {
		return sizeCompanies;
	}

	public void setSizeCompanies(int sizeCompanies) {
		this.sizeCompanies = sizeCompanies;
	}

}
