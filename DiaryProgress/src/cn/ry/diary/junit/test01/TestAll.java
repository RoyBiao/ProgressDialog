package cn.ry.diary.junit.test01;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;


public class TestAll extends TestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("TestSuite Test");
		suite.addTestSuite(TestCalcuator.class);
		return suite;
	}

	public static void main(String args[]) {
		// 命令行输出 测试工具 一个测试运行器
//		TestRunner.run(suite());  
		suite();
	}
}
