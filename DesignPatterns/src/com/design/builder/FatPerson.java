package com.design.builder;

public class FatPerson extends  Person{

	@Override
	public void buildHead() {
		System.out.println("FatPerson is built Head");
	}

	@Override
	public void buildBody() {
		System.out.println("FatPerson is built Body");
	}

	@Override
	public void buildArmLeft() {
		System.out.println("FatPerson is built ArmLeft");
	}

	@Override
	public void buildArmRight() {
		System.out.println("FatPerson is built ArmRight");
	}

	@Override
	public void buildLegLeft() {
		System.out.println("FatPerson is built LegLeft");
	}

	@Override
	public void buildLegRight() {
		System.out.println("FatPerson is built LegRight");
	}

}
