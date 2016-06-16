package com.net.crud.handlers;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Ad;


@Controller
public class AdHandler extends BaseHandler{
	//广告管理
	@ResponseBody
	@RequestMapping("ad_query")
	public Object ad_manager(Map<String, Object>map,String msg){
		List<Ad> list=adDao.selectQuery();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setPhoto(PATH+list.get(i).getPhoto());
			String content = list.get(i).getContent();
			if(content!=null && !"".equals(content)){
				String project = ResourceBundle.getBundle("config").getString("project");
				content=content.replace(project, PATH+project);
				content=content.replace("src", "width='100%' height='auto' src");
				list.get(i).setContent(content);
			}
		}
		return list;
	}
	
}
