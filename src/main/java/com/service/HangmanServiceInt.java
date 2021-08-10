package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Hangman;
import com.bean.HangmanPattern;
import com.bean.User;

public interface HangmanServiceInt {

	public HangmanPattern pickRandomFromHangmanDataList() throws SQLException, ClassNotFoundException, IOException;
	public boolean hangmanGuessWord(String guess, HangmanPattern hangmanPattern, int count, User user)
			throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Hangman> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException;
}
