package com.springboot.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springboot.jdbcTask.JdbcConnection;
import com.springboot.model.Developers_details;

@Repository
public class DevelopersRepository {

	private Connection con;
	private String query;
	private Statement st;

	public DevelopersRepository() throws SQLException {
		con = JdbcConnection.getConnection();
		st = con.createStatement();
	}

	public void createDeveloper(Developers_details devloper) throws SQLException {
		query = "insert into developers_details(id,name,email) values(" + devloper.getId() + ",'" + devloper.getName()
				+ "','" + devloper.getEmail() + "')";
		st.executeUpdate(query);
	}

	public void updateDeveloper(Developers_details dev) throws SQLException {
		query = "update developers_details set name ='" + dev.getName() + "', email = '" + dev.getEmail()
				+ "' where id = " + dev.getId();
		st.executeUpdate(query);

	}
	public void deleteDeveloper(int id) throws SQLException {
		query="delete from developers_details where id = "+ id;
		st.execute(query);
	}

	public Developers_details getDeveloperById(int id) throws SQLException {
		query = "select * from developers_details where id = " + id;
		ResultSet rs = st.executeQuery(query);
		Developers_details developer = new Developers_details();
		if (rs != null) {
			while (rs.next()) {
				developer.setId(rs.getInt("id"));
				developer.setName(rs.getString("name"));
				developer.setEmail(rs.getString("email"));
			}
		}
		return developer;
	}
	public ArrayList<Developers_details> getAllDevelopers() throws SQLException {
		query="select * from developers_details";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Developers_details> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Developers_details dev = new Developers_details();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setEmail(rs.getString("email"));
			developers.add(dev);
			}
			return developers;
		}
		return null;
	}

}
