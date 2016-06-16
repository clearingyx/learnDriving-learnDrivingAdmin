package com.net.crud.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class ForumTheme extends BaseModal{
    private Integer id;

    private Integer p_id;

    private String nick_name;

    private String p_photo;

    private Integer cate_id;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private String title;

    private Integer t_isdisabled;

    private Integer reply_num;

    private String photos;
    
    private List<String> ft_photos;

    private Integer top_state;

    private Integer browse;

    private Integer praise;
    
    private String content;
    
    private String api_p_photo;
    
    private Integer praise_flag;
    
    private Integer flag;
    
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

	public Integer getCate_id() {
		return cate_id;
	}

	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getT_isdisabled() {
		return t_isdisabled;
	}

	public void setT_isdisabled(Integer t_isdisabled) {
		this.t_isdisabled = t_isdisabled;
	}

	public Integer getReply_num() {
		return reply_num;
	}

	public void setReply_num(Integer reply_num) {
		this.reply_num = reply_num;
	}

	/*public String getPhotos() {
		return photos;
	}*/

	public void setPhotos(String photos) {
		if(photos!=null && !photos.equals("")){
			List<String> list=new ArrayList<String>();
			String[] ps = photos.trim().split("_");
			for(int i=0;i<ps.length;i++){
				list.add(photoPath+ps[i]);
			}
			this.ft_photos = list;
		}
		this.photos = photos;
	}

	public Integer getTop_state() {
		return top_state;
	}

	public void setTop_state(Integer top_state) {
		this.top_state = top_state;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public List<String> getFt_photos() {
		return ft_photos;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getApi_p_photo() {
		return api_p_photo;
	}

	public void setApi_p_photo(String apiPPhoto) {
		api_p_photo = apiPPhoto;
	}

	public Integer isPraise_flag() {
		return praise_flag;
	}

	public void setPraise_flag(Integer praiseFlag) {
		praise_flag = praiseFlag;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "ForumTheme [api_p_photo=" + api_p_photo + ", browse=" + browse
				+ ", cate_id=" + cate_id + ", content=" + content
				+ ", create_date=" + create_date + ", ft_photos=" + ft_photos
				+ ", id=" + id + ", nick_name=" + nick_name + ", p_id=" + p_id
				+ ", p_photo=" + p_photo + ", photos=" + photos + ", praise="
				+ praise + ", praise_flag=" + praise_flag + ", reply_num="
				+ reply_num + ", t_isdisabled=" + t_isdisabled + ", title="
				+ title + ", top_state=" + top_state + "]";
	}

}