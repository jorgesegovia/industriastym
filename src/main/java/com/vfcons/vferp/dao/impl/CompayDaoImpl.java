package com.vfcons.vferp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vfcons.vferp.dao.CompanyDao;
import com.vfcons.vferp.domain.Company;
import com.vfcons.vferp.persistence.CompanyMapper;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
@Repository
public class CompayDaoImpl extends SqlSessionDaoSupport implements CompanyDao {

	@Autowired
	public CompayDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Company insert(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company findById(Integer idCompany) {
		CompanyMapper cmpMapper = getSqlSession()
				.getMapper(CompanyMapper.class);
		return cmpMapper.findById(idCompany);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		CompanyMapper cmpMapper = getSqlSession()
				.getMapper(CompanyMapper.class);

		return cmpMapper.findAll();
	}

}
