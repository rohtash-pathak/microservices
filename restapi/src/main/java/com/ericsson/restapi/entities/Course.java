package com.ericsson.restapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Course")

public class Course {
	
	@Id
	private long id;
	
	private String title;
	private String description;
	
	

}
