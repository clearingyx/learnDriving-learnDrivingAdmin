package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Feedback {
	
	private Integer id;
	
	private Integer p_id;
	
	private String content;
	
	private Integer state;
	
	private Integer admin_id;
	
	private Date create_date;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	@Override
	public String toString() {
		return "Feedback [admin_id=" + admin_id + ", content=" + content
				+ ", create_date=" + create_date + ", id=" + id + ", p_id="
				+ p_id + ", state=" + state + "]";
	}
	
	
}
