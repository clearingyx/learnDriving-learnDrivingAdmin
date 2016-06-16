package com.net.crud.modal;

import java.util.Date;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class OrderDrivingProgress {
    private Integer id;

    private Integer order_id;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date progress_date;

    private Integer progress_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setDriving_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getProgress_date() {
		return progress_date;
	}

	public void setProgress_date(Date progressDate) {
		progress_date = progressDate;
	}

	public Integer getProgress_name() {
		return progress_name;
	}

	public void setProgress_name(Integer progressName) {
		progress_name = progressName;
	}

	@Override
	public String toString() {
		return "OrderDrivingProgress [order_id=" + order_id + ", id=" + id
				+ ", progress_date=" + progress_date + ", progress_name="
				+ progress_name + "]";
	}

}