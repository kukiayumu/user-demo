package com.song.user.service;

import com.song.user.pojo.User;
import com.song.user.utils.PageResult;
import com.song.user.utils.Result;

import java.util.List;

public interface UserService {

    public List<User> getAllUserList();
    
    public PageResult getUserPage(Integer pageNum,Integer pageSize);

    public User getUserById(Integer id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserByIds(Integer[] ids);
}
