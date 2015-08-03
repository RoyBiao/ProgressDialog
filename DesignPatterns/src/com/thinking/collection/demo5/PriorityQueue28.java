package com.thinking.collection.demo5;

import java.util.PriorityQueue;
class Simple{
	
}
public class PriorityQueue28 {

	public static void main(String[] args) {
		// PriorityQueue<Double> priorityQueue = new PriorityQueue<>(
		// Arrays.asList( 0.4, 0.5,0.1, 0.2, 0.3));
		// System.out.println(priorityQueue);
		//
		// PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>(
		// Arrays.asList( 4, 5,1, 2, 3));
		// System.out.println(priorityQueue2);
		//
		// PriorityQueue<Integer> priorityQueue3 = new
		// PriorityQueue<>(priorityQueue2.size(), Collections.reverseOrder());
		// priorityQueue3.addAll(priorityQueue2);
		// System.out.println(priorityQueue3);
		// System.out.println();
		// for (int i = 0; i < priorityQueue.size(); i++) {
		// priorityQueue.poll();
		// System.out.println(priorityQueue);
		// }
		//
		// PriorityQueue<Double> priorityQueue4 = new PriorityQueue<Double>();
		// for(int i=0;i<5;i++){
		// priorityQueue4.offer(0.1*(i+1));
		// }
		// Iterator<Double> iterator = priorityQueue4.iterator();
		// while(iterator.hasNext()){
		// System.out.println(iterator.next());
		// }
		// System.out.println();
		// for(int i=0;i<priorityQueue4.size();i++){
		// priorityQueue4.poll();
		// System.out.println(priorityQueue4);
		// }

//		Random rand = new Random();
//		PriorityQueue<Double> d = new PriorityQueue<Double>();
//		for (int i = 0; i < 10; i++) {
//			double dd = rand.nextDouble() * i;
//			System.out.println(dd);
//			d.offer(dd);
//		}
//		System.out.println();
//		while (d.peek() != null)
//			System.out.println(d.poll() + " ");
		
		PriorityQueue<Simple> s = new PriorityQueue<Simple>();
		// OK to add one Simple:
		s.offer(new Simple());
		// but no more allowed; get runtime exception: 
		// Simple cannot be cast to Comparable:
		s.offer(new Simple());
	}
}
