package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class Log {
    private Integer id;

    private Integer admin_id;

    private String info;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	@Override
	public String toString() {
		return "Log [admin_id=" + admin_id + ", create_date=" + create_date
				+ ", id=" + id + ", info=" + info + "]";
	}

}