package com.vfcons.vferp.web.view.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import com.vfcons.vferp.domain.Company;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
@FacesConverter("companyConverter")
public class CompanyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value == null || value.trim().length() == 0) {
			return null;
		}

		if (!(uic instanceof SelectOneMenu)) {
			return null;
		}

		List<UIComponent> childrens = ((SelectOneMenu) uic).getChildren();

		if (childrens == null) {
			return null;
		}

		UISelectItems itemsSelectOneMenu = null;

		for (UIComponent children : childrens) {
			if (children instanceof UISelectItems) {
				itemsSelectOneMenu = (UISelectItems) children;
				break;
			}
		}

		if (itemsSelectOneMenu == null) {
			return null;
		}

		Object valueItem = itemsSelectOneMenu.getValue();

		if (valueItem == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		List<Company> companies = (List<Company>) valueItem;
		for (Company company : companies) {
			if (value.equals(company.getName())) {
				return company;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Company) object).getName());
		} else {
			return null;
		}
	}

}
