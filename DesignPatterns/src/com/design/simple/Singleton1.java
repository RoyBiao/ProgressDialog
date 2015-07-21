package com.design.simple;

/**
 * ����ģʽʹ���ڲ�����ά��������ʵ�֣�JVM�ڲ��Ļ����ܹ���֤��һ���౻���ص�ʱ�������ļ��ع������̻߳���ġ�
 * ���������ǵ�һ�ε���getInstance��ʱ��
 * ��JVM�ܹ������Ǳ�֤instanceֻ������һ�Σ����һᱣ֤�Ѹ�ֵ��instance���ڴ��ʼ����ϣ��������ǾͲ��õ������������
 * ��ͬʱ�÷���Ҳֻ���ڵ�һ�ε��õ�ʱ��ʹ�û�����ƣ������ͽ���˵��������⡣����������ʱ�ܽ�һ�������ĵ���ģʽ
 *���ǣ�����ڹ��캯�����׳��쳣��ʵ������Զ�ò�������
 */
public class Singleton1 {
	/* ˽�й��췽������ֹ��ʵ���� */
	private Singleton1() {
	}

	/* �˴�ʹ��һ���ڲ�����ά������ */
	private static class SingletonFactory {
		private static Singleton1 instance = new Singleton1();
	}

	/* ��ȡʵ�� */
	public static Singleton1 getInstance() {
		return SingletonFactory.instance;
	}

	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */
	public Object readResolve() {
		return getInstance();
	}
}
