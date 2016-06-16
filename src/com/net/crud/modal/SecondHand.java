package com.net.crud.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
public class SecondHand extends BaseModal{
    private Integer id;

    private Float price;//报价

    private Float original_price;//原价

    private Float tax;//税
    
    private String name;//车名

    private String simple_des;//简单描述（名字下面的一排小字，字数少）

    private String brand;//品牌

    private String models;//车型

    private Integer age;//车龄

    private Float mileage;//里程数

    private Integer stall;//1-手动档，2-自动档

    private Float displacement;//排量

    private Integer standard;//国2-国5标准，2，3，4，5

    private String color;//颜色

    private Integer use_state;//1-正常，2-下架
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    private Integer admin_id;

    private String photo;//内页图片
    
    private String cover;//封面图片
    
    private List<String> photos;//内页图片封装为list
    
    private String flag;//收藏标识，如果有值，说明已经收藏
    
    private Integer city;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(Float originalPrice) {
		original_price = originalPrice;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public String getSimple_des() {
		return simple_des;
	}

	public void setSimple_des(String simpleDes) {
		simple_des = simpleDes;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getMileage() {
		return mileage;
	}

	public void setMileage(Float mileage) {
		this.mileage = mileage;
	}

	public Integer getStall() {
		return stall;
	}

	public void setStall(Integer stall) {
		this.stall = stall;
	}

	public Float getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Float displacement) {
		this.displacement = displacement;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		if(photo!=null && !photo.equals("")){
			List<String> list = new ArrayList<String>();
			String[] ps = photo.trim().split("_");
			for(int i=0;i<ps.length;i++){
				if(!"".equals(ps[i].trim()))
					list.add(photoPath+ps[i].trim());
			}
			photos = list;
		}else
			this.photo = photo;
	}
  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		if(cover!=null && !cover.equals(""))
			this.cover = photoPath+cover;
		else
			this.cover = cover;
	}
	
	public List<String> getPhotos() {
		return photos;
	}
	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "SecondHand [admin_id=" + admin_id + ", age=" + age + ", brand="
				+ brand + ", city=" + city 	+ ", color=" + color + ", cover=" + cover + ", create_date="
				+ create_date + ", displacement=" + displacement + ", flag="
				+ flag + ", id=" + id + ", mileage=" + mileage + ", models="
				+ models + ", name=" + name + ", original_price="
				+ original_price + ", photo=" + photo + ", photos=" + photos
				+ ", price=" + price + ", simple_des=" + simple_des
				+ ", stall=" + stall + ", standard=" + standard + ", tax="
				+ tax + ", use_state=" + use_state + "]";
	}


}