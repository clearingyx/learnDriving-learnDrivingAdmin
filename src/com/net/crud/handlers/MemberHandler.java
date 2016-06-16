package com.net.crud.handlers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Member;
import com.net.crud.modal.MemberPerson;

@Controller
public class MemberHandler extends BaseHandler{

	//会员活动列表
	@ResponseBody
	@RequestMapping("memberList")
	public Object memberList(Member m,Integer pageIndex,String condition,Map<String, Object> map){
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		map.put("condition",condition);
		map.put("member", m);
		return memberDao.memberList(map);
	}
	//会员活动单个活动的详情
	@ResponseBody
	@RequestMapping("memberDetail")
	public Object memberDetail(Integer id){
		return memberDao.memberDetail(id);
	}
	//报名人列表
	@ResponseBody
	@RequestMapping("appointmentList")
	public Object appointmentList(Integer member_id){
		return memberPersonDao.memberPersonList(member_id);
	}
	//活动预约
	@ResponseBody
	@RequestMapping("appointmentAdd")
	public Object appointmentAdd(MemberPerson mp){
		int a =memberPersonDao.judgeAppointmentRepeat(mp);
		if(a==0){
			mp.setApi_photo(getNewName(mp.getP_photo()));
			mp.setP_photo("");//会自动装载对象将localhost也放进去，所以只好在起一个实体属性
			return result(memberPersonDao.insert(mp));
		}else{
			return "warning";
		}
	}
}
