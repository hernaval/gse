package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.Dim;

public interface DimRepository extends  JpaRepositoryImplementation<Dim, String>  {

	@Query("select d from Dim d where d.code_dim like :param")
	public ArrayList<Dim> findByMc(@Param("param")String param);
	
	@Query("select d from Dim d where d.date_dim between :date1 and :date2 ")
	public Page<Dim> findByInterval(@Param("date1")String date1,@Param("date2")String date2,Pageable page);
	
}
