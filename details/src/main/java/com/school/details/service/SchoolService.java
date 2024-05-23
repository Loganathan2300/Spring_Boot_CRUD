package com.school.details.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.details.entity.School;
import com.school.details.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;
	
	
	public School createSchool(final School school) {
		return this.schoolRepository.save(school);
	}
	
//	getting the all data
	public List<School> retrieveSchool() {
		return this.schoolRepository.findAll();
	}
	
	//getting a specific record by using the method findById() 
	public School getSchoolById(Long id){
	    return schoolRepository.findById(id).get();  
	}  
	
	//saving a specific record  
	public void saveOrUpdate(School school){  
	 schoolRepository.save(school);  
	}  
	
	//deleting a specific record 
	public void delete(Long id){  
		schoolRepository.deleteById(id);  
	}  
	
	//updating a record
	public School updates(long id, School school) throws AccountNotFoundException { 
		 Optional <School> CollegeData=schoolRepository.findById(id);
		 if(CollegeData.isEmpty()) {
			 throw new AccountNotFoundException("User Not Found");
		 }
		 School finalCollege=CollegeData.orElseThrow();
		 if(school.getName()!=null) {
			 finalCollege.setName(school.getName());
		 }
		 if(school.getAddress1()!=null) {
			 finalCollege.setAddress1(school.getAddress1());
		 }
		 if(school.getAddress2()!=null) {
			 finalCollege.setAddress2(school.getAddress2());
		 }
		return this.schoolRepository.save(finalCollege);
	    }
	
	public String removeSchool(Long id) {
		Optional<School> optionalSchool = schoolRepository.findById(id);
		if(optionalSchool.isPresent()) {
			schoolRepository.deleteById(id);
			return "School Deleted..";
		}else {
			return "school_details not found...";
		}
	}
}
