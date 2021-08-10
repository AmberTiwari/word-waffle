package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Hangman;
import com.bean.HangmanData;
import com.bean.HangmanPattern;
import com.bean.User;
//import com.presentation.HangmanImage;
import com.persistence.HangmanDao;
import com.persistence.HangmanDaoInt;

@Service
public class HangmanService implements HangmanServiceInt{
	@Autowired
	private HangmanDaoInt hangmanDao;
	//@Autowired
	//private HangmanImage hangmanImage = new HangmanImage();

	@Override
	public HangmanPattern pickRandomFromHangmanDataList() throws SQLException, ClassNotFoundException, IOException {
		ArrayList<HangmanData> words = hangmanDao.getAllRecords();
		String word = words.get((int) (Math.random() * 20)).getWord();
		String asterisk = new String(new char[word.length()]).replace("\0", "*");
		HangmanPattern hangmanPattern = new HangmanPattern(word, asterisk);
		return hangmanPattern;
	}
	@Override
	public boolean hangmanGuessWord(String guess, HangmanPattern hangmanPattern, int count, User user)
			throws ClassNotFoundException, SQLException, IOException {
		String newasterisk = "";
		for (int i = 0; i < hangmanPattern.getWord().length(); i++) {
			if (hangmanPattern.getWord().charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (hangmanPattern.getAsterisk().charAt(i) != '*') {
				newasterisk += hangmanPattern.getWord().charAt(i);
			} else {
				newasterisk += "*";
			}
		}
		if (hangmanPattern.getAsterisk().equals(newasterisk)) {
			//hangmanImage.showHangmanImage(count);
		} else {
			hangmanPattern.setAsterisk(newasterisk);
		}
		if (hangmanPattern.getAsterisk().equals(hangmanPattern.getWord())) {
			if (hangmanDao.checkuser(user)) {
				if (hangmanDao.updateHangman(user)) {
					System.out.println("Updation Successful");
				} else {
					System.out.println("Updation Failure");
				}
			} else {
				hangmanDao.insertHangman(user);
			}
			return true;
		}

		return false;
	}
	@Override
	public ArrayList<Hangman> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		return hangmanDao.getLeaderBoard();
	}
}