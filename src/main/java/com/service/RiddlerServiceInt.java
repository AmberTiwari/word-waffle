package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Riddler;
import com.bean.RiddlerQueAns;
import com.bean.User;

public interface RiddlerServiceInt {

	public RiddlerQueAns pickFromRiddlerDataList(int i) throws SQLException, ClassNotFoundException, IOException;
	public boolean insertRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Riddler> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
