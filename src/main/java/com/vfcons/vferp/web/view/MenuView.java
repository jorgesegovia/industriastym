package com.vfcons.vferp.web.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import static com.vfcons.vferp.web.view.constant.PagesConstant.*;
import static com.vfcons.vferp.web.view.util.ControllersUtil.*;

/**
 * 
 * @author jsegovia
 * @version 1.0, 22/06/15
 *
 */
@Named
@ViewScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = -7211914778684417026L;

	private static final Logger logger = LogManager.getLogger(MenuView.class
			.getName());

	/**
	 * Variables
	 */
	private MenuModel menuModel;

	private String textTofind;

	@PostConstruct
	public void init() {
		menuModel = buildMenu();
	}

	/**
	 * Actions
	 */

	private DefaultMenuModel buildMenu() {
		DefaultMenuModel menuModel = new DefaultMenuModel();

		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Ventas");

		DefaultMenuItem firstItem = new DefaultMenuItem("Registrar Ventas");
		firstItem.setCommand("#{menuView.redirectUser}");
		firstItem.setIcon("ui-icon-disk");

		firstSubmenu.addElement(firstItem);

		DefaultMenuItem secondItem = new DefaultMenuItem("Buscar Ventas");
		secondItem.setCommand("#{menuView.redirectUser}");
		secondItem.setIcon("ui-icon-arrowrefresh-1-w");

		firstSubmenu.addElement(secondItem);

		menuModel.addElement(firstSubmenu);

		DefaultSubMenu securitySubmenu = new DefaultSubMenu("Seguridad");

		DefaultMenuItem securityItem = new DefaultMenuItem("Registrar Usuario");
		securityItem.setCommand("#{menuView.redirectSecurity}");
		securityItem.setIcon("ui-icon-person");
		securityItem.setAjax(false);

		securitySubmenu.addElement(securityItem);

		menuModel.addElement(securitySubmenu);

		logger.debug("Menu construido correctamente");

		return menuModel;
	}

	public void redirectUser() {
		redirectPage(SEC_ADMIN_USERS_PAGE);
	}

	public String redirectSecurity() {
		return "security/adminUsers";
	}

	// public void findInMenu(AjaxBehaviorEvent e) {
	//
	// logger.debug("e {}", e.getSource());
	//
	// menuModel = buildMenu();
	//
	// String coincidence = textTofind.toLowerCase();
	//
	// logger.debug("Texto a buscar -> {}", coincidence);
	//
	// if (Strings.isBlank(coincidence)) {
	// return;
	// }
	//
	// List<MenuElement> melements = menuModel.getElements();
	//
	// logger.debug("Tamanio menuModel -> {}", melements.size());
	//
	// if (melements.isEmpty()) {
	// return;
	// }
	//
	// Iterator<MenuElement> itElements = melements.iterator();
	//
	// while (itElements.hasNext()) {
	//
	// MenuElement melementCurrent = itElements.next();
	//
	// logger.debug("iteracion -> {}", melementCurrent);
	//
	// if (melementCurrent instanceof DefaultSubMenu) {
	//
	// DefaultSubMenu subMenu = (DefaultSubMenu) melementCurrent;
	//
	// if (subMenu.getElementsCount() > 0) {
	// removeItemsWithOutCoincidence(subMenu, coincidence);
	// }
	//
	// if (subMenu.getElementsCount() == 0) {
	// itElements.remove();
	// }
	// }
	// }
	// }
	//
	// private void removeItemsWithOutCoincidence(DefaultSubMenu subMenu,
	// String titleToFind) {
	//
	// List<MenuElement> melements = subMenu.getElements();
	//
	// Iterator<MenuElement> itElements = melements.iterator();
	//
	// logger.debug("validate coincidence submenu -> {} : {}",
	// subMenu.getLabel(), titleToFind);
	//
	// while (itElements.hasNext()) {
	//
	// MenuElement melementCurrent = itElements.next();
	//
	// logger.debug("hijo -> {}", melementCurrent);
	//
	// if (melementCurrent instanceof DefaultMenuItem) {
	//
	// String titleItem = ((DefaultMenuItem) melementCurrent)
	// .getTitle().toLowerCase();
	// logger.debug("Title item: {}", titleItem);
	//
	// boolean isNotFound = !titleItem.contains(titleToFind);
	//
	// if (isNotFound) {
	// logger.debug("Coincidence found: {}", titleItem);
	// itElements.remove();
	// }
	// }
	// }
	// }

	/**
	 * Getters an Setters
	 */

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public String getTextTofind() {
		return textTofind;
	}

	public void setTextTofind(String textTofind) {
		this.textTofind = textTofind;
	}

}
