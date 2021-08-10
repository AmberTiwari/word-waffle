package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Hangman;
import com.bean.HangmanData;
import com.bean.User;

public interface HangmanDaoInt {

	public ArrayList<HangmanData> getAllRecords() throws SQLException, ClassNotFoundException, IOException;
	public Hangman getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean checkuser(User user) throws ClassNotFoundException, SQLException, IOException;
	public boolean insertHangman(User user) throws SQLException, ClassNotFoundException, IOException;
	public boolean updateHangman(User user) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Hangman> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
