package com.song.user.controller;

import com.song.user.pojo.User;
import com.song.user.service.UserService;
import com.song.user.utils.PageResult;
import com.song.user.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-demo")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getAllUserList", method = RequestMethod.GET)
	public List<User> getAllUserList() {
		return userService.getAllUserList();
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public User getUserById(Integer id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Result addUser(@RequestBody User user) {
		Result result = new Result();
		try {
			userService.addUser(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("添加失败");
		}
		return result;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Result updateUser(@RequestBody User user) {
		Result result = new Result();
		try {
			userService.updateUser(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("修改失败");
		}
		return result;
	}

	@RequestMapping(value = "/deleteUserByIds", method = RequestMethod.GET)
	public Result deleteUserByIds(Integer[] ids) {
		Result result = new Result();
		try {
			userService.deleteUserByIds(ids);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("删除失败");
		}
		return result;
	}

	@RequestMapping(value = "/getUserPage", method = RequestMethod.GET)
	public PageResult getUserPage(Integer pageNum, Integer pageSize) {
		return userService.getUserPage(pageNum, pageSize);
	}
}
