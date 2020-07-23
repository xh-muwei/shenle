package xsl.com.fast11;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import xsl.com.main.Server;
import xsl.com.tool.ConfUtil;
import xsl.com.tool.FunUtil;
import xsl.com.tool.GsonUtil;

import com.google.gson.JsonSyntaxException;

public class GameData {
	protected final static Log log = LogFactory.getLog(GameData.class);
	private static Map<String, Object> FastElevenMap = new HashMap<String, Object>();
	private static List<Map<String,Object>> mail=new ArrayList<Map<String,Object>>();
	

	
	public static Map<String, Object> getFastElevenMap() {
		return FastElevenMap;
	}
	public static void setFastElevenMap(Map<String, Object> fastElevenMap) {
		FastElevenMap = fastElevenMap;
	}
	public static void GameData() throws UnsupportedEncodingException {
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(Server.getCookieStore()).build();
		HttpPost httpPost = new HttpPost(ConfUtil.ReadConfig("url")+"AJAX/game/gameindex.ashx");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("action", "default");
		paramMap.put("gameid", 1);
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
			log.info(str.substring(0, 20));
			if(str.contains("您的账号")){
				log.info("你的账号已在别处登陆");
				Server.setLogin(false);
				
			}else if(str.contains("登录新世纪")){
				log.info("你的账号已在别处登陆");
				Server.setLogin(false);
				Server.setLogin(false);
			}else if(str.length()>30000){
				log.info("返回数据异常");
				Server.setLogin(false);
			}else{
				Map<String, Object> map = GsonUtil.json2Object(str, Map.class);
				List<Map<String,Object>> dlist=(List<Map<String, Object>>) map.get("dt");
				Map<String, Object> data=dlist.get(4);
				FastElevenMap.put("win_num", FunUtil.StringToInt2(map.get("wins").toString()));
				FastElevenMap.put("mymoney",Integer.parseInt(map.get("mymoney").toString()));
				FastElevenMap.put("now_num",map.get("readyid").toString());
				FastElevenMap.put("readyid", map.get("readyid").toString());
				FastElevenMap.put("result", data.get("WinNumber").toString().split("\\.")[0]);
				FastElevenMap.put("resultStr", data.get("WinNumber").toString().split("\\.")[0]);
				
			}

			

		} catch (HttpHostConnectException e) {
			log.error("连接网址失败");
		} catch (ConnectException e) {
			log.error("连接超时");
			// TODO: handle exception
		}catch(JsonSyntaxException e){
			log.info("json解析出错");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			log.info("访问主机失败！");
		} catch (NumberFormatException e) {
			log.info("NumberFormatException");
		}catch (IOException e) {
			// TODO Auto-generated catch block
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
    public static boolean single_win(String str){
		
		try{
			String[] betting=FastElevenMap.get(str).toString().split(",");
			String rs=FastElevenMap.get("result").toString();
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
}
	