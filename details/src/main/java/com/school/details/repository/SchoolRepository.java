package com.school.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.details.entity.School;



public interface SchoolRepository extends JpaRepository<School,Long> {

}
