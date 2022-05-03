package com.ericsson.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.restapi.entities.Course;

public interface DaoRepository extends JpaRepository<Course,Long>{

}
