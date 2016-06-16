package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Driving extends BaseModal{
    private Integer id;

    private String name;

    private String photo;

    private String address;

    private String introduction;

    private Float score;
    
    private String distance;//距离我的距离
    
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private Integer admin_id;
    
    private double s_position_x; //经度
    private double s_position_y; //纬度
    
    private String province;//省
    private Integer city;//市
    
    private Integer p_id;
    
    private Integer use_state;
    
    private String tel;
    
    private String admin_phone;
    
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
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if(photo!=null && !photo.equals(""))
			this.photo = photoPath+photo;
		else
			this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public double getS_position_x() {
		return s_position_x;
	}

	public void setS_position_x(double sPositionX) {
		s_position_x = sPositionX;
	}

	public double getS_position_y() {
		return s_position_y;
	}

	public void setS_position_y(double sPositionY) {
		s_position_y = sPositionY;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getUse_state() {
		return use_state;
	}

	public void setUse_state(Integer useState) {
		use_state = useState;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer pId) {
		p_id = pId;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String adminPhone) {
		admin_phone = adminPhone;
	}

	@Override
	public String toString() {
		return "Driving [address=" + address + ", admin_id=" + admin_id
				+ ", city=" + city + ", create_date=" + create_date
				+ ", distance=" + distance + ", id=" + id + ", introduction="
				+ introduction + ", name=" + name + ", p_id=" + p_id
				+ ", photo=" + photo + ", province=" + province
				+ ", s_position_x=" + s_position_x + ", s_position_y="
				+ s_position_y + ", score=" + score + ", tel=" + tel
				+ ", use_state=" + use_state + "]";
	}

}