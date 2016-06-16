package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class OrderPayProgress {
    private Integer id;

    private Integer order_id;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date last_date;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date pay_date;

    private Float price;

    private Integer pay_state;//1-待支付，2-支付失败，3-支付成功

    private Integer several_stages;//1-第一期，2-第二期……
    
    private String progress_sn;//订单号
    
    private String alipay_sn;

    
	public OrderPayProgress(Integer id, Integer payState) {
		super();
		this.id = id;
		pay_state = payState;
	}

	public OrderPayProgress() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer orderId) {
		order_id = orderId;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date lastDate) {
		last_date = lastDate;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date payDate) {
		pay_date = payDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPay_state() {
		return pay_state;
	}

	public void setPay_state(Integer payState) {
		pay_state = payState;
	}

	public Integer getSeveral_stages() {
		return several_stages;
	}

	public void setSeveral_stages(Integer severalStages) {
		several_stages = severalStages;
	}

	public String getProgress_sn() {
		return progress_sn;
	}

	public void setProgress_sn(String progressSn) {
		progress_sn = progressSn;
	}

	public String getAlipay_sn() {
		return alipay_sn;
	}

	public void setAlipay_sn(String alipaySn) {
		alipay_sn = alipaySn;
	}

	@Override
	public String toString() {
		return "OrderPayProgress [alipay_sn=" + alipay_sn + ", id=" + id
				+ ", last_date=" + last_date + ", order_id=" + order_id
				+ ", pay_date=" + pay_date + ", pay_state=" + pay_state
				+ ", price=" + price + ", progress_sn=" + progress_sn
				+ ", several_stages=" + several_stages + "]";
	}

}