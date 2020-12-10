package com.scraping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scraping.model.AmazonData;
import com.scraping.services.AmazonService;

@RestController
public class AmazonController {
	@Autowired
    private AmazonService amazonservice;
	
	@RequestMapping(value = "/LoadData", method = RequestMethod.GET)
	public List<AmazonData> getData() {
		//return "Hi";
		//this.amazonservice.AmazonLoadData();
		return amazonservice.amazonLoadData();
	}

}
