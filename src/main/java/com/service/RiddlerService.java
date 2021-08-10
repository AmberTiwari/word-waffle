package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Riddler;
import com.bean.RiddlerData;
import com.bean.RiddlerQueAns;
import com.bean.User;
import com.persistence.RiddlerDao;
import com.persistence.RiddlerDaoInt;

@Service
public class RiddlerService implements RiddlerServiceInt {

	@Autowired
	private RiddlerDaoInt riddlerDao;

	@Override
	public RiddlerQueAns pickFromRiddlerDataList(int i) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<RiddlerData> words = riddlerDao.getAllRecords();
		String rQue = words.get(i).getrQue();
		String rAns = words.get(i).getrAns();
		RiddlerQueAns riddlerQueAns = new RiddlerQueAns(rQue, rAns);
		return riddlerQueAns;
	}

	@Override
	public boolean insertRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		return riddlerDao.insertRiddler(user, totalScore);
	}

	@Override
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException {
		return riddlerDao.checkUser(user);
	}

	@Override
	public boolean updateRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		return riddlerDao.updateRiddler(user, totalScore);
	}

	@Override
	public ArrayList<Riddler> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		return riddlerDao.getLeaderBoard();
	}
}
