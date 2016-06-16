package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class Power {
    private Integer id;

    private String power_name;

    private String power_detial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getPower_name() {
		return power_name;
	}

	public void setPower_name(String powerName) {
		power_name = powerName;
	}

	public String getPower_detial() {
		return power_detial;
	}

	public void setPower_detial(String powerDetial) {
		power_detial = powerDetial;
	}

	@Override
	public String toString() {
		return "Power [id=" + id + ", power_detial=" + power_detial
				+ ", power_name=" + power_name + "]";
	}

}