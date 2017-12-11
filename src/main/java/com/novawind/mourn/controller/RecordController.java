package com.novawind.mourn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*  
* @author Jeremy Xiong<br>
* 2017-12-07 09:44:41
*/
@RequestMapping("/record")
@Controller
public class RecordController {
	
	
	@RequestMapping("/module/query")
	public String queryRecordModule(){
		
		
		return "queryRecord";
	}
	
	@RequestMapping("/module/add")
	public String addRecordModule(){
		
		
		return "addRecord";
	}
}

