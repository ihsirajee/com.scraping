package com.scraping.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scraping.model.AmazonData;
import com.scraping.dao.AmazonRepository;

@Service
public class AmazonService {
	
	@Autowired AmazonRepository amazonRepository;
	
	public List<AmazonData> amazonLoadData(){
		List<AmazonData> AmzDataList = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.amazon.com/Earbud-In-Ear-Headphones/b?ie=UTF8&node=12097478011").get();
			Elements EarBudTitles = doc.select("h2 > a.a-text-normal"); 
			Elements EarBudAmounts = doc.select("span.a-offscreen"); 
			AmazonData AmzData = new AmazonData();
			System.out.println(EarBudAmounts.text()+"\n");
			
			
			int id = 1;
			    for(Element EarBudTitle:EarBudTitles) {
			    	
			    	 for(Element EarBudAmount:EarBudAmounts) {
			    		    AmzData.setId(id);
			    			AmzData.setProductTitle(EarBudTitle.text());
			    			AmzData.setProductPrice(EarBudAmount.text());
			    			AmzDataList.add(AmzData);
			    	        //System.out.println(EarBudAmount.text()+"\n");
			    	 }
			    	 id = id + 1;
		        }
			    amazonRepository.saveAll(AmzDataList);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return AmzDataList;
		
	}
}
