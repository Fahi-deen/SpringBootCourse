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
	public Developers_details retrieveDeveloperById(@PathVariable(value = "id") int id ) throws SQLException {
		return developerService.getDeveloperByID(id);
	}
	@GetMapping("/all")
	public ArrayList<Developers_details> retrieveAllDevelopers() throws SQLException {
		return developerService.getAllDevelopers();
	}
    @PutMapping("/{id}")
    public Developers_details updateDeveloper(@RequestBody Developers_details developer,@PathVariable(value = "id") int id) throws SQLException {
		return developerService.updateDeveloper(developer, id);
    	
    }
    @DeleteMapping("delete/{id}")
    public String removeDeveloper(@PathVariable(value = "id") int id) throws SQLException {
    	return developerService.deleteDeveloper(id);
    }
}
