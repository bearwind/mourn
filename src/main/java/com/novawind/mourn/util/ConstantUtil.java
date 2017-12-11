package com.novawind.mourn.util;
/**
*  
* @author Jeremy Xiong<br>
* 2017-12-05 16:18:19
*/
public class ConstantUtil {
	
	public static final String View_Redirect = "redirect";
	public static final String View_Forward = "forward";
	public static final String EMPTY = "";
	public static final String UNDER_LINE = "_";
	public static final String MIDDLE_LINE = "-";
	public static final String TSV_DELIM = "\t";
	public static final String COMMA = ",";
	public static final String COLON = ":";
	public static final String SEMICOLON = ";";
	
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
}

