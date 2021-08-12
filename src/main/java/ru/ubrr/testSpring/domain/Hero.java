package ru.ubrr.testSpring.domain;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Hero {

	private long id;

	@Size(min = 4, max = 14)
	private String name;

	@Max(value = 30)
	@Min(value = 0)
	private int level;

	private String ultimate;

	public Hero(final long id, final String name, final int level, final String ultimate) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.ultimate = ultimate;
	}

	//region getter setter
	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public String getUltimate() {
		return ultimate;
	}

	public void setUltimate(final String ultimate) {
		this.ultimate = ultimate;
	}
	//endregion
}
