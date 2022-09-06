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
    //1
	public void createDeveloper(Developers_details devloper) throws SQLException {
		query = "insert into developers_details(id,name,email) values(" + devloper.getId() + ",'" + devloper.getName()
				+ "','" + devloper.getEmail() +"','" + devloper.getSalary() +")";
		st.executeUpdate(query);
	}
    //2
	public void updateDeveloper(Developers_details dev) throws SQLException {
		query = "update developers_details set name ='" + dev.getName() + "', email = '" + dev.getEmail()+ "', salary = '" + dev.getSalary()
				+ "' where id = " + dev.getId();
		st.executeUpdate(query);

	}
	//3
	public void deleteDeveloper(int id) throws SQLException {
		query="delete from developers_details where id = "+ id;
		st.execute(query);
	}
	//4
	public Developers_details getDeveloperById(int id) throws SQLException {
		query = "select * from developers_details where id = " + id;
		ResultSet rs = st.executeQuery(query);
		Developers_details developer = new Developers_details();
		if (rs != null) {
			while (rs.next()) {
				developer.setId(rs.getInt("id"));
				developer.setName(rs.getString("name"));
				developer.setEmail(rs.getString("email"));
				developer.setSalary(rs.getInt("salary"));
			}
		}
		return developer;
	}
	//5
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
				dev.setSalary(rs.getInt("salary"));
			developers.add(dev);
			}
			return developers;
		}
		return null;
	}
	//6
	public ArrayList<Developers_details> orderByDesc() throws SQLException {
		query="select * from developers_details ORDER BY name DESC";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Developers_details> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Developers_details dev = new Developers_details();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setEmail(rs.getString("email"));
				dev.setSalary(rs.getInt("salary"));
				developers.add(dev);
			}
			return developers;
		}
		return null;
	}
	//7
	public ArrayList<Developers_details> orderByASC() throws SQLException {
		query="select * from developers_details ORDER BY name";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Developers_details> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Developers_details dev = new Developers_details();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setEmail(rs.getString("email"));
				dev.setSalary(rs.getInt("salary"));
				developers.add(dev);
			}
			return developers;
		}
		return null;
	}
	//8
	public ArrayList<Developers_details> orderByDescSalary() throws SQLException {
		query="select * from developers_details ORDER BY salary DESC";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Developers_details> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Developers_details dev = new Developers_details();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setEmail(rs.getString("email"));
				dev.setSalary(rs.getInt("salary"));
				developers.add(dev);
			}
			return developers;
		}
		return null;
	}
	//9
	public ArrayList<Developers_details> orderByASCSalary() throws SQLException {
		query="select * from developers_details ORDER BY salary";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Developers_details> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Developers_details dev = new Developers_details();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setEmail(rs.getString("email"));
				dev.setSalary(rs.getInt("salary"));
				developers.add(dev);
			}
			return developers;
		}
		return null;
	}
	//10
	public ArrayList<String> upperCaseName() throws SQLException {
		query="select UPPER(name) AS name from developers_details";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
			developers.add(rs.getString("name"));
			}
			return developers;
		}
		return null;
	}
	//11
	public ArrayList<String> LowerCaseName() throws SQLException {
		query="select LOWER(name) AS name from developers_details";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
			}
			return developers;
		}
		return null;
	}
	//12
	public ArrayList<String> lessThan10000() throws SQLException {
		query="select name,salary from developers_details where salary <=10000 ";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
			developers.add(rs.getString("name"));
			developers.add(String.valueOf(rs.getInt("salary")));
			}
			return developers;
		}
		return null;
	}
	//13
	public ArrayList<String> between10to20k() throws SQLException {
		query="select name,salary from developers_details where salary BETWEEN 10000 AND 20000 ";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
			developers.add(rs.getString("name"));
			developers.add(String.valueOf(rs.getInt("salary")));
			}
			return developers;
		}
		return null;
	}
	//14
	public ArrayList<String> greaterThan50k() throws SQLException {
		query="select name,salary from developers_details where salary >50000 ";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
				developers.add(String.valueOf(rs.getInt("salary")));
			}
			return developers;
		}
		return null;
	}
	//15
	public ArrayList<String> nameStartWithS() throws SQLException {
		query="select name from developers_details where name like 's%'";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
			}
			return developers;
		}
		return null;
	}
	//16
	public ArrayList<String> nameStartWithH() throws SQLException {
		query="select name from developers_details where name like 'h%'";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
			}
			return developers;
		}
		return null;
	}
	//17
	public ArrayList<String> gmail() throws SQLException {
		query="select name,email from developers_details where email like '%@gmail%'";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
				developers.add(rs.getString("email"));
			}
			return developers;
		}
		return null;
	}
	//18
	public ArrayList<String> outlook() throws SQLException {
		query="select name,email from developers_details where email like '%@outlook%'";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(rs.getString("name"));
				developers.add(rs.getString("email"));
			}
			return developers;
		}
		return null;
	}
	//19
	public ArrayList<String> avgSalary() throws SQLException {
		query="select AVG(salary) AS salary from developers_details";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(String.valueOf(rs.getInt("salary")));
			}
			return developers;
		}
		return null;
	}
	//20
	public ArrayList<String> overAllSalary() throws SQLException {
		query="select SUM(salary) AS salary from developers_details";
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> developers = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				developers.add(String.valueOf(rs.getInt("salary")));
			}
			return developers;
		}
		return null;
	}

	}
