package com.net.crud.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Person extends BaseModal{
    private Integer id;

    private String nick_name;

    private String tel;

    private Float score;

    private Integer sex;

    private Integer use_state;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private String photo;

    private Integer type;

    private String address;

    private Float price;

    private String skill;

    private String course_id;
    
    private Double course_price;
    
    private List<Integer> course_list;

    private String sign;

    private String real_name;

    private Integer driving_id;

    private Integer admin_id;
    
    private String pwd;
    
    private String api_photo;
    
    private String birthday;
    
    private String driving_name;
    
    private Integer city;
    
    private Integer p_id;
    
    private Integer push_state;
    
	public Person() {
		super();
	}


	public Person(Integer driving_id, Integer useState, Integer type) {
		super();
		this.driving_id = driving_id;
		use_state = useState;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getUse_state() {
		return use_state;
	}

	public void setUse_state(Integer useState) {
		use_state = useState;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if(photo!=null && !"".equals(photo))
			this.photo = photoPath+photo;
		else
			this.photo = photo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		List<Integer> list = new ArrayList<Integer>();
		String[] cs= course_id.trim().split("_");
		for(int i=0;i<cs.length;i++){
			list.add(Integer.parseInt(cs[i]));
		}
		course_list = list;
		this.course_id = course_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String realName) {
		real_name = realName;
	}

	public Integer getDriving_id() {
		return driving_id;
	}

	public void setDriving_id(Integer drivingId) {
		driving_id = drivingId;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Integer> getCourse_list() {
		return course_list;
	}

	public String getApi_photo() {
		return api_photo;
	}

	public void setApi_photo(String apiPhoto) {
		api_photo = apiPhoto;
	}
		
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDriving_name() {
		return driving_name;
	}

	public void setDriving_name(String drivingName) {
		driving_name = drivingName;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}


	public Integer getP_id() {
		return p_id;
	}


	public void setP_id(Integer pId) {
		p_id = pId;
	}


	public Double getCourse_price() {
		return course_price;
	}


	public void setCourse_price(Double coursePrice) {
		course_price = coursePrice;
	}


	public Integer getPush_state() {
		return push_state;
	}


	public void setPush_state(Integer pushState) {
		push_state = pushState;
	}


	@Override
	public String toString() {
		return "Person [address=" + address + ", admin_id=" + admin_id
				+ ", api_photo=" + api_photo + ", birthday=" + birthday
				+ ", city=" + city + ", course_id=" + course_id
				+ ", course_list=" + course_list + ", course_price="
				+ course_price + ", create_date=" + create_date
				+ ", driving_id=" + driving_id + ", driving_name="
				+ driving_name + ", id=" + id + ", nick_name=" + nick_name
				+ ", p_id=" + p_id + ", photo=" + photo + ", price=" + price
				+ ", push_state=" + push_state + ", pwd=" + pwd
				+ ", real_name=" + real_name + ", score=" + score + ", sex="
				+ sex + ", sign=" + sign + ", skill=" + skill + ", tel=" + tel
				+ ", type=" + type + ", use_state=" + use_state + "]";
	}


}