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
				// �����ǰ��ĸ���������¸�ѭ��
				if (AscChar(bStr.charAt(i)) == AscChar(eStr.charAt(i))) {
					continue;
				}

				// �����ǰ��ĸС�������beforeStrС��endStr
				if (AscChar(bStr.charAt(i)) < AscChar(eStr.charAt(i))) {
					return true;
				}
				// ���beforeStr��endStr�� �򷵻�false
				if (AscChar(bStr.charAt(i)) > AscChar(eStr.charAt(i))) {
					return false;
				}
			}
			// ��������ַ���С�ڻ������,ǰ���ַ����ں����ַ�,����������,
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