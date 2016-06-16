package com.net.crud.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.net.crud.modal.CollectionRecord;
import com.net.crud.modal.ForumReply;
import com.net.crud.modal.ForumTheme;
import com.net.crud.modal.PraiseRecord;
import com.net.util.JSONUtil;


@Controller
public class FourmHandler extends BaseHandler{
	
	//分类列表
	@ResponseBody
	@RequestMapping("forumCate")
	public Object forumCate(){
		return forumCateDao.forumCateList();
	}
	//主题分类浏览+1
	@ResponseBody
	@RequestMapping("forumCateBrowseAdd")
	public Object CateBrowseAdd(Integer id){
		return result(forumCateDao.browseAdd(id));
	}
	
	//主题列表
	@ResponseBody
	@RequestMapping("forumThemeList")
	public Object forumThemeList(ForumTheme ft,Integer pageIndex,Map<String, Object> map){
		ft.setT_isdisabled(1);
		map.put("forumTheme", ft);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return forumThemeDao.forumThemeQuery(map);
	}
	//主题浏览+1
	@ResponseBody
	@RequestMapping("forumThemeBrowseAdd")
	public Object ThemeBrowseAdd(Integer id){
		return result(forumThemeDao.browseAdd(id));
	}
	//发表主题
	@ResponseBody
	@RequestMapping("forumThemeAdd")
	public Object forumThemeAdd(String json,HttpServletRequest request){
		ForumTheme ft= JSONUtil.toBean(json, ForumTheme.class);		
		List<String> list = new ArrayList<String>();
		//如果普通用户的名字为空，则默认为管理员发的帖子
		if (ft.getNick_name()==null) {
			ft.setNick_name(adminDao.selectOne().getName());
		}
		if(ft.getP_photo()!=null && !"".equals(ft.getP_photo())){
			ft.setApi_p_photo(getNewName(ft.getP_photo()));
			ft.setP_photo("");//会自动装载对象将localhost也放进去，所以只好在起一个实体属性
		}
		if(ft.getFt_photos()!=null && !"".equals(ft.getFt_photos())){
			for(int i=0;i<ft.getFt_photos().size();i++){
				list.add(getNewName(ft.getFt_photos().get(i)));
			}
			//上传图片
			ft.setPhotos(updatePhotos(list, "forumTheme",request.getSession().getServletContext().getRealPath("/upload"),request.getContextPath()+"/upload/"));
		}
		return result(forumThemeDao.forumThemeAdd(ft));
	}
	
	//回帖列表
	@ResponseBody
	@RequestMapping("forumReplyList")
	public Object forumReplyList(ForumReply fr,Integer pageIndex,Map<String, Object> map){
		fr.setT_isdisabled(1);
		map.put("forumReply", fr);
		map.put("begin", pageIndex);
		map.put("end", pageSize);
		return forumReplyDao.forumReplyQuery(map);		
	}
	//发表回复
	@ResponseBody
	@RequestMapping("forumReplyAdd")
	public Object forumReplyAdd(String json,HttpServletRequest request){
		ForumReply fr= JSONUtil.toBean(json, ForumReply.class);
		if(fr.getP_photo()!=null && !"".equals(fr.getP_photo())){
			fr.setApi_p_photo(getNewName(fr.getP_photo()));
			fr.setP_photo("");
		}
		if(fr.getTheme_name()!=null && !"".equals(fr.getTheme_name())){
			fr.setU_reply_content(fr.getTheme_name()+" "+fr.getTheme_date()+"|"+fr.getTheme_content());
		}
		List<String> list = new ArrayList<String>();
		if(fr.getPhotos()!=null && !"".equals(fr.getPhotos())){
			String[] s = fr.getPhotos().trim().split("_");
			for(int i=0;i<s.length;i++){
				list.add(s[i]);
			}
			//上传图片
			fr.setPhotos(updatePhotos(list, "forumReply",request.getSession().getServletContext().getRealPath("/upload"),request.getContextPath()+"/upload/"));
		}
		return result(forumReplyDao.forumReplyAdd(fr));
	}
	
	//主题点赞
	@ResponseBody
	@RequestMapping("praiseAddByTheme")
	public Object praiseAddByTheme(PraiseRecord pr){
		pr.setType(2);
		return result(praiseRecordDao.praiseAddByTheme(pr));
	}
	
	//取消点赞
	@ResponseBody
	@RequestMapping("praiseSubByTheme")
	public Object praiseSubByTheme(PraiseRecord pr){
		pr.setType(2);
		return result(praiseRecordDao.praiseSubByTheme(pr));
	}
	
	//收藏主题
	@ResponseBody
	@RequestMapping("collectionRecordTheme")
	public Object collectionRecordTheme(CollectionRecord cr){
		cr.setType(2);
		return result(collerctionRecordDao.insert(cr));
	}
}
