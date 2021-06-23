package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import com.javaweb.gestionSJ.entities.Incident;
import com.sun.xml.bind.v2.model.core.ID;

public interface IncidentRepository extends JpaRepositoryImplementation<Incident, String>  {
	@Query("select inc.date_deb_inc, count(inc.code_inc) from Incident inc  group by inc.date_deb_inc ")
	public ArrayList<String> statByInc();
	
	
	@Query("select inc.date_deb_inc, count(inc.code_inc) from Incident inc where inc.date_deb_inc >=:date1 and inc.date_deb_inc <= :date2  group by inc.date_deb_inc ")
	public ArrayList<String> statIncPer(@Param("date1")String date1,@Param("date2")String date2);
	
	@Query("select inc from Incident inc where inc.code_inc like :code")
	public ArrayList<Incident> searchCode(@Param("code")String code);
	
	@Query("select inc from Incident inc where inc.date_deb_inc > :date1 and inc.date_deb_inc < :date2  ")
	public Page<Incident> findByIntervalDate(@Param("date1")String date1,@Param("date2")String date2,Pageable pageable);
}
