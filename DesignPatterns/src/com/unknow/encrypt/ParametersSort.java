package com.unknow.encrypt;

import java.util.ArrayList;

public class ParametersSort {
	public static ArrayList GetSortArray(ArrayList alt) {
		// ArrayList resultAlt = new ArrayList();
		String str = "";
		for (int i = 0; i < alt.size(); i++) {
			for (int j = 0; j < alt.size() - 1; j++) {
				// true = i <=j
				if (!StringSortAsc(alt.get(j).toString(), alt.get(j + 1)
						.toString())) {
					str = alt.get(j).toString();
					alt.set(j, alt.get(j + 1));
					alt.set(j + 1, str);
				}
			}
		}
		return alt;
	}

	public static Boolean StringSortAsc(String bStr, String eStr) {

		for (int i = 0; i < bStr.length(); i++) {
			if (eStr.length() > i) {
				// 如果当前字母相等则继续下个循环
				if (AscChar(bStr.charAt(i)) == AscChar(eStr.charAt(i))) {
					continue;
				}

				// 如果当前字母小于则代表beforeStr小于endStr
				if (AscChar(bStr.charAt(i)) < AscChar(eStr.charAt(i))) {
					return true;
				}
				// 如果beforeStr比endStr大 则返回false
				if (AscChar(bStr.charAt(i)) > AscChar(eStr.charAt(i))) {
					return false;
				}
			}
			// 如果上面字符都小于或者相等,前面字符长于后面字符,则代表比他大,
			if (bStr.length() > eStr.length()) {
				return false;
			}
		}
		return true;
	}

	public static int AscChar(char s) {
		return (int) s;
	}
}