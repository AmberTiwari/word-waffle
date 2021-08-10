package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.Jumbled;
import com.bean.Riddler;
import com.bean.RiddlerData;
import com.bean.User;
import com.helper.Conn;

@Repository
public class RiddlerDao implements RiddlerDaoInt {
	@Override
	public ArrayList<RiddlerData> getAllRecords() throws SQLException, ClassNotFoundException, IOException {

		ArrayList<RiddlerData> words = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from riddlerdata where rid >= 1");
		ResultSet resultset = statement.executeQuery();

		RiddlerData riddlerData = null;
		words = new ArrayList<RiddlerData>();

		while (resultset.next()) {
			riddlerData = new RiddlerData();
			riddlerData.setRID(resultset.getInt("rid"));
			riddlerData.setrQue(resultset.getString("rque"));
			riddlerData.setrAns(resultset.getString("rans"));
			words.add(riddlerData);
		}

		connection.close();

		return words;
	}

	@Override
	public Riddler getRecordsUsingUID(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Riddler riddler = null;
		PreparedStatement statement = connection.prepareStatement("select * from riddler where user_uid = ?");
		statement.setInt(1, user.getUid());
		ResultSet resultset = statement.executeQuery();
		if (resultset.next()) {
			riddler = new Riddler();
			riddler.setUser_UID(resultset.getInt("User_uid"));
			riddler.setTScore(resultset.getInt("TScore"));
			riddler.setRiddlerData_RID(resultset.getInt("riddlerdata_rid"));
			connection.close();
		}
		return riddler;
	}

	@Override
	public boolean insertRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Riddler riddler = getRecordsUsingUID(user);
		PreparedStatement statement = connection.prepareStatement("insert into riddler values(?,?,?)");
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
	public boolean updateRiddler(User user, int totalScore) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		Riddler riddler = getRecordsUsingUID(user);
		PreparedStatement statement = connection
				.prepareStatement("update riddler set TScore = ? , Riddlerdata_RID = ? where user_uid = ?");
		statement.setInt(1, totalScore);
		statement.setInt(2, (riddler.getRiddlerData_RID() + 1));
		statement.setInt(3, riddler.getUser_UID());

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
	public ArrayList<Riddler> getLeaderBoard() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Riddler> leaders = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from riddler order by TScore desc limit 5");
		ResultSet resultset = statement.executeQuery();

		Riddler rg = null;
		leaders = new ArrayList<Riddler>();

		while (resultset.next()) {
			rg = new Riddler();
			rg.setUser_UID(resultset.getInt("user_uid"));
			rg.setTScore(resultset.getInt("TScore"));
			leaders.add(rg);
		}

		connection.close();

		return leaders;

	}
}
