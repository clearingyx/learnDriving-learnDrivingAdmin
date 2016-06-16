package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
public class Version extends BaseModal {
	
	private Integer id;
	
	private String version_info;
	
	private String address;
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date create_date;
	
	private Double version_num;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVersion_info() {
		return version_info;
	}
	public void setVersion_info(String versionInfo) {
		version_info = versionInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address!=null && !"".equals(address))
			this.address = photoPath+address;
		else
			this.address = address;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Double getVersion_num() {
		return version_num;
	}
	public void setVersion_num(Double version_num) {
		this.version_num = version_num;
	}
	@Override
	public String toString() {
		return "Version [address=" + address + ", create_date=" + create_date
				+ ", id=" + id + ", version_num=" + version_num + ", version_info="
				+ version_info + "]";
	}
	
	
}
