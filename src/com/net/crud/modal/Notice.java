package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class Notice {
    private Integer id;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private Integer use_state;

    private Integer admin_id;

    private Integer p_id;

    private String content;
    
    private String title;
    

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Integer getUse_state() {
		return use_state;
	}

	public void setUse_state(Integer useState) {
		use_state = useState;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
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

	@Override
	public String toString() {
		return "Notice [admin_id=" + admin_id + ", content=" + content
				+ ", create_date=" + create_date + ", id=" + id + ", p_id="
				+ p_id + ", use_state=" + use_state + "]";
	}

    
}