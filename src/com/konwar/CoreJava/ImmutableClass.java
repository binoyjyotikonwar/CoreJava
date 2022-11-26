package com.konwar.CoreJava;

import java.util.Date;

public final class ImmutableClass {

	private final Integer immutableField1;     //Integer is already immutable class
	private final String immutableField2;
	private final Date mutablefield; 
	
	public ImmutableClass(Integer immutableField1, String immutableField2,Date date) {
		this.immutableField1 = immutableField1;
		this.immutableField2 = immutableField2;
		this.mutablefield  = new Date(date.getTime());
	}
	
	public Integer getImmutableField1() {
		return immutableField1;
	}
	
	public String getImmutableField2() {
		return immutableField2;
	}
	
	public Date getMutableField() {
		return new Date(mutablefield.getTime());
	}
}
