package com.net.crud.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Person;

@Controller
public class LoginHandler extends BaseHandler{
	@ResponseBody
	@RequestMapping("login")
	public Object login(Person person){
		person = personDao.selectByLogin(person);
		if(person==null) return "fail";
		else if(person.getUse_state()==2) return "warning";
		else return person;
	}
	
	@ResponseBody
	@RequestMapping("reg")
	public Object reg(Person person){
		int  a = personDao.personJudgeTelRepeat(person.getTel());
		if(a>0)return "warning";
		else{
			if(person.getPhoto()==null || "".equals(person.getPhoto())){
				person.setApi_photo("/learnDriving/upload/default.png");
			}
			a = personDao.insert(person);
			if(a>0){
				if(person.getNick_name()==null || "".equals(person.getNick_name())){
					Person per = new Person();
					per.setId(person.getId());
					per.setNick_name("user"+person.getId());
					return result(personDao.update(per));
				}
				return "success";
			}else
				return "fail";
		}
	}
}
