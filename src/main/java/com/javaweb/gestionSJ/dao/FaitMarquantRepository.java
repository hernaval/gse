package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.FaitMarquant;

public interface FaitMarquantRepository extends JpaRepositoryImplementation<FaitMarquant, String> {
	@Query("select act.date_liv_fmq , count(act.code_fmq) from FaitMarquant act WHERE MONTH(act.date_liv_fmq) = :param and YEAR(act.date_liv_fmq) =2019   group by  act.date_liv_fmq    ")
	public ArrayList<String> statPeriode(@Param("param")int param);
	
	@Query("select fmq from FaitMarquant fmq where fmq.code_fmq like :param")
	public ArrayList<FaitMarquant> findByMc(@Param("param")String param);
	
	@Query("select fmq from FaitMarquant fmq where fmq.date_liv_fmq between :date1 and :date2")
	public Page<FaitMarquant>findByIntervalDate(@Param("date1")String date1,@Param("date2")String date2, Pageable page);
}
