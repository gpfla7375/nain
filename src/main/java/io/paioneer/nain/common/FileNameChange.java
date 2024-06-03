package io.paioneer.nain.common;

import java.text.SimpleDateFormat;

public class FileNameChange {

	public static String change(String originalFileName, 	String formatStr) {
		String renameFileName = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);

		renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));

		renameFileName += "." + originalFileName.substring(
								originalFileName.lastIndexOf(".") + 1);				
		return renameFileName;
	}
}
