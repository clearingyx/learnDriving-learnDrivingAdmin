package com.net.crud.handlers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Notice;
import com.net.crud.modal.Person;
import com.net.util.JSONUtil;

@Controller
public class PersonHandler extends BaseHandler {

	//编辑资料（普通资料）
	@ResponseBody
	@RequestMapping("personEditData")
	public Object personEditData(String json,HttpServletRequest request){
		Person p = JSONUtil.toBean(json, Person.class);
		if(p.getPhoto()!=null && !"".equals(p.getPhoto())){
			String fileName = updatePhoto(p.getPhoto().replace(PATH, "").trim(), "person",request.getSession().getServletContext().getRealPath("/upload"),request.getContextPath()+"/upload/");
			p.setPhoto("");
			p.setApi_photo(fileName);
		}
		return result(personDao.update(p));
	}
	//通过电话修改密码
	@ResponseBody
	@RequestMapping("updatePwd")
	public Object updatePwd(Person p){
		return result(personDao.updatePwd(p));
	}
	@ResponseBody
	@RequestMapping("judgePwd")
	public Object judgePwd(Person p){
		return result(personDao.judgePwd(p));
	}
	/*//上传头像
	@ResponseBody
	@RequestMapping("personEditPhoto")
	public Object personEditPhoto(String photo,Integer id,HttpServletRequest request,Map<String, Object> map){
		String name = updatePhoto(photo, "person",request.getSession().getServletContext().getRealPath("/upload"),request.getContextPath()+"/upload/");
		map.put("photo", name);
		map.put("id", id);
		return result(personDao.personEditPhoto(map));
	}*/
	//收藏列表（主题）
	@ResponseBody
	@RequestMapping("collectionRecordThemeList")
	public Object CollectionRecordThemeList(Integer p_id,Integer pageIndex,Map<String, Object> map){
		map.put("p_id", p_id);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return forumThemeDao.CollectionRecordThemeList(map);
	}
	//收藏列表（二手车）
	@ResponseBody
	@RequestMapping("collectionRecordSecondList")
	public Object CollectionRecordSecondList(Integer p_id,Integer pageIndex,Map<String, Object> map){
		map.put("p_id", p_id);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return secondHandDao.CollectionRecordSecondList(map);
	}
	//取消收藏
	@ResponseBody
	@RequestMapping("collectionDel")
	public Object collectionDel(Integer id){
		return result(collerctionRecordDao.delete(id));
	}
	
	//消息列表
	@ResponseBody
	@RequestMapping("noticeList")
	public Object noticeListByPid(Integer p_id,Integer pageIndex,Map<String, Object> map){
		map.put("p_id", p_id);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return noticeDao.noticeListByPid(map);
	}
	
	//阅读/删除消息
	@ResponseBody
	@RequestMapping("noticeStateChange")
	public Object noticeStateChange(Notice n){
		int a=0;
		if(n.getUse_state()==2){//阅读
			a=noticeDao.update(n);
		}else if(n.getUse_state()==3){//删除
			a=noticeDao.delete(n);
		}
		return result(a);
	}
	
	//支付宝账号
	@ResponseBody
	@RequestMapping("aliPayAccount")
	public Object aliPayAccount(Integer p_id){		
		return payAccountDao.selectByPid(p_id);
	}
	
	//判断手机是否存在
	@ResponseBody
	@RequestMapping("judgeTel")
	public Object judgeTel(String tel){
		return result(personDao.judgeTel(tel));
	}
	
	//修改用户是否接收消息
	@ResponseBody
	@RequestMapping("updatePush")
	public Object updatePush(Person p){
		return result(personDao.update(p));
	}
	
	//通过id找到用户
	@ResponseBody
	@RequestMapping("personById")
	public Object personById(Integer id){
		return personDao.personById(id);
	}
}
