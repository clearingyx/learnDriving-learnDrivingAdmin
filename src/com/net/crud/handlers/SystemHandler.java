package com.net.crud.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Feedback;
import com.net.crud.modal.PraiseRecord;

@Controller
public class SystemHandler extends BaseHandler{
	
	//获得版本信息
	@ResponseBody
	@RequestMapping("version")
	public Object Version(){
		return versionDao.selectByNewVersion();
	}
	
	//建议反馈
	@ResponseBody
	@RequestMapping("feedback")
	public Object Feedback(Feedback fb){
		fb.setState(1);
		return result(feedbackDao.insert(fb));
	}
	
	//评论点赞
	@ResponseBody
	@RequestMapping("praiseAddByScore")
	public Object praiseAddByScore(PraiseRecord pr){
		pr.setType(1);
		return result(praiseRecordDao.praiseAddByScore(pr));
	}
	
	//取消点赞
	@ResponseBody
	@RequestMapping("praiseSubByScore")
	public Object praiseSubByScore(PraiseRecord pr){
		pr.setType(1);
		return result(praiseRecordDao.praiseSubByScore(pr));
	}
	
}
