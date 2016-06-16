package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Score extends BaseModal{
    private Integer id;

    private Integer type;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private Integer score;

    private String content;

    private String p_name;

    private String p_photo;

    private Integer p_id;

    private Integer praise;
    
    private Integer other_id;
    
    private Integer praise_flag;
    
    private String api_p_photo;
    
    private Integer order_id;
    
    private Integer use_state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String pName) {
		p_name = pName;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String pPhoto) {
		if(pPhoto!=null && !pPhoto.equals(""))
			p_photo = photoPath+pPhoto;
		else
			p_photo = pPhoto;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer pId) {
		p_id = pId;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public Integer getOther_id() {
		return other_id;
	}

	public void setOther_id(Integer otherId) {
		other_id = otherId;
	}

	public Integer getPraise_flag() {
		return praise_flag;
	}

	public void setPraise_flag(Integer praiseFlag) {
		praise_flag = praiseFlag;
	}

	public String getApi_p_photo() {
		return api_p_photo;
	}

	public void setApi_p_photo(String apiPPhoto) {
		api_p_photo = apiPPhoto;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer orderId) {
		order_id = orderId;
	}

	public Integer getUse_state() {
		return use_state;
	}

	public void setUse_state(Integer useState) {
		use_state = useState;
	}

	@Override
	public String toString() {
		return "Score [api_p_photo=" + api_p_photo + ", content=" + content
				+ ", create_date=" + create_date + ", id=" + id + ", order_id="
				+ order_id + ", other_id=" + other_id + ", p_id=" + p_id
				+ ", p_name=" + p_name + ", p_photo=" + p_photo + ", praise="
				+ praise + ", praise_flag=" + praise_flag + ", score=" + score
				+ ", type=" + type + ", use_state=" + use_state + "]";
	}


	
}