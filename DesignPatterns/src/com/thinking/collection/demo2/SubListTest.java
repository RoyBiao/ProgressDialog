package com.thinking.collection.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Book {
	String name;
	double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
}

public class SubListTest {
	public static void main(String[] args) {
		Book book1=new Book("BOOK1", 61);
		Book book2=new Book("BOOK2", 62);
		Book book3=new Book("BOOK3", 63);
		Book book4=new Book("BOOK4", 64);
		Book book5=new Book("BOOK5", 65);
		Book[] books = new Book[] {book1,book2,book3,book4,book5};
		
		List<Book> lists=new ArrayList<Book>(Arrays.asList(books).subList(0, 4));
		System.out.println(lists.size());
	}
}
