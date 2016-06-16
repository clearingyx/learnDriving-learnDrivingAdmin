package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class Course {
    private Integer id;

    private Integer driving_id;

    private String name;

    private Float price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDriving_id() {
		return driving_id;
	}

	public void setDriving_id(Integer drivingId) {
		driving_id = drivingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Course [driving_id=" + driving_id + ", id=" + id + ", name="
				+ name + ", price=" + price + "]";
	}

}