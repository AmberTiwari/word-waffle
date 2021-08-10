package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Riddler;
import com.bean.RiddlerData;
import com.bean.User;

public interface RiddlerDaoInt {

	public ArrayList<RiddlerData> getAllRecords() throws SQLException, ClassNotFoundException, IOException;
	public Riddler getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean insertRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Riddler> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
