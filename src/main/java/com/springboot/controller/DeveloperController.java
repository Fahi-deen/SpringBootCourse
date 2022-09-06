package com.springboot.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Developers_details;
import com.springboot.service.DeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	private DeveloperService developerService;

	public DeveloperController(DeveloperService developerService) {
		super();
		this.developerService = developerService;
	}

	@PostMapping("/add")
	public String addDeveloper(@RequestBody Developers_details developer) throws SQLException {
		return developerService.createDeveloper(developer);
	}

	@GetMapping("/{id}")
	public Developers_details retrieveDeveloperById(@PathVariable(value = "id") int id) throws SQLException {
		return developerService.getDeveloperByID(id);
	}

	@GetMapping("/all")
	public ArrayList<Developers_details> retrieveAllDevelopers() throws SQLException {
		return developerService.getAllDevelopers();
	}
	@GetMapping("/orderByDesc")
	public ArrayList<Developers_details> orderByDesc() throws SQLException {
		return developerService.orderByDesc();
	}
	@GetMapping("/orderByASC")
	public ArrayList<Developers_details> orderByASC() throws SQLException {
		return developerService.orderByASC();
	}
	@GetMapping("/orderByDescSalary")
	public ArrayList<Developers_details> orderByDescSalary() throws SQLException {
		return developerService.orderByDescSalary();
	}
	@GetMapping("/orderByASCSalary")
	public ArrayList<Developers_details> orderByASCSalary() throws SQLException {
		return developerService.orderByASCSalary();
	}

	@GetMapping("/upper")
	public ArrayList<String> upperCaseDevelopers() throws SQLException {
		return developerService.upperCaseName();
	}
	@GetMapping("/lower")
	public ArrayList<String> LowerCaseName() throws SQLException {
		return developerService.LowerCaseName();
	}

	@GetMapping("/lessThan10000")
	public ArrayList<String> lessthan10000() throws SQLException {
		return developerService.lessThan10000();
	}

	@GetMapping("/between10to20k")
	public ArrayList<String> between10to20k() throws SQLException {
		return developerService.between10to20k();
	}

	@GetMapping("/greaterThan50k")
	public ArrayList<String> greaterThan50k() throws SQLException {
		return developerService.greaterThan50k();
	}
	@GetMapping("/nameStartWithS")
	public ArrayList<String> nameStartWithS() throws SQLException {
		return developerService.nameStartWithS();
	}
	@GetMapping("/nameStartWithH")
	public ArrayList<String> nameStartWithH() throws SQLException {
		return developerService.nameStartWithH();
	}
	@GetMapping("/gmail")
	public ArrayList<String> gmail() throws SQLException {
		return developerService.gmail();
	}
	@GetMapping("/outlook")
	public ArrayList<String> outlook() throws SQLException {
		return developerService.outlook();
	}

	@PutMapping("/{id}")
	public Developers_details updateDeveloper(@RequestBody Developers_details developer,
			@PathVariable(value = "id") int id) throws SQLException {
		return developerService.updateDeveloper(developer, id);

	}

	@DeleteMapping("delete/{id}")
	public String removeDeveloper(@PathVariable(value = "id") int id) throws SQLException {
		return developerService.deleteDeveloper(id);
	}
	@GetMapping("/avgSalary") 
		public ArrayList<String> avgSalary()  throws SQLException{
			return developerService.avgSalary();
		}
	@GetMapping("/overAllSalary") 
	public ArrayList<String> overAllSalary()  throws SQLException{
		return developerService.overAllSalary();
	}
	}
