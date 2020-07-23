package xsl.com.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xsl.com.tool.GsonUtil;


public class CodeImgHandle {
	protected final static Log log = LogFactory.getLog(CodeImgHandle.class);
	public static void main(String[] args) throws Exception {
		System.out.println(score());
	}
	public static String code(){
		String code="";
		String username="hero0802";
		String password="123456";
		String softid="899960";
		//4004
		String codetype="1902";
		String len_min="0";
		String filePath="c:/code/code.png";		
		String rs=ChaoJiYing.PostPic(username, password, softid, codetype, len_min, filePath);
		Map<String,Object> map=GsonUtil.json2Object(rs, Map.class);
		log.info("验证码解析结果："+map);
		if(Float.parseFloat(map.get("err_no").toString())==0){
			code=map.get("pic_str").toString();
			Server.setCodeId(map.get("pic_id").toString());
			return code;
		}else{
			ChaoJiYing.ReportError(username, password, softid, map.get("pic_id").toString());
		}
		return "";
	}
	public static void code(String id){
		String username="hero0802";
		String password="123456";
		String softid="899960";
		ChaoJiYing.ReportError(username, password, softid,id);
	}
	
	public static String score(){
		String username="hero0802";
		String password="123456";
		String score=ChaoJiYing.GetScore(username, password);
		Map<String,Object> map=GsonUtil.json2Object(score, Map.class);
		log.info("题分解析结果："+map);
		return map.get("tifen").toString();
	}
	
}
