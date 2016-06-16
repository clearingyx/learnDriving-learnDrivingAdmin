package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.ForumTheme;
@Repository
public class ForumThemeMapper{
	private static Logger log = Logger.getLogger(ForumThemeMapper.class);
   /* int insert(ForumTheme record);


    ForumTheme selectByPrimaryKey(Integer id);


    int update(ForumTheme record);*/
	@Autowired
	SqlSessionFactory factory;
	
	public List<ForumTheme> forumThemeQuery(Map<String, Object> map){
		SqlSession session = factory.openSession();
		List<ForumTheme> list= session.selectList("ForumTheme.forumThemeQuery",map);
		session.close();
		return list;
	}
	public int browseAdd(Integer id){
		SqlSession session = factory.openSession();
		int a= session.update("ForumTheme.browseAdd",id);		
		session.close();
		return a;
	}
	public int forumThemeAdd(ForumTheme ft){
		SqlSession session = factory.openSession(false);
		int b = 0;
		//添加主题
		int a = session.insert("ForumTheme.insert",ft);
		if(a>0){
			//分类列表主题数+1
			b = session.update("ForumCate.themeAdd",ft.getCate_id());
			if(b>0)
				session.commit();
			else
				log.error("分类列表主题数+1失败！");
		}else
			log.error("添加主题失败！");		
		session.close();
		return b;
	}
	
	//用户的收藏主题列表
	public List<ForumTheme> CollectionRecordThemeList(Map<String, Object> map){
		SqlSession session = factory.openSession();
		List<ForumTheme> list = session.selectList("ForumTheme.collectionRecordThemeList",map);
		session.close();
		return list;
	}
}