package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.HangmanData;
import com.bean.User;
import com.bean.UserHistory;
import com.helper.Conn;

@Repository
public class UserDao implements UserDaoInt {
	@Override
	public boolean insertUser(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		PreparedStatement statement = connection.prepareStatement("insert into user values(?,?)");
		statement.setInt(1, user.getUid());
		statement.setString(2, user.getUname());
		int rows = statement.executeUpdate();
		if (rows > 0)
			return true;
		connection.close();
		return false;
	}

	@Override
	public boolean checkUser(User user) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = Conn.getInstance();
		PreparedStatement statement = connection.prepareStatement("select * from user where uid = ?");
		statement.setInt(1, user.getUid());
		ResultSet rs = statement.executeQuery();
		boolean status = rs.next();
		connection.close();
		return status;
	}

	@Override
	public ArrayList<UserHistory> getUserHistory(User user) throws SQLException, ClassNotFoundException, IOException {

		ArrayList<UserHistory> history = null;
		Connection connection = Conn.getInstance();

		PreparedStatement statement = connection.prepareStatement("select * from user_logs where u_id = ?");
		statement.setInt(1, user.getUid());
		ResultSet resultset = statement.executeQuery();

		UserHistory his = null;
		history = new ArrayList<UserHistory>();

		while (resultset.next()) {
			his = new UserHistory();
			his.setU_ID(resultset.getInt("u_id"));
			his.setT_Score(resultset.getInt("t_score"));
			his.setTime(resultset.getString("entry_time"));
			his.setGameName(resultset.getString("game_name"));
			history.add(his);
		}

		connection.close();

		return history;
	}
	public User findUser(int id) throws ClassNotFoundException, SQLException, IOException
	{
		User user = null;
		Connection connection = Conn.getInstance();
		PreparedStatement statement = connection.prepareStatement("select * from user where u_id = ?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		user = new User();
		while(resultSet.next())
		{
			user.setUid(resultSet.getInt(1));
			user.setUname(resultSet.getString(2));
		}
		connection.close();
		return user;
	}
}
