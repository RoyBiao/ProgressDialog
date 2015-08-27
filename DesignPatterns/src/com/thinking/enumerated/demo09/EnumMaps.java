//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package com.thinking.enumerated.demo09;

import java.util.*;
import java.util.Map.Entry;

import com.thinking.enumerated.demo08.AlarmPoints;

import static com.thinking.enumerated.demo08.AlarmPoints.*;
import static com.thinking.util.Print.*;

interface Command {
	void action();
}

public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(
				AlarmPoints.class);
		em.put(KITCHEN, new Command() {
			public void action() {
				print("Kitchen fire!");
			}
		});
		em.put(BATHROOM, new Command() {
			public void action() {
				print("Bathroom alert!");
			}
		});
		
		for(AlarmPoints points : em.keySet()){
			printnb(points + ": ");
			Command command = em.get(points);
			command.action();
		}
		System.out.println();
		Iterator<Entry<AlarmPoints, Command>> ite= em.entrySet().iterator();
		while(ite.hasNext()){
			Map.Entry<AlarmPoints, Command> e=ite.next();
			printnb(e.getKey() + ": ");
			e.getValue().action();
		}
		System.out.println();
		for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
			printnb(e.getKey() + ": ");
			e.getValue().action();
		}
		try { // If there's no value for a particular key:
			em.get(UTILITY).action();
		} catch (Exception e) {
			print(e);
		}
	}
} /*
 * Output: BATHROOM: Bathroom alert! KITCHEN: Kitchen fire!
 * java.lang.NullPointerException
 */// :~
