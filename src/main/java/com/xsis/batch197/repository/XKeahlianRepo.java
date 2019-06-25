package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeahlianModel;

@Repository
public interface XKeahlianRepo extends JpaRepository<XKeahlianModel, Long>{
	public List<XKeahlianModel> findByBiodataId(Long biodataId);

}
