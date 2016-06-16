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
import com.net.crud.modal.PraiseRecord;
@Repository
public class PraiseRecordMapper {

   /* int insert(PraiseRecord record);

    PraiseRecord selectByPrimaryKey(Integer id);

    int update(PraiseRecord record);*/
	
	private static Logger log = Logger.getLogger(ForumThemeMapper.class);
	@Autowired 
	SqlSessionFactory factory;
	
	public int praiseAddByTheme(PraiseRecord pr){
		SqlSession session = factory.openSession(false);
		int b = 0;
		int a = session.insert("PraiseRecord.insert",pr);
		if(a>0){
			//主题点赞数+1
			b = session.update("ForumTheme.praiseAdd",pr.getOther_id());
			if(b>0)
				session.commit();
			else
				log.error("添加主题点赞记录失败！");
		}else
			log.error("增加主题点赞数量失败！");		
		session.close();
		return b;
	}
	public int praiseSubByTheme(PraiseRecord pr){
		SqlSession session = factory.openSession(false);
		int b = 0;
		int a = session.delete("PraiseRecord.delete",pr);
		if(a>0){
			//主题点赞数-1
			b = session.update("ForumTheme.praiseSub",pr.getOther_id());
			if(b>0)
				session.commit();
			else
				log.error("减少主题点赞记录失败！");
		}else
			log.error("删除点赞记录！");		
		session.close();
		return b;
	}
	public int praiseAddByScore(PraiseRecord pr){
		SqlSession session = factory.openSession(false);
		int b = 0;
		//判断是否点过赞
		List<PraiseRecord> plist = session.selectList("PraiseRecord.selectByCondition",pr);
		if(plist.size()==0){
			int a = session.insert("PraiseRecord.insert",pr);
			if(a>0){
				//评论点赞数+1
				b = session.update("Score.praiseAdd",pr.getOther_id());
				if(b>0)
					session.commit();
				else
					log.error("添加评论点赞记录失败！");
			}else
				log.error("增加主题点赞数量失败！");		
		}
		session.close();
		return b;
	}
	public int praiseSubByScore(PraiseRecord pr){
		SqlSession session = factory.openSession(false);
		int b = 0;
		int a = session.delete("PraiseRecord.delete",pr);
		if(a>0){
			//评论点赞数-1
			b = session.update("Score.praiseSub",pr.getOther_id());
			if(b>0)
				session.commit();
			else
				log.error("减少评论点赞记录失败！");
		}else
			log.error("删除点赞记录！");		
		session.close();
		return b;
	}
}