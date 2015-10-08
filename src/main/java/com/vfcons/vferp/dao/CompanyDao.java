package com.vfcons.vferp.dao;

import java.util.List;

import com.vfcons.vferp.domain.Company;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public interface CompanyDao {

	public Company insert(Company company);

	public void modify(Company company);

	public void delete(Company company);

	public Company findById(Integer idCompany);

	public Integer count();

	public List<Company> findAll();

}
