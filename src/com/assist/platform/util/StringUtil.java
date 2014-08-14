package com.assist.platform.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author 王飞
 * @version 1.0
 */

public class StringUtil {

	public StringUtil() {
	}

	public static void main(String[] a) {
		// System.out.println("" + StringUtil.formatTime("20050811112233"));
		System.out.println(toSql("1,2,3"));
	}

	public static String getDataType(Object obj) {
		if (obj == null)
			return null;
		String type = obj.getClass().getName();
		int pos = type.lastIndexOf(".");
		if (pos >= 0)
			type = type.substring(pos + 1);
		return type;
	}

	/**
	 * 字符串替换函数
	 * 
	 * @param sBody
	 *            ：整体的字符串
	 * @param sFrom
	 *            ：将要被替换的字符串
	 * @param sTo
	 *            ：替换的目标字符串
	 * @return ：替换后的字符串
	 */
	public static String strReplace(String sBody, String sFrom, String sTo) {
		int i, j, k;
		i = 0;
		j = sFrom.length();
		k = sTo.length();
		while (sBody.indexOf(sFrom, i) != -1) {
			i = sBody.indexOf(sFrom, i);
			sBody = sBody.substring(0, i) + sTo + sBody.substring(i + j);
			i += k;
		}
		return sBody;
	}

	/**
	 * 将输入的字符串中的单撇号替换为数据库标识
	 * 
	 * @param sinput
	 *            输入的字符串
	 * @return 替换后的字符串
	 */
	public static String strToSafe(Object sinput) {
		if (sinput == null)
			return "";
		String input = (String) sinput;
		String val = strReplace(input, "'", "''");
		return val;
	}

	public static String getNow() {
		String s = "";
		java.util.Calendar now = java.util.Calendar.getInstance();
		int year = now.get(java.util.Calendar.YEAR);
		s += year;
		int month = now.get(java.util.Calendar.MONTH) + 1;
		if (month < 10)
			s += "0" + month;
		else
			s += month;
		int day = now.get(java.util.Calendar.DAY_OF_MONTH);
		if (day < 10)
			s += "0" + day;
		else
			s += day;
		int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
		if (hour < 10)
			s += "0" + hour;
		else
			s += hour;
		int minute = now.get(java.util.Calendar.MINUTE);
		if (minute < 10)
			s += "0" + minute;
		else
			s += minute;
		int second = now.get(java.util.Calendar.SECOND);
		if (second < 10)
			s += "0" + second;
		else
			s += second;
		return s;
	}

	public static String getMonth() {
		String s = "";
		java.util.Calendar now = java.util.Calendar.getInstance();
		int year = now.get(java.util.Calendar.YEAR);
		s += year;
		int month = now.get(java.util.Calendar.MONTH) + 1;
		if (month < 10)
			s += "0" + month;
		else
			s += month;
		return s;
	}

	public static String formatTime(String str) {
		String ret = "";
		String year = str.substring(0, 4);
		String month = str.substring(4, 6);
		String day = str.substring(6, 8);
		String hur = str.substring(8, 10);
		String min = str.substring(10, 12);
		String sec = str.substring(12, 14);
		ret = year + "-" + month + "-" + day + " " + hur + ":" + min + ":"
				+ sec;
		return ret;
	}

	public static String formatTimeWithMis(String str) {
		String ret = "";
		int pos = str.lastIndexOf(".");
		ret = str.substring(0, pos);
		return ret;
	}

	/**
	 * 取得文件后缀
	 * 
	 * @param name
	 * @return
	 */
	public static String getPostfix(String name) throws Exception {

		return name.substring(name.lastIndexOf("."), name.length());
	}

	/**
	 * 取得文件名
	 * 
	 * @param name
	 * @return
	 */
	public static String getFilename(String name) throws Exception {

		return name.substring(0, name.lastIndexOf("."));
	}

	/**
	 * 获取FILEXML属性值
	 * 
	 * @param fileXML
	 * @param attr
	 * @return
	 */
	public static String getFileXMLAttr(String fileXML, String attr)
			throws Exception {
		Document doc = XMLAdapter.loadXML(fileXML);
		Element root = doc.getDocumentElement();
		Element element = (Element) root.getElementsByTagName("File").item(0);

		String name = element.getAttribute(attr);
		return name;
	}

	/**
	 * 将 1,2,3 转化为 '1','2','3'
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static String toSql(String sql) {
		String[] s = sql.split(",");
		String result = "";
		for (String s1 : s) {
			result += "'" + s1 + "',";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static String subString(String str, int limit) {
		return subString(str, "...", limit);
	}

	public static String subString(String str, String suffix, int limit) {
		if (str.length() > limit) {
			return str.substring(0, limit) + suffix;
		}
		else {
			return str;
		}
	}
}