package com.springboot.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="developers_details")
public class Developers_details {
	@Id
	private int id;
	private String name;
	private String email;
	private int salary;
   
}
