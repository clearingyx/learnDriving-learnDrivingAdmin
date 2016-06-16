package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class Orders extends BaseModal{
    private Integer id;

    private Integer p_id;

    private Integer driving_id;//驾校id

    private Integer coach_id;//教练id

    private Integer course_id;//课程id

    private Integer sparring_id;//陪练id

    private Integer second_hand_id;//二手车id

    private Float price;

    private String order_sn;

    private String alipay_sn;

    private Integer pay_state;//全额的 1-待支付，2-支付失败，3-支付成功，4-分期支付，5-分期结束。（2以后可以开始评价；不是二手车的话，这里生成是1）

    private Integer driving_state;//1-受理中，2-受理成功（二手车也用这个？），3-报名失败，4-报名成功，5-科目一通过，6-科目二通过，7-科目三通过，8-科目四通过。（4以后可以开始评价）
    											//报名是1，回访确定参加为2，参观完驾校直接支付或提交了分期支付了第一期为4，否则为3。
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date update_date;

    private Integer installment_state;//1-分期资料未提交，2-资料审核中，3-审核未通过，4-审核通过

    private Integer installment_num;//分期数量(3，6，12）

    private Integer admin_id;

    private Integer type;//1-驾校，2-陪练，3-二手车
    
    private String real_name;
    
    private String tel;
    
    private String remark;
    
    private Integer sparring_hour;
    
    private String driving_name;
    
    private String course_name;
    
    private String nick_name;
    
    private String photo;
    
    private String subject;
    
	public Orders(Integer id, String alipaySn, Integer payState,Integer drivingState, Date updateDate) {
		super();
		this.id = id;
		alipay_sn = alipaySn;
		pay_state = payState;
		driving_state = drivingState;
		update_date = updateDate;
	}

	public Orders(Integer id, Integer payState, Integer drivingState,Date updateDate) {
		super();
		this.id = id;
		pay_state = payState;
		update_date = updateDate;
	}


	public Orders(Integer id, Integer drivingState) {
		super();
		this.id = id;
		driving_state = drivingState;
	}

	public Orders(Integer id, Integer payState, Date updateDate) {
		super();
		this.id = id;
		pay_state = payState;
		update_date = updateDate;
	}

	public Orders() {
		super();
	}

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

	public Integer getDriving_id() {
		return driving_id;
	}

	public void setDriving_id(Integer drivingId) {
		driving_id = drivingId;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coachId) {
		coach_id = coachId;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer courseId) {
		course_id = courseId;
	}

	public Integer getSparring_id() {
		return sparring_id;
	}

	public void setSparring_id(Integer sparringId) {
		sparring_id = sparringId;
	}

	public Integer getSecond_hand_id() {
		return second_hand_id;
	}

	public void setSecond_hand_id(Integer secondHandId) {
		second_hand_id = secondHandId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String orderSn) {
		order_sn = orderSn;
	}

	public String getAlipay_sn() {
		return alipay_sn;
	}

	public void setAlipay_sn(String alipaySn) {
		alipay_sn = alipaySn;
	}

	public Integer getPay_state() {
		return pay_state;
	}

	public void setPay_state(Integer payState) {
		pay_state = payState;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date updateDate) {
		update_date = updateDate;
	}

	public Integer getInstallment_state() {
		return installment_state;
	}

	public void setInstallment_state(Integer installmentState) {
		installment_state = installmentState;
	}

	public Integer getInstallment_num() {
		return installment_num;
	}

	public void setInstallment_num(Integer installmentNum) {
		installment_num = installmentNum;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String realName) {
		this.real_name = realName;
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

	public Integer getSparring_hour() {
		return sparring_hour;
	}

	public void setSparring_hour(Integer sparringHour) {
		sparring_hour = sparringHour;
	}

	public String getDriving_name() {
		return driving_name;
	}

	public void setDriving_name(String drivingName) {
		driving_name = drivingName;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String courseName) {
		course_name = courseName;
	}

	public Integer getDriving_state() {
		return driving_state;
	}

	public void setDriving_state(Integer drivingState) {
		driving_state = drivingState;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if(photo!=null || !"".equals(photo))
			this.photo = photoPath+photo;
		else
			this.photo = photo;
	}

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Orders [admin_id=" + admin_id + ", alipay_sn=" + alipay_sn
				+ ", coach_id=" + coach_id + ", course_id=" + course_id
				+ ", course_name=" + course_name + ", create_date="
				+ create_date + ", driving_id=" + driving_id
				+ ", driving_name=" + driving_name + ", driving_state="
				+ driving_state + ", id=" + id + ", installment_num="
				+ installment_num + ", installment_state=" + installment_state
				+ ", nick_name=" + nick_name + ", order_sn=" + order_sn
				+ ", p_id=" + p_id + ", pay_state=" + pay_state + ", photo="
				+ photo + ", price=" + price + ", real_name=" + real_name
				+ ", remark=" + remark + ", second_hand_id=" + second_hand_id
				+ ", sparring_hour=" + sparring_hour + ", sparring_id="
				+ sparring_id + ", tel=" + tel + ", type=" + type
				+ ", update_date=" + update_date + "]";
	}


}