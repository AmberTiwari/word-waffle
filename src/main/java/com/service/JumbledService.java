package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Jumbled;
import com.bean.JumbledData;
import com.bean.JumbledQueAns;
import com.bean.User;
import com.persistence.JumbledDao;
import com.persistence.JumbledDaoInt;

@Service
public class JumbledService implements JumbledServiceInt {
	@Autowired
	private JumbledDaoInt jumbledDao;

	@Override
	public JumbledQueAns pickFromJumbledDataList(int i) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<JumbledData> words = jumbledDao.getAllRecords();
		String jQue = words.get(i).getjQue();
		String jAns = words.get(i).getjAns();
		JumbledQueAns jumbledQueAns = new JumbledQueAns(jQue, jAns);
		return jumbledQueAns;
	}

	@Override
	public boolean insertJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		return jumbledDao.insertJumbled(user, totalScore);
	}

	@Override
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException {
		return jumbledDao.checkUser(user);
	}

	@Override
	public boolean updateJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		return jumbledDao.updateJumbled(user, totalScore);
	}

	@Override
	public ArrayList<Jumbled> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		return jumbledDao.getLeaderBoard();
	}
}
