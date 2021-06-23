package com.javaweb.gestionSJ.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.javaweb.gestionSJ.entities.Application;

public interface ApplicationRepository extends JpaRepositoryImplementation<Application, String> {
}
