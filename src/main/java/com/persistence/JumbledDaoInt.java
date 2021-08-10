package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Jumbled;
import com.bean.JumbledData;
import com.bean.User;

public interface JumbledDaoInt {

	public ArrayList<JumbledData> getAllRecords() throws SQLException, ClassNotFoundException, IOException;
	public Jumbled getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean insertJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Jumbled> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
