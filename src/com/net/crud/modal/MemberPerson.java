package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class MemberPerson extends BaseModal{
    private Integer id;
    private Integer p_id;
    private Integer member_id;    
    private String real_name;
    private String tel;
    private String remark;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    private String p_photo;
    private String api_photo;

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

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer memberId) {
		member_id = memberId;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String realName) {
		real_name = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		if(p_photo!=null && !p_photo.equals(""))
			this.p_photo = photoPath+p_photo;
		else
			this.p_photo = p_photo;
	}

	public String getApi_photo() {
		return api_photo;
	}

	public void setApi_photo(String apiPhoto) {
		api_photo = apiPhoto;
	}

	@Override
	public String toString() {
		return "MemberPerson [create_date=" + create_date + ", id=" + id
				+ ", member_id=" + member_id + ", p_id=" + p_id + ", p_photo="
				+ p_photo + ", real_name=" + real_name + ", remark=" + remark
				+ ", tel=" + tel + "]";
	}

}