package com.net.crud.handlers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.Course;
import com.net.crud.modal.Driving;
import com.net.crud.modal.Orders;
import com.net.crud.modal.Person;
import com.net.crud.modal.Score;
import com.net.util.UUIDHashCode;

@Controller
public class HomeHandler extends BaseHandler{

	//首页-驾校
	@ResponseBody
	@RequestMapping("homeDrivingList")
	public Object homeDrivingList(Driving driving,String condition,Integer pageIndex,String orderBy,Map<String, Object> map){
		map.put("driving", driving);
		map.put("condition", condition);
		map.put("orderBy", orderBy);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return drivingDao.drivingQuery(map);
	}
	//驾校详情
	@ResponseBody
	@RequestMapping("drivingDetail")
	public Object drivingDetail(Integer id){
		return drivingDao.drivingDetail(id);
	}
	//详情-评论列表
	@ResponseBody
	@RequestMapping("detailScoreList")
	public Object detailScoreList(Integer id,Integer type){
		Score s = new Score();
		s.setType(type);
		s.setOther_id(id);
		return scoreDao.selectScoreListByType(s);
	}
	//驾校课程列表
	@ResponseBody
	@RequestMapping("courseList")
	public Object courseList(Integer driving_id){
		return courseDao.courseList(driving_id);
	}
	//驾校的教练列表
	@ResponseBody
	@RequestMapping("drivingCoachList")
	public Object drivingCoachList(Person p,Integer pageIndex,Map<String, Object> map){
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		map.put("person", p);
		return personDao.personQueryByCoach(map);
	}
	//课程的教练列表
	@ResponseBody
	@RequestMapping("coachListByCourse")
	public Object coachListByCourse(Integer course_id){
		return personDao.coachListByCourse(course_id);
	}
	//陪练\教练列表
	@ResponseBody
	@RequestMapping("coachList")
	public Object coachList(Person p,String condition,Integer pageIndex,Map<String, Object> map){
		map.put("condition", condition);
		map.put("person", p);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		if(p.getType()==2)
			return personDao.sparringQuery(map);
		else if(p.getType()==3)
			return personDao.personQueryByCoach(map);
		else return "fail";
	}
	//驾校、教练、陪练评论列表
	@ResponseBody
	@RequestMapping("drivingScoreList")
	public Object drivingScoreList(Score score,Integer pageIndex,Map<String, Object> map){
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		map.put("score", score);
		return scoreDao.selectByDrvingScoreList(map);
	}
	//报名
	@ResponseBody
	@RequestMapping("drivingReg")
	public Object drivingReg(Orders o){
		int a = this.ordersDao.selectByOrderRepeat(o);
	    if (a == 0) {
			o.setType(1);//驾校
			o.setDriving_state(1);//受理中
			o.setPay_state(1);//待支付
			o.setOrder_sn(UUIDHashCode.getOrderIdByUUId());//uuid订单号
			return result(ordersDao.insert(o));		
	    }
	    return "warning";
	}	
	

	//教练的课程列表
	@ResponseBody
	@RequestMapping("courseListByCoach")
	public List<Course> courseList(Person person){
		return courseDao.courseList(person.getCourse_list());
	}
	
	//城市集合
	@ResponseBody
	@RequestMapping("cityList")
	public Object cityList(){
		return cityDao.selectQuery();
	}
}
