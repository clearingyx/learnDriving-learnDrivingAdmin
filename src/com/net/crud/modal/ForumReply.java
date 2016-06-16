package com.net.crud.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class ForumReply extends BaseModal{
    private Integer id;

    private Integer f_id;

    private String nick_name;

    private String p_photo;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private Integer t_isdisabled;

    private Integer p_id;

    private String content;

    private String u_reply_content;
    
    private String theme_name;
    
    private String theme_date;
    
    private String theme_content;
    
    private String api_p_photo;
    
    private String photos;
    
    private List<String> fr_photos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer fId) {
		f_id = fId;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}

	public Integer getT_isdisabled() {
		return t_isdisabled;
	}

	public void setT_isdisabled(Integer tIsdisabled) {
		t_isdisabled = tIsdisabled;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer pId) {
		p_id = pId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getU_reply_content() {
		return u_reply_content;
	}

	public void setU_reply_content(String uReplyContent) {
		u_reply_content = uReplyContent;
	}

	public String getTheme_name() {
		return theme_name;
	}

	public void setTheme_name(String themeName) {
		theme_name = themeName;
	}

	public String getTheme_date() {
		return theme_date;
	}

	public void setTheme_date(String themeDate) {
		theme_date = themeDate;
	}

	public String getTheme_content() {
		return theme_content;
	}

	public void setTheme_content(String themeContent) {
		theme_content = themeContent;
	}
	public String getApi_p_photo() {
		return api_p_photo;
	}

	public void setApi_p_photo(String apiPPhoto) {
		api_p_photo = apiPPhoto;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		if(photos!=null && !photos.equals("")){
			List<String> list=new ArrayList<String>();
			String[] ps = photos.trim().split("_");
			for(int i=0;i<ps.length;i++){
				list.add(photoPath+ps[i]);
			}
			this.fr_photos = list;
		}
		this.photos = photos;
	}

	public List<String> getFr_photos() {
		return fr_photos;
	}

	@Override
	public String toString() {
		return "ForumReply [api_p_photo=" + api_p_photo + ", content="
				+ content + ", create_date=" + create_date + ", f_id=" + f_id
				+ ", id=" + id + ", nick_name=" + nick_name + ", p_id=" + p_id
				+ ", p_photo=" + p_photo + ", photos=" + photos
				+ ", t_isdisabled=" + t_isdisabled + ", theme_content="
				+ theme_content + ", theme_date=" + theme_date
				+ ", theme_name=" + theme_name + ", u_reply_content="
				+ u_reply_content + "]";
	}

}