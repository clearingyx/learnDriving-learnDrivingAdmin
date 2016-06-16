package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class Admin {
    private Integer id;

    private String name;

    private Integer sup;

    private Integer use_state;

    private String pwd;

    private String power;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSup() {
        return sup;
    }

    public void setSup(Integer sup) {
        this.sup = sup;
    }

    public Integer getUse_state() {
        return use_state;
    }

    public void setUse_state(Integer use_state) {
        this.use_state = use_state;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", power=" + power + ", pwd=" + pwd + ", sup=" + sup
				+ ", use_state=" + use_state + "]";
	}
    
}