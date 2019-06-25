package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XKeahlianModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XKeahlianRepo;

@Controller
public class KeahlianController extends BaseController {
	
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XKeahlianRepo keahlianRepo;
	
	@GetMapping(value="/pelamar/keahlian/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		//view keahlian
		ModelAndView view = new ModelAndView("keahlian/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		//get keahlian
		List<XKeahlianModel> listKeahlian = this.keahlianRepo.findByBiodataId(biodataId);
		view.addObject("listKeahlian", listKeahlian);
		
		return view;
	}

}
