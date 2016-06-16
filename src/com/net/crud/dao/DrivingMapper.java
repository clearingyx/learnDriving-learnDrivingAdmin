package com.net.crud.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.crud.modal.Driving;
@Repository
public class DrivingMapper {

    /*int insert(Driving record);


    Driving selectByPrimaryKey(Integer id);
*/

	 @Autowired
	 SqlSessionFactory factory;
	 public int update(Driving record){
		 SqlSession session = factory.openSession();
		 int a = session.update("Driving.update",record);
		 session.close();
		 return a;
	 }
	 
    public List<Driving> drivingQuery(Map<String, Object> map){
    	 SqlSession session = factory.openSession();
    	 map.put("sql",  getDistance(map.get("driving")));
    	 List<Driving> list = session.selectList("Driving.driving_query",map);
    	 for (int i = 0; i < list.size(); i++) {
			String m = list.get(i).getDistance();
			if(!"0".equals(m)){
				Double d = Double.valueOf(m)/1000;
				BigDecimal   b   =   new   BigDecimal(d);  
				double   nd   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				list.get(i).setDistance(String.valueOf(nd)+"km");
			}else{
				list.get(i).setDistance("0.0km");
			}
		}
    	 session.close();
    	 return list;
    }
    
    public Driving drivingDetail(Integer id){
    	SqlSession session = factory.openSession();
    	Driving d = session.selectOne("Driving.selectByPrimaryKey",id);
    	session.close();
    	return d;
    }
    
    public String getDistance(Object o){
    	Driving d = (Driving)o;
    	String sql = "";
    	if(d.getS_position_x()!=0.0 && d.getS_position_y()!=0.0){
    		sql=",round(6378.138*2*asin(sqrt(pow(sin((s_position_x*pi()/180-"+d.getS_position_x()
    		+"*pi()/180)/2),2)+cos(s_position_x*pi()/180)*cos("+d.getS_position_x()
    		+"*pi()/180)*pow(sin((s_position_y*pi()/180-"+d.getS_position_y()
    		+"*pi()/180)/2),2)))*1000) as distance";
    	}else{
    		sql=",0.0 as distance";
    	}
    	return sql;
    }
}