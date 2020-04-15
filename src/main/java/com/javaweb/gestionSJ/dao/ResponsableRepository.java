package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.Responsable;

public interface ResponsableRepository extends JpaRepositoryImplementation<Responsable, String> {
	@Query("select resp.nom_resp,count(resp.code_resp) from Activite act join act.responsable resp group by resp.nom_resp  ")
	public ArrayList<String> statByResp();

	@Query("select resp.nom_resp,count(resp.code_resp) from Activite act join act.responsable resp where act.date_act >= :per1 and act.date_act <= :per2 group by resp.nom_resp  ")
	public ArrayList<String> statActRespPer(@Param("per1")String per1,@Param("per2")String per2);
	
	@Query("select resp.nom_resp, count(resp.code_resp) from Activite act inner join act.responsable resp inner join act.faitmarquant fmq where fmq.date_liv_fmq between :date1 and :date2 group by resp.nom_resp  ")
	public ArrayList<String> statFmqResp(@Param("date1")String date1,@Param("date2")String date2);
	
	@Query("select resp.nom_resp from Responsable resp where resp.code_resp = :code")
	public String getLogUser(@Param("code")String code);
}
