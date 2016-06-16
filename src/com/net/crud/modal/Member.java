package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class Member extends BaseModal{
    private Integer id;

    private String name;

    private Integer admin_id;

    private String photo;

    private String content;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date appointment_date;
    @JSONField (format="yyyy-MM-dd")
    private Date begin_date;
    @JSONField (format="yyyy-MM-dd")
    private Date finish_date;

    private Float price;

    private Integer person_count; //预计人数
    
    private Integer appointment_count; //预约人数
    
    private Integer city;
    
    private Integer p_id;
    
    private String type;
    
    private String cName;
    
    private Integer use_state;
    
    
    
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

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

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Date getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(Date appointmentDate) {
		appointment_date = appointmentDate;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date beginDate) {
		begin_date = beginDate;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finishDate) {
		finish_date = finishDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPerson_count() {
		return person_count;
	}

	public void setPerson_count(Integer personCount) {
		person_count = personCount;
	}

	public Integer getAppointment_count() {
		return appointment_count;
	}

	public void setAppointment_count(Integer appointmentCount) {
		appointment_count = appointmentCount;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUse_state() {
		return use_state;
	}

	public void setUse_state(Integer useState) {
		use_state = useState;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer pId) {
		p_id = pId;
	}

	@Override
	public String toString() {
		return "Member [admin_id=" + admin_id + ", appointment_count="
				+ appointment_count + ", appointment_date=" + appointment_date
				+ ", begin_date=" + begin_date + ", city=" + city
				+ ", content=" + content + ", create_date=" + create_date
				+ ", finish_date=" + finish_date + ", id=" + id + ", name="
				+ name + ", p_id=" + p_id + ", person_count=" + person_count
				+ ", photo=" + photo + ", price=" + price + ", type=" + type
				+ ", use_state=" + use_state + "cName=" + cName +"]";
	}

}