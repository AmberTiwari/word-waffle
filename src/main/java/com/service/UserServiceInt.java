package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.User;
import com.bean.UserHistory;

public interface UserServiceInt {

	public boolean insertUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<UserHistory> getUserHistory(User user) throws ClassNotFoundException, SQLException, IOException;
	public User findUser(int id) throws ClassNotFoundException, SQLException, IOException;
}
