package com.wolken.wolkenapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wolken.wolkenapp.connection.Connect;
import com.wolken.wolkenapp.dto.PrisonDTO;

import com.*;

public class PrisonDAOImpl implements PrisonDAO {

	@Override
	public boolean insert(PrisonDTO pd) {
		// Connection con = null;

		try (Connection con = Connect.getConnect()) {

			// TODO Auto-generated method stub
			// PreparedStatement ps;
			try (PreparedStatement ps = con.prepareStatement("insert into wolken.prison values(?,?,?,?)");) {
				// ps = con.prepareStatement("insert into prison values(?,?,?,?)");
				ps.setInt(1, pd.getId());
				ps.setString(2, pd.getName());
				ps.setString(3, pd.getPlace());
				ps.setInt(4, pd.getNo_of_prisoners());
				ps.executeUpdate();
				ps.close();

			} // catch (SQLException e) {
				// TODO Auto-generated catch block
				// System.out.println("duplicate entry");
			Connect.getConnect();
			System.out.println("Inserted successfully");
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("duplicate entry");
			
		System.out.println(e.getMessage());
		}
		return false;

	}

	@Override
	public void display() throws SQLException {
		// Connection con = null;
		// Statement statement = null;
		// PreparedStatement preparedStatement = null;
		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Leela12345$$ ");) {
			System.out.println(con);
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Leela12345$$");
			// } catch (SQLException e) {
			// e.printStackTrace();
			// }

			// TODO Auto-generated method stub
			// ResultSet rs;
			try (PreparedStatement preparedStatement = con.prepareStatement("select * from prison");) {
				System.out.println(con);
				// preparedStatement = con.prepareStatement("select * from prison");
				try (ResultSet rs = preparedStatement.executeQuery();) {

					while (rs.next()) {
						int prisonId = rs.getInt(1);
						String prisonName = rs.getString("name");
						String prisonPlace = rs.getString("place");
						int prisoners = rs.getInt("prisoners");
						System.out.println(prisonId + " " + prisonName + " " + prisonPlace + " " + prisoners);
					}

				}
				preparedStatement.close();
			}
			con.close();
		}
	}

	@Override
	public boolean updatebyId(int prisonId, String prisonName) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		System.out.println(con);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Leela12345$$");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			preparedStatement = con.prepareStatement("update prison set name = ? " + "where Id = ?; ");
			preparedStatement.setString(1, prisonName);
			preparedStatement.setInt(2, prisonId);

			int noOfRowsAffected = preparedStatement.executeUpdate();

			if (noOfRowsAffected > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deletebyId(int prisonId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Leela12345$$");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			preparedStatement = con.prepareStatement("delete from prison where Id = ?; ");
			preparedStatement.setInt(1, prisonId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
