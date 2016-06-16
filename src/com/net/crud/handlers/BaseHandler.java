package com.net.crud.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.net.crud.dao.AdMapper;
import com.net.crud.dao.AdminMapper;
import com.net.crud.dao.CityMapper;
import com.net.crud.dao.CollectionRecordMapper;
import com.net.crud.dao.CourseMapper;
import com.net.crud.dao.DrivingMapper;
import com.net.crud.dao.FeedbackMapper;
import com.net.crud.dao.ForumCateMapper;
import com.net.crud.dao.ForumReplyMapper;
import com.net.crud.dao.ForumThemeMapper;
import com.net.crud.dao.LogMapper;
import com.net.crud.dao.MemberMapper;
import com.net.crud.dao.MemberPersonMapper;
import com.net.crud.dao.NoticeMapper;
import com.net.crud.dao.OrderDrivingProgressMapper;
import com.net.crud.dao.OrderPayProgressMapper;
import com.net.crud.dao.OrdersMapper;
import com.net.crud.dao.PayAccountMapper;
import com.net.crud.dao.PersonMapper;
import com.net.crud.dao.PowerMapper;
import com.net.crud.dao.PraiseRecordMapper;
import com.net.crud.dao.ScoreMapper;
import com.net.crud.dao.SecondHandMapper;
import com.net.crud.dao.VersionMapper;
import com.net.util.PathUtil;

public class BaseHandler {
	@Autowired
	DrivingMapper drivingDao;
	@Autowired
	PersonMapper personDao;
	@Autowired
	CourseMapper courseDao;
	@Autowired
	ScoreMapper scoreDao;
	@Autowired
	OrdersMapper ordersDao;
	@Autowired
	AdminMapper adminDao;
	@Autowired
	CollectionRecordMapper collerctionRecordDao;
	@Autowired
	ForumCateMapper forumCateDao;
	@Autowired
	ForumReplyMapper forumReplyDao;
	@Autowired
	ForumThemeMapper forumThemeDao;
	@Autowired
	LogMapper logDao;
	@Autowired
	MemberMapper memberDao;
	@Autowired
	MemberPersonMapper memberPersonDao;
	@Autowired
	NoticeMapper noticeDao;
	@Autowired
	OrderDrivingProgressMapper orderDrivingProgressDao;
	@Autowired
	OrderPayProgressMapper orderPayProgressDao;
	@Autowired
	PayAccountMapper payAccountDao;
	@Autowired
	PowerMapper powerDao;
	@Autowired
	PraiseRecordMapper praiseRecordDao;
	@Autowired
	SecondHandMapper secondHandDao;
	@Autowired
	VersionMapper versionDao;
	@Autowired
	FeedbackMapper feedbackDao;
	@Autowired
	AdMapper adDao;
	@Autowired
	CityMapper cityDao;
	
	static final Integer pageSize = 100;
	
	static String PATH = ResourceBundle.getBundle("config").getString("domain");
	
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"), true));
    }
	
	public String result(int a){
		if(a>0)
			return "success";
		else 
			return "fail";
	}
	
	//上传多图片
	public String updatePhotos(List<String> photo,String path,String appPath,String proPath){
		String fileName="";
		if(photo!=null){
			for (int i = 0; i < photo.size(); i++) {
				fileName += UploadFileBiz.Upload(photo.get(i),path,appPath,proPath)+"_";
			}
		}
		return fileName;
	}
	//上传单图片
	public String updatePhoto(String photo,String path,String appPath,String proPath){
		String fileName="";
		if(photo!=null){
			fileName = UploadFileBiz.Upload(photo,path,appPath,proPath);
		}
		return fileName;
	}
	//处理图片的名字（实体类包含了总路径，这里要删除一下）
	public String getNewName(String oldName){
		String ip = ResourceBundle.getBundle("config").getString("domain");
		return oldName.replace(ip, "");
	}
}
