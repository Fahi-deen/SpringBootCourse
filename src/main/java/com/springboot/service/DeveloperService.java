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
		allDeveloper.forEach((d) -> System.out.println(d));
		return allDeveloper;
	}
}
