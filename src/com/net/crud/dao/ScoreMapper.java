package com.net.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Score;
@Repository
public class ScoreMapper {
   /* int insert(Score record);
    Score selectByPrimaryKey(Integer id);
    int update(Score record);*/
	
	@Autowired
	SqlSessionFactory factory;
	
	public List<Score> selectByDrvingScoreList(Map<String, Object> map){
		SqlSession session = factory.openSession();
		List<Score> list = session.selectList("Score.selectByDrvingScoreList",map);
		session.close();
		return list;
	}
	
	public int insert(Score s){
		SqlSession session = factory.openSession();
		int a = session.insert("Score.insert",s);
		session.close();
		return a;
	}
	
	public List<Score> selectScoreListByType(Score s){
		SqlSession session = factory.openSession();
		List<Score> list = session.selectList("Score.selectScoreListByType",s);
		session.close();
		return list;
	}
	public Float selectScoreAve(Score s){
		SqlSession session = factory.openSession();
		Float f = session.selectOne("Score.selectScoreAve",s);
		session.close();
		return f;
	}
}