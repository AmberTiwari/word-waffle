package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.bean.Hangman;
import com.bean.HangmanData;
import com.bean.User;
import com.helper.Conn;

@Repository
public class HangmanDao implements HangmanDaoInt {
	@Override
	public ArrayList<HangmanData> getAllRecords() throws SQLException, ClassNotFoundException, IOException {

		ArrayList<HangmanData> words = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from hangmandata");
		ResultSet resultset = statement.executeQuery();

		HangmanData hg = null;
		words = new ArrayList<HangmanData>();

		while (resultset.next()) {
			hg = new HangmanData();
			hg.setHID(resultset.getInt("hid"));
			hg.setWord(resultset.getString("hwords"));
			words.add(hg);
		}

		connection.close();

		return words;
	}

	@Override
	public Hangman getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Hangman hangman = null;
		PreparedStatement statement = connection.prepareStatement("select * from hangman where user_uid = ?");
		statement.setInt(1, user.getUid());
		ResultSet resultset = statement.executeQuery();
		if (resultset.next()) {
			hangman = new Hangman();
			hangman.setHangman_UID(resultset.getInt("User_uid"));
			hangman.setTScore(resultset.getInt("TScore"));
			hangman.setHangman_HID(resultset.getInt("hangmandata_hid"));
			connection.close();
		}
		return hangman;
	}

	@Override
	public boolean checkuser(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		PreparedStatement statement = connection.prepareStatement("select * from hangman where User_UID = ?");
		statement.setInt(1, user.getUid());
		ResultSet rs = statement.executeQuery();
		boolean status = rs.next();
		connection.close();
		return status;
	}

	@Override
	public boolean insertHangman(User user) throws SQLException, ClassNotFoundException, IOException {

		Connection connection = Conn.getInstance();
		Hangman hg = getRecordsUsingUID(user);
		PreparedStatement statement = connection.prepareStatement("insert into hangman values(?,?,?)");
		statement.setInt(1, user.getUid());
		statement.setInt(2, 10);
		statement.setInt(3, 1);

		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();

		return false;
	}

	@Override
	public boolean updateHangman(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Hangman hangman = getRecordsUsingUID(user);
		PreparedStatement statement = connection
				.prepareStatement("update hangman set Tscore = ?, HangmanData_HID = ? where user_uid= ?");
		statement.setInt(1, (hangman.getTScore() + 10));
		statement.setInt(2, (hangman.getHangman_HID() + 1));
		statement.setInt(3, hangman.getHangman_UID());
		boolean status = (statement.executeUpdate() > 0);
		connection.close();
		return status;

	}

	@Override
	public ArrayList<Hangman> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Hangman> leaders = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from hangman order by TScore desc limit 5");
		ResultSet resultset = statement.executeQuery();

		Hangman hg = null;
		leaders = new ArrayList<Hangman>();

		while (resultset.next()) {
			hg = new Hangman();
			hg.setHangman_UID(resultset.getInt("user_uid"));
			hg.setTScore(resultset.getInt("TScore"));
			leaders.add(hg);
		}

		connection.close();

		return leaders;

	}
}
