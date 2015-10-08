package com.vfcons.vferp.persistence;

import java.util.List;

import com.vfcons.vferp.domain.User;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public interface UserMapper {

	public User insert(User newUser);

	public void modify(User user);

	public void modifyLastLogin(User user);

	public void delete(User user);

	public User findByName(String userName);

	public Integer count();

	public List<User> findAll(Integer minIndex, Integer maxIndex);

}
