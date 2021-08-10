package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.bean.UserHistory;
import com.persistence.UserDao;
import com.persistence.UserDaoInt;

@Service
public class UserService implements UserServiceInt{
	
	@Autowired
	private UserDaoInt userDao;
	@Override
	public boolean insertUser(User user) throws ClassNotFoundException, SQLException, IOException {
		return userDao.insertUser(user);
	}
	@Override
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException {
		return userDao.checkUser(user);
	}
	@Override
	public ArrayList<UserHistory> getUserHistory(User user) throws ClassNotFoundException, SQLException, IOException {
		return userDao.getUserHistory(user);
	}
	public User findUser(int id) throws ClassNotFoundException, SQLException, IOException {
		return userDao.findUser(id);
	}
}
