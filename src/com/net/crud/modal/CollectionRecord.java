package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class CollectionRecord {
    private Integer id;

    private Integer other_id;

    private Integer p_id;

    private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOther_id() {
		return other_id;
	}

	public void setOther_id(Integer otherId) {
		other_id = otherId;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer pId) {
		p_id = pId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "collectionRecord [id=" + id + ", other_id=" + other_id
				+ ", p_id=" + p_id + ", type=" + type + "]";
	}

  
}