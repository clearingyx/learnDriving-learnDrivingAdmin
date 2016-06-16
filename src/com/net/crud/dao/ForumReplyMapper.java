package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.ForumReply;
import com.net.crud.modal.ForumTheme;
@Repository
public class ForumReplyMapper {

    /*int insert(ForumReply record);


    ForumReply selectByPrimaryKey(Integer id);


    int update(ForumReply record);*/
	private static Logger log = Logger.getLogger(ForumThemeMapper.class);
	@Autowired
	SqlSessionFactory factory;
	
	public List<ForumReply> forumReplyQuery(Map<String, Object> map){
		SqlSession session = factory.openSession();
		List<ForumReply> list= session.selectList("ForumReply.forumReplyQuery",map);
		session.close();
		return list;
	}
	
	public int forumReplyAdd(ForumReply fr){
		SqlSession session = factory.openSession(false);
		int b = 0;
		//添加回复
		int a = session.insert("ForumReply.insert",fr);
		if(a>0){
			//分类列表主题数+1
			b = session.update("ForumTheme.replyAdd",fr.getF_id());
			if(b>0)
				session.commit();
			else
				log.error("主题回复数+1失败！");
		}else
			log.error("添加回复失败！");		
		session.close();
		return b;
	}
}