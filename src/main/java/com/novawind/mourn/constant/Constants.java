package com.novawind.mourn.constant;

import java.util.UUID;

/**
*  
* @author Jeremy Xiong<br>
* 2017-12-05 16:18:19
*/
public class Constants {
	
	public static final String View_Redirect = "redirect";
	public static final String View_Forward = "forward";
	public static final String EMPTY = "";
	public static final String UNDER_LINE = "_";
	public static final String MIDDLE_LINE = "-";
	public static final String TSV_DELIM = "\t";
	public static final String COMMA = ",";
	public static final String COLON = ":";
	public static final String SEMICOLON = ";";
	public static final String EQUALITY = "=";
	public static final long ONE_DAY_IN_MILLS = 1000 * 60 * 60 * 24L;
	public static final int ONE_DAY_IN_SECONDS = 60 * 60 * 24;
	public static final String ACCESS_TOKEN_KEY = "token";
	public static final String ACCESS_SERIES_KEY = "series";
	public static final String ADMIN_CACHE_NAME = "admin";
	public static final String UTF8 = "UTF-8";

	/**
	 * 
	 * @param requestMapping /path/to
	 * @return redirect:/path/to
	 */
	public static String redirect(String requestMapping){
		return View_Redirect + COLON + requestMapping;
	}

	/**
	 * 
	 * @param requestMapping /path/to
	 * @return forward:/path/to
	 */
	public static String forward(String requestMapping){
		return View_Forward + COLON + requestMapping;
	}

	public static String getSeries(Long id){
		return    id
				+ COLON
				+ UUID.randomUUID().toString().replaceAll(Constants.MIDDLE_LINE, Constants.EMPTY)
				+ System.currentTimeMillis();
	}

}

