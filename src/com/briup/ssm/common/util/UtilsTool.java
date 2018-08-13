package com.briup.ssm.common.util;

public class UtilsTool {
	
	/**   判断字符串是否为空白
	* @param:@param string 判断的字符串
	* @return：Boolean 
	* @throws：异常描述
	*/
	public static boolean isBlank(String string){
		String str = string.trim();
		if (str==null||str.equals("")) {
			return true;
		}
		return false;
	}
	
}
