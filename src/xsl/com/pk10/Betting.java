package xsl.com.pk10;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import xsl.com.main.Server;
import xsl.com.tool.ConfUtil;
import xsl.com.tool.GsonUtil;
import xsl.com.tool.Send163MailUtil;

import com.google.gson.JsonSyntaxException;

public class Betting {
	protected final static Log log = LogFactory.getLog(Betting.class);
	private static List<Map<String,Object>> mail=new ArrayList<Map<String,Object>>();
	private static int bet_num=0;
	private static List<String> mode() {
		List<String> list=new ArrayList<>();
		list.add("2,3,4,5,6,11,12");
		list.add("5,6,7,11,12");
		list.add("6,7,8");
		list.add("5,6,8,9");
		list.add("2,3,7,8,9");
		return list;	
	}
	
	public static Map<String, Object> mode11(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("pk10_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("pk10_bet_max"));
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<11;i++){
			list.add(i);
		}		
		Collections.shuffle(list);
		Collections.shuffle(list);
		Collections.shuffle(list);
		if(GameData.getPK10Map().get("bettingNum11")==null){
			GameData.getPK10Map().put("index11", 1);
		}else{
			if(!single_win("bettingNum11")){
		
				if(Integer.parseInt(GameData.getPK10Map().get("index11").toString())>=bet_max){
					GameData.getPK10Map().put("index11", 1);
					GameData.getPK10Map().
					put("m11", GameData.getPK10Map().get("m11")==null?1:
						(Integer.parseInt(GameData.getPK10Map().get("m11").toString())+1));
				}else{
					GameData.getPK10Map().put("index11", 
							Integer.parseInt(GameData.getPK10Map().get("index11").toString())+1);
				}
						
			}else{
				GameData.getPK10Map().put("index11", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getPK10Map().get("index11").toString());
		for(int j=1;j<list.size();j++){
			map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
			str.append(list.get(j));
			str.append(",");
		}	
		
		GameData.getPK10Map().put("bettingNum11",str.toString());
		return map;
	}
	
 
	public static Map<String, Object> BigMode(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("action", "action");
		map.put("gameid", 11);
		map.put("r", bet_num);
		map.put("issueid", GameData.getPK10Map().get("now_num"));
		List<String> list=mode();
		Collections.shuffle(list);
		Collections.shuffle(list);
		Collections.shuffle(list);
		Map<String, Object> map11=mode11(list.get(0));
		int all=0;
		for(int i=1;i<=10;i++){	
			int a=0;
			a+=Integer.parseInt(map11.get("betting[f"+i+"]")==null?"0":map11.get("betting[f"+i+"]").toString());
			
			
			map.put("tb"+i, a);	
			all+=a;
		}
		log.info("本期投注："+all);
	
		return map;
	}
	 public static boolean single_win(String str){
		 try{
				String[] betting=GameData.getPK10Map().get(str).toString().split(",");
				String rs=GameData.getPK10Map().get("result").toString();
				int code=Integer.parseInt(rs);
				for (String string : betting) {
					if(code==Integer.parseInt(string)){
						return true;
					}
				}			
			}catch(NullPointerException e){
				return false;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			return false;		
		}
		public static int BettingOneValue(int index){
			String[] num=ConfUtil.ReadConfig("pk10_bet_mode").split(",");
			
			int a=Integer.parseInt(num[index-1]);
			
			return a;
		}
	   public static int FullMap(int index){
		
		Map<String,Object> map=new HashMap<>();
		map.put("tb2","10");
		map.put("tb3","20");
		map.put("tb4","30");
		map.put("tb5","40");
		map.put("tb6","50");
		map.put("tb7","60");	
		map.put("tb8","50");
		map.put("tb9","40");
	    map.put("tb10","30");
		map.put("tb11","20");
		map.put("tb12","10");
		
		int a=Integer.parseInt(map.get("tb"+index).toString());
		
		return  a;
	}
	public static void Log_Result(){
	    log.info("PK10总投注期数："+(++bet_num));
		log.info("PK10上期结果："+GameData.getPK10Map().get("result"));
	   log.info("============================================================");
		log.info("本期投注11->"+GameData.getPK10Map().get("bettingNum11")+";index->"+GameData.getPK10Map().get("index11")+";m->"+(GameData.getPK10Map().get("m11")==null?0:GameData.getPK10Map().get("m11")));
		log.info("当前序号："+GameData.getPK10Map().get("now_num"));
		log.info("投注序号："+GameData.getPK10Map().get("old_num"));
		log.info("当前分值："+GameData.getPK10Map().get("win_num"));
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("SCORE", GameData.getPK10Map().get("win_num"));
		map.put("value", GameData.getPK10Map().get("score"));
		mail.add(map);
		if(mail.size()>=120){
			String ss=mail.get(mail.size()-1).toString();
			try {
				Send163MailUtil.send("pk10",ss);
				mail.clear();
			
				
			} catch (Exception e) {
			}
			
		}
			
		}

	public static void Betting(Map<String, Object> paramMap) throws UnsupportedEncodingException {
		Iterator entries = paramMap.entrySet().iterator(); 
		int num=0;
		while (entries.hasNext()) { 
		  Map.Entry entry = (Map.Entry) entries.next(); 
		  String key = entry.getKey().toString(); 
		  String value =entry.getValue().toString(); 
		  if(key.contains("tb")){
			  num+=Integer.parseInt(value);
		  }
		  
		}
		if(num==0){
			log.info("本期不投注");
			GameData.getPK10Map().put("old_num", GameData.getPK10Map().get("now_num"));
			return;
		}

		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultCookieStore(Server.getCookieStore()).build();
		/*BasicClientCookie cookie = new BasicClientCookie("p_mapid", "5");
		cookie.setVersion(0);
		cookie.setDomain("vip.xsj2800.com"); // 设置范围
		cookie.setPath("/");
		Server.getCookieStore().addCookie(cookie);*/
		HttpPost httpPost = new HttpPost(
				ConfUtil.ReadConfig("url")+"AJAX/game/gameindex.ashx");
		String jsonString = GsonUtil.object2Json(paramMap);
		//log.info(jsonString);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 遍历map，设置参数到list中
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()
					.toString()));
		}

		// 创建form表单对象
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,
				"utf-8");
		formEntity
				.setContentType("Content-Type:application/x-www-form-urlencoded");

		httpPost.addHeader("Content-type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setHeader("Accept",
				"application/json, text/javascript, */*; q=0.01");
		httpPost.setEntity(formEntity);
		httpPost.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Cache-Control", "no-cache");
		httpPost.setHeader("X-Requested-With", "XMLHttpRequest");

		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpPost);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			String str = "";
			// log.info("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				InputStream instreams = responseEntity.getContent();
				str = Server.convertStreamToString(instreams);
			}
			log.info(str);
			Map<String, Object> map = GsonUtil.json2Object(str, Map.class);
			log.info(map);
			if(map.get("ok")!=null && map.get("ok").toString()=="true"){
				GameData.getPK10Map().put("old_num", GameData.getPK10Map().get("now_num"));
				log.info("投注成功");
				bet_num++;
			}

			
			

		}catch(JsonSyntaxException e){
			log.info("json解析出错");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (UnknownHostException e) {
			log.info("访问主机失败！");
		}  catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
