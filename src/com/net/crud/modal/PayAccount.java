package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class PayAccount {
    private Integer id;

    private Integer p_id;

    private String account;

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


	public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
    @Override
    public String toString() {
    	return "PayAccount [account=" + account + ", id=" + id + ", p_id="
    	+ p_id + "]";
    }
    
}