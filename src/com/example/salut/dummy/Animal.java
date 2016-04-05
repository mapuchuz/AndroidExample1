package com.example.salut.dummy;

public class Animal {

	public String id;
	public String name;
	public String species;
	public String photo;
	
	public Animal(String id, String name, String species, String photo) {
		this.id = id;
		this.name = name;
		this.species= species;
		this.photo= photo;
	}

	@Override
	public String toString() {
		return name+","+species;
	}
}
