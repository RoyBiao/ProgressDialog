package com.design.builder;

public class ThinPerson extends  Person{

	@Override
	public void buildHead() {
		System.out.println("ThinPerson is built Head");
	}

	@Override
	public void buildBody() {
		System.out.println("ThinPerson is built Body");
	}

	@Override
	public void buildArmLeft() {
		System.out.println("ThinPerson is built ArmLeft");
	}

	@Override
	public void buildArmRight() {
		System.out.println("ThinPerson is built ArmRight");
	}

	@Override
	public void buildLegLeft() {
		System.out.println("ThinPerson is built LegLeft");
	}

	@Override
	public void buildLegRight() {
		System.out.println("ThinPerson is built LegRight");
	}

}
