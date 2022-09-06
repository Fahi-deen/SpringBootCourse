package com.springboot.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.model.Developers_details;
import com.springboot.repository.DevelopersRepository;

@Service
public class DeveloperService {

	private DevelopersRepository developersRepository;

	public DeveloperService(DevelopersRepository developersRepository) {
		super();
		this.developersRepository = developersRepository;
	}

	public String createDeveloper(Developers_details developer) throws SQLException {
		developersRepository.createDeveloper(developer);
		return "Developer Record Added Sucessfuly";
	}

	public Developers_details updateDeveloper(Developers_details developer, int id) throws SQLException {

		Developers_details updated_developer = developersRepository.getDeveloperById(id);
		updated_developer.setName(developer.getName());
		updated_developer.setEmail(developer.getEmail());
		developersRepository.updateDeveloper(updated_developer);
		return getDeveloperByID(id);

	}

	public Developers_details getDeveloperByID(int id) throws SQLException {
		return developersRepository.getDeveloperById(id);
	}

	public String deleteDeveloper(int id) throws SQLException {
		developersRepository.deleteDeveloper(id);
		return "Developer Record Deleted Sucessfully";
	}

	public ArrayList<Developers_details> getAllDevelopers() throws SQLException {
		ArrayList<Developers_details> allDeveloper = developersRepository.getAllDevelopers();
		return allDeveloper;
	}
	public ArrayList<Developers_details> orderByDesc() throws SQLException {
		ArrayList<Developers_details> allDeveloper = developersRepository.orderByDesc();
		return allDeveloper;
	}
	public ArrayList<Developers_details> orderByASC() throws SQLException {
		ArrayList<Developers_details> allDeveloper = developersRepository.orderByASC();
		return allDeveloper;
	}
	public ArrayList<Developers_details> orderByDescSalary() throws SQLException {
		ArrayList<Developers_details> allDeveloper = developersRepository.orderByDescSalary();
		return allDeveloper;
	}
	public ArrayList<Developers_details> orderByASCSalary() throws SQLException {
		ArrayList<Developers_details> allDeveloper = developersRepository.orderByASCSalary();
		return allDeveloper;
	}
	public ArrayList<String> upperCaseName() throws SQLException {
		ArrayList<String> allDeveloper = developersRepository.upperCaseName();
		return allDeveloper;
	}
	public ArrayList<String> LowerCaseName() throws SQLException {
		ArrayList<String> allDeveloper = developersRepository.LowerCaseName();
		return allDeveloper;
	}
	public ArrayList<String> lessThan10000() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.lessThan10000();
		return allDeveloper;
	}
	public ArrayList<String> between10to20k() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.between10to20k();
		return allDeveloper;
	}
	public ArrayList<String> greaterThan50k() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.greaterThan50k();
		return allDeveloper;
	}
	public ArrayList<String> nameStartWithS() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.nameStartWithS();
		return allDeveloper;
	}
	public ArrayList<String> nameStartWithH() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.nameStartWithH();
		return allDeveloper;
	}
	public ArrayList<String> gmail() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.gmail();
		return allDeveloper;
	}
	public ArrayList<String> outlook() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.outlook();
		return allDeveloper;
	}
	public ArrayList<String> avgSalary() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.avgSalary();
		return allDeveloper;
	}
	public ArrayList<String> overAllSalary() throws SQLException{
		ArrayList<String> allDeveloper = developersRepository.overAllSalary();
		return allDeveloper;
	}
}
