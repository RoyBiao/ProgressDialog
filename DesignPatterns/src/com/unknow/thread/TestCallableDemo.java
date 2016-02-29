package com.unknow.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 ExecutorService executorService = Executors.newFixedThreadPool(4);
		 //ExecutorService executorService = Executors.newCachedThreadPool();
		 //ExecutorService executorService = Executors.newSingleThreadExecutor();
         List<Future<String>> resultList = new ArrayList<Future<String>>();

         //����10������ִ��
         for (int i = 0; i < 10; i++) {
                 //ʹ��ExecutorServiceִ��Callable���͵����񣬲������������future������
                 Future<String> future = executorService.submit(new TaskWithResult(i));
                 //������ִ�н���洢��List��
                 resultList.add(future);
         }

         //��������Ľ��
         for (Future<String> fs : resultList) {
                 try {
                         System.out.println(fs.get());     //��ӡ�����̣߳�����ִ�еĽ��
                 } catch (InterruptedException e) {
                         e.printStackTrace();
                 } catch (ExecutionException e) {
                         e.printStackTrace();
                 } finally {
                         //����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�����������������Ѿ��رգ������û���������á�
                         executorService.shutdown();
                 }
         } 

	}

}
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
            this.id = id;
    }

    /**
     * ����ľ�����̣�һ�����񴫸�ExecutorService��submit��������÷����Զ���һ���߳���ִ�С�
     *
     * @return
     * @throws Exception
     */
    public String call() throws Exception {
            System.out.println("call()�������Զ�����,�ɻ����             " + Thread.currentThread().getName());
            //һ��ģ���ʱ�Ĳ���
            for (int i = 999999; i > 0; i--) ;
            return "call()�������Զ����ã�����Ľ���ǣ�" + id + "    " + Thread.currentThread().getName();
    }
}