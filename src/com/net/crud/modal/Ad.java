package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Ad extends BaseModal{
	private Integer id;

    private String photo;

    private int use_state;

    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    
    private String url_path;
    private String content;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getUse_state() {
		return use_state;
	}

	public void setUse_state(int useState) {
		use_state = useState;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl_path() {
		return url_path;
	}

	public void setUrl_path(String urlPath) {
		url_path = urlPath;
	}

	@Override
	public String toString() {
		return "Ad [content=" + content + ", create_date=" + create_date
				+ ", id=" + id + ", photo=" + photo + ", url_path=" + url_path
				+ ", use_state=" + use_state + "]";
	}

}