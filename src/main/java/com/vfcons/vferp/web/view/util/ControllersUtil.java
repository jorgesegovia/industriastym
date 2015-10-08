package com.vfcons.vferp.web.view.util;

import java.io.File;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public class ControllersUtil {

	private static final Logger logger = LogManager
			.getLogger(ControllersUtil.class);

	private ControllersUtil() {
	}

	public static void redirectPage(String url) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();

			boolean hasSeparator = url.startsWith(File.separator);

			String pageToRedirect = hasSeparator ? (ec.getRequestContextPath() + url)
					: (ec.getRequestContextPath() + File.separator + url);

			ec.redirect(pageToRedirect);
			logger.debug("Redireccionando via Ajax hacia {}", pageToRedirect);
		} catch (IOException e) {
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}
	}

	public static void stackMessages(Severity sv, String detail) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(sv, null, detail);
		fc.addMessage(null, fm);
	}

	public static void stackMessages(Severity sv, String title, String detail) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(sv, title, detail);
		fc.addMessage(null, fm);
	}

}
