package com.song.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.song.user.mapper.UserMapper;
import com.song.user.pojo.User;
import com.song.user.pojo.UserExample;
import com.song.user.service.UserService;
import com.song.user.utils.PageResult;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> getAllUserList() {
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void deleteUserByIds(Integer[] ids) {
		for (Integer id : ids) {
			userMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult getUserPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<User> page = (Page<User>) userMapper.selectByExample(null);
		PageResult result = new PageResult();
		result.setRows(page.getResult());
		result.setTotal(page.getTotal());
		return result;
	}
}
