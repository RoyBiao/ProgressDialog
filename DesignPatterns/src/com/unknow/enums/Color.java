package com.unknow.enums;

public enum Color {
	RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);

	// ��Ա����
	private String name;
	private int index;

	// ���췽��
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// ��ͨ����
	public static String getName(int index) {
		for (Color c : Color.values()) {
			System.out.println(c.values());
			if (c.getIndex() == index) {
				System.out.println(c.getIndex()+c.getName());
				return c.name;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}