package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Jumbled;
import com.bean.JumbledQueAns;
import com.bean.User;

public interface JumbledServiceInt {

	public JumbledQueAns pickFromJumbledDataList(int i) throws SQLException, ClassNotFoundException, IOException;
	public boolean insertJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Jumbled> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
