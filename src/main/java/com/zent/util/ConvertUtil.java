package com.zent.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
	public static java.sql.Date convertDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static Date convertDate(java.sql.Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		try {
			return sdf.parse(sdf.format(new Date(date.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
