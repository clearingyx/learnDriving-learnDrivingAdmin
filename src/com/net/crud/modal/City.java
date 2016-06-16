package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class City extends BaseModal{
	private Integer id;
	
	private Integer p_id;
	
	private String name;
	
	private String province;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer pId) {
		p_id = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province.trim();
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", p_id=" + p_id
				+ ", province=" + province + "]";
	}
	
}