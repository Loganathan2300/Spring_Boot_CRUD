package com.school.details.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.details.entity.School;
import com.school.details.service.SchoolService;


@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
	@GetMapping("/school")
	public List<School> retrieveSchool() {
		return this.schoolService.retrieveSchool();
	}
	
	@GetMapping("/school/{schoolid}")  
	public School getSchool(@PathVariable("schoolid") Long schoolid){  
	return schoolService.getSchoolById(schoolid);  
	}  
	 
	@PostMapping("/school")
	public School createSchool(@RequestBody School school) {
		return this.schoolService.createSchool(school);
	}
	
	@PutMapping("/school")  
	public School update(@RequestBody School school){  
		schoolService.saveOrUpdate(school);  
	    return school;  
	} 
	
	@PutMapping("/school/{id}")
    public School update(@PathVariable("id") Long id, @RequestBody School school) throws AccountNotFoundException {
        return this.schoolService.updates(id, school);
    } 
	
	@DeleteMapping("/school/{id}")
    public Map<String, String> removeById(@PathVariable("id") Long id) {
        Map<String, String> response=new HashMap<>();
        response.put("message",this.schoolService.removeSchool(id));
        return response;
    } 
	
	@DeleteMapping("/school/{schoolid}")  
	public void deleteSchool(@PathVariable("schoolid") Long schoolid){  
		schoolService.delete(schoolid);	
	} 
}
