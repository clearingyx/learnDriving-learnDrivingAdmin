package com.net.crud.modal;

import javax.persistence.Entity;

@Entity
public class ForumCate extends BaseModal{
    private Integer id;

    private String cate_name;

    private String cate_photo;
    
    private Integer browse;//分类浏览数
    
    private Integer theme_count;//分类主题数
    
    private int use_state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cateName) {
		cate_name = cateName;
	}

	public String getCate_photo() {
		return cate_photo;
	}

	public void setCate_photo(String catePhoto) {
		if(catePhoto!=null && !"".equals(catePhoto))
			cate_photo = photoPath+catePhoto;
		else
			cate_photo = catePhoto;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public Integer getTheme_count() {
		return theme_count;
	}

	public void setTheme_count(Integer themeCount) {
		theme_count = themeCount;
	}

	public int getUse_state() {
		return use_state;
	}

	public void setUse_state(int useState) {
		use_state = useState;
	}

	@Override
	public String toString() {
		return "ForumCate [browse=" + browse + ", cate_name=" + cate_name
				+ ", cate_photo=" + cate_photo + ", id=" + id
				+ ", theme_count=" + theme_count + ", use_state=" + use_state
				+ "]";
	}


}