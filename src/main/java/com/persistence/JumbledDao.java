package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.Hangman;
import com.bean.HangmanData;
import com.bean.Jumbled;
import com.bean.JumbledData;
import com.bean.User;
import com.helper.Conn;

@Repository
public class JumbledDao implements JumbledDaoInt {
	@Override
	public ArrayList<JumbledData> getAllRecords() throws SQLException, ClassNotFoundException, IOException {

		ArrayList<JumbledData> words = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from jumbleddata where jid >= 1");
		ResultSet resultset = statement.executeQuery();

		JumbledData jumbledData = null;
		words = new ArrayList<JumbledData>();

		while (resultset.next()) {
			jumbledData = new JumbledData();
			jumbledData.setJID(resultset.getInt("jid"));
			jumbledData.setjQue(resultset.getString("jque"));
			jumbledData.setjAns(resultset.getString("jans"));
			words.add(jumbledData);
		}

		connection.close();

		return words;
	}

	@Override
	public Jumbled getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Jumbled jumbled = null;
		PreparedStatement statement = connection.prepareStatement("select * from jwords where user_uid = ?");
		statement.setInt(1, user.getUid());
		ResultSet resultset = statement.executeQuery();
		if (resultset.next()) {
			jumbled = new Jumbled();
			jumbled.setUser_UID(resultset.getInt("User_uid"));
			jumbled.setTScore(resultset.getInt("TScore"));
			jumbled.setJumbledData_JID(resultset.getInt("jumbleddata_jid"));
			connection.close();
		}
		return jumbled;
	}

	@Override
	public boolean insertJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Jumbled jumbled = getRecordsUsingUID(user);
		PreparedStatement statement = connection.prepareStatement("insert into jwords values(?,?,?)");
		statement.setInt(1, user.getUid());
		statement.setInt(2, totalScore);
		statement.setInt(3, 1);

		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();

		return false;
	}

	@Override
	public boolean updateJumbled(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Jumbled jumbled = getRecordsUsingUID(user);
		PreparedStatement statement = connection
				.prepareStatement("update jwords set TScore = ? , Jumbleddata_JID = ? where user_uid = ?");
		statement.setInt(1, totalScore);
		statement.setInt(2, (jumbled.getJumbledData_JID() + 1));
		statement.setInt(3, jumbled.getUser_UID());

		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();

		return false;

	}

	@Override
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		PreparedStatement statement = connection.prepareStatement("select * from jwords where User_UID = ?");
		statement.setInt(1, user.getUid());
		ResultSet rs = statement.executeQuery();
		boolean status = rs.next();
		connection.close();
		return status;
	}

	@Override
	public ArrayList<Jumbled> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Jumbled> leaders = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from jwords order by TScore desc limit 5");
		ResultSet resultset = statement.executeQuery();

		Jumbled jg = null;
		leaders = new ArrayList<Jumbled>();

		while (resultset.next()) {
			jg = new Jumbled();
			jg.setUser_UID(resultset.getInt("user_uid"));
			jg.setTScore(resultset.getInt("TScore"));
			leaders.add(jg);
		}

		connection.close();

		return leaders;

	}
}
