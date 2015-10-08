package com.vfcons.vferp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vfcons.vferp.dao.UserDao;
import com.vfcons.vferp.domain.User;
import com.vfcons.vferp.persistence.UserMapper;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public User insert(User newUser) {
		UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
		userMapper.insert(newUser);
		return newUser;
	}

	@Override
	public void modify(User user) {
		UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
		userMapper.modify(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByName(String userName) {
		UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
		return userMapper.findByName(userName);
	}

	@Override
	public Integer count() {
		UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
		return userMapper.count();
	}

	@Override
	public List<User> findAll(Integer minIndex, Integer maxIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyLastLogin(User user) {
		UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
		userMapper.modifyLastLogin(user);
	}

}
