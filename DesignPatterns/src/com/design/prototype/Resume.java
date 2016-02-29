package com.design.prototype;

public class Resume implements Prototype{

	private String name;
	private WorkEperience work;
	public Resume(){
		this.name=name;
		work=new WorkEperience();
	}
	
	public Resume(WorkEperience work){
		this.work=(WorkEperience) work.clone();
	}
	
	public void setInfo(String name,String company){
		this.name=name;
		work.setCompany(company);
	}
	public Prototype clone(){
//		Prototype prototype=new Resume();
//		return prototype;
		Resume resume=new Resume(this.work);
		resume.name=this.name;
		return resume;
	}
	
	public void show(){
		System.out.println(name+":"+work.getCompany());
	}
}
