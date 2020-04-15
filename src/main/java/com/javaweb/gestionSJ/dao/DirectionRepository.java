package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.Direction;

public interface DirectionRepository extends JpaRepositoryImplementation<Direction, String> {
	
	@Query("select dir.code_dir,count(dir.code_dir) from Activite act join act.direction dir group by dir  ")
	public ArrayList<String> statByDir();

	@Query("select dir.code_dir,count(dir.code_dir) from Activite act join act.direction dir where act.date_act >= :per1 and act.date_act <= :per2 group by dir  ")
	public ArrayList<String> statActDirPer(@Param("per1")String per1,@Param("per2")String per2);
	
	@Query("select dir.lib_dir, count(dir.code_dir) from Activite act inner join act.direction dir inner join act.faitmarquant fmq where fmq.date_liv_fmq >= :date1 and fmq.date_liv_fmq <= :date2 group by dir.lib_dir ")
	public ArrayList<String> statFmqDir(@Param("date1")String date1,@Param("date2")String date2);
	
	
}


