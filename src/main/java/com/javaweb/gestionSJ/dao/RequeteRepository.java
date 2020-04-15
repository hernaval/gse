package com.javaweb.gestionSJ.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.javaweb.gestionSJ.entities.Requete;

public interface RequeteRepository extends JpaRepositoryImplementation<Requete, String> {

    @Query("select req from Requete req where req.nomReq like :param  ")
    public ArrayList<Requete> searchObj(@Param("param")String param);

    @Query("select act from Requete act where act.dateTraitement  >= :date1 and act.dateTraitement <= :date2 ")
	public  Page<Requete> findByIntervalDate(@Param("date1")String date1,@Param("date2")String date2,Pageable page);
	

}
