package com.javaweb.gestionSJ.dao;


import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.Activite;

public interface ActiviteRepository extends JpaRepositoryImplementation<Activite, String>  {
	@Query("select act from Activite act where act.date_act  >= :date1 and act.date_act <= :date2 ")
	public  Page<Activite> findByIntervalDate(@Param("date1")String date1,@Param("date2")String date2,Pageable page);
	
	@Query("select act from Activite act where act.object_act like trim(lower(:mc)) ")
	public ArrayList<Activite> searchObj(@Param("mc")String mc);
	
	@Query("select act from Activite act where act.code_act = :param")
	public Activite findParam(@Param("param")String param);
	
	//stat
	@Query("select act from Activite act join act.direction dir where dir.code_dir = :x ")
	public ArrayList<Activite> statByDir(@Param("x")String x);
	
	@Query("select act.date_act , count(act.code_act) from Activite act WHERE MONTH(act.date_act) = :param and YEAR(act.date_act) =2019   group by  act.date_act    ")
	public ArrayList<String> statPeriode(@Param("param")int param);
	
	

	//finier activite
	@Modifying
	@Query("update Activite act set etat_act = :value where act.code_act= :param ")
	 int updateState(@Param("value")String value,@Param("param")String param);
	
	
	
}
