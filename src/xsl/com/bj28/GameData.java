package xsl.com.bj28;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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
	private static Map<String, Object> Cana28Map = new HashMap<String, Object>();
	private static List<Map<String,Object>> mail=new ArrayList<Map<String,Object>>();
	//inc/gcom?method=getGameDataList  pageNo: 1
	///GTYPE: h5
	public static void GameData() throws UnsupportedEncodingException {
		CloseableHttpClient httpClient = FunUtil.HttpsClient();
		
		//id=14急速10；id=75 韩国10
		int id=Integer.parseInt(ConfUtil.ReadConfig("id28"));
		HttpGet httpGet = new HttpGet(ConfUtil.ReadConfig("url")+"game/getGameHomeList?id="+id+"&_=1581564108693");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Cache-Control", "no-cache");
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");

		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			String str = "";
			// log.info("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				InputStream instreams = responseEntity.getContent();
				str = Server.convertStreamToString(instreams);
			}
			
			//log.info(str.substring(0, 20));
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
				
				//Map<String, Object> r=list.get(3);
				Cana28Map.put("win_num", map.get("todayProfit").toString().split("\\.")[0]);
				Cana28Map.put("play_num", map.get("todayBuyNum").toString().split("\\.")[0]);
				Cana28Map.put("now_num",map.get("curLotteryNo").toString());
				Cana28Map.put("lastNum",map.get("lastLotteryNo").toString());
				Cana28Map.put("result",map.get("prizeCode").toString().split("\\.")[0]);	
				WinInfo();
				
				List<Integer> l1=SysResult(1);
				List<Integer> l2=SysResult(2);	
				List<Integer> l3=SysResult(3);	
				List<Integer> ResultList1=new ArrayList<>();				
				ResultList1.addAll(l1);
		        ResultList1.addAll(l2);
		        ResultList1.addAll(l3);
		        List<Integer> a1=touMin(FunUtil.frequencyOfListElements(ResultList1));
		        List<Integer> a2=touMax(FunUtil.frequencyOfListElements(ResultList1));
				Cana28Map.put("touMin",a1);
				Cana28Map.put("touMax",a2);	
				log.info("min:"+a1);
				log.info("max"+a2);
			}

			

		} catch (HttpHostConnectException e) {
			log.error("连接网址失败");
		} catch (ConnectException e) {
			log.error("连接超时");
			// TODO: handle exception
		}catch(JsonSyntaxException e){
			e.printStackTrace();
			log.info("json解析出错");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			log.info("访问主机失败！");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			//log.info("NumberFormatException");
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
	public static List<Integer> touMin(Map<String,Integer> map){
		 List<Integer> rlist=new ArrayList<>();
		 // 根据map的value排序
		List<Entry<String,Integer>> list=new ArrayList<Entry<String,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
			{
			double q1=o1.getValue();
			double q2=o2.getValue();
			double p=q2-q1;
			if(p<0){
			return 1;
			}
			else if(p==0){
			return 0;
			}
			else
			return -1;
			}
			});
		for(int i=0;i<2;i++){
			Map.Entry<String, Integer> set=list.get(i);
			rlist.add(Integer.valueOf(set.getKey().split("-")[1]));
		}
		return rlist;
	}
	public static List<Integer> touMax(Map<String,Integer> map){
		 List<Integer> rlist=new ArrayList<>();
		 // 根据map的value排序
		List<Entry<String,Integer>> list=new ArrayList<Entry<String,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
			{
			double q1=o1.getValue();
			double q2=o2.getValue();
			double p=q2-q1;
			if(p>0){
			return 1;
			}
			else if(p==0){
			return 0;
			}
			else
			return -1;
			}
			});
		for(int i=0;i<8;i++){
			Map.Entry<String, Integer> set=list.get(i);
			rlist.add(Integer.valueOf(set.getKey().split("-")[1]));
		}
		return rlist;
	}
	
	public static List<Integer> SysResult(int page) throws UnsupportedEncodingException {
		CloseableHttpClient httpClient = FunUtil.HttpsClient();
		int id=Integer.parseInt(ConfUtil.ReadConfig("id28"));
		HttpGet httpGet = new HttpGet(ConfUtil.ReadConfig("url")+"game/getGamePeriodDataList?id="+id+"&p="+page);
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Cache-Control", "no-cache");
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		
		List<Integer> rlist=new ArrayList<>();

		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			String str = "";
			// log.info("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				InputStream instreams = responseEntity.getContent();
				str = Server.convertStreamToString(instreams);
			}
			
			//log.info(str);
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
				List<Map<String, Object>> list=(List<Map<String, Object>>) map.get("datas");
				if(page==1){
					for(int i=3;i<list.size();i++){
						Map<String, Object> map2=list.get(i);
						rlist.add(Integer.valueOf(map2.get("prizeCode").toString())%10);
					}
				}else{
					for (Map<String, Object> map2 : list) {
						rlist.add(Integer.valueOf(map2.get("prizeCode").toString())%10);
					}
				}
				
				return rlist;
				
				
			}			

		} catch (HttpHostConnectException e) {
			log.error("连接网址失败");
		} catch (ConnectException e) {
			log.error("连接超时");
			// TODO: handle exception
		}catch(JsonSyntaxException e){
			e.printStackTrace();
			log.info("json解析出错");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			log.info("访问主机失败！");
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
		return rlist;
	}
	public static void WinInfo() throws UnsupportedEncodingException {
		CloseableHttpClient httpClient = FunUtil.HttpsClient();
		HttpGet httpGet = new HttpGet(ConfUtil.ReadConfig("url")+"game/gameIndex");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Cache-Control", "no-cache");
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			String str = "";
			// log.info("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				InputStream instreams = responseEntity.getContent();
				str = Server.convertStreamToString(instreams);
			}
			
			str=replace(str);
			str=str.substring(str.indexOf("UseMoney"),str.indexOf("银行"));
			str=str.substring(str.indexOf("<span"),str.indexOf("<img"));
			str=str.substring(str.indexOf("MoneyClass"),str.indexOf("/"));
			str=str.substring(str.indexOf(">")+1,str.indexOf("<"));
			Cana28Map.put("nowscore",str);
			log.info("score:"+str);
		

			

		} catch (HttpHostConnectException e) {
			log.error("连接网址失败");
		} catch (ConnectException e) {
			log.error("连接超时");
			// TODO: handle exception
		}catch(JsonSyntaxException e){
			e.printStackTrace();
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
	public static String replace(String str) {
	    String destination = "";
	    if (str!=null) {
	        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	        Matcher m = p.matcher(str);
	        destination = m.replaceAll("");
	    }
	    return destination;
	}
    public static boolean single_win(String str){
		
		try{
			String[] betting=Cana28Map.get(str).toString().split(",");
			String rs=Cana28Map.get("result").toString().split(",")[0];
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
 	public static int Result(String str){
		String[] result=str.split(",");
		int code=Integer.parseInt(result[0]);
		return code;
	}
	public static Map<String, Object> getCana28Map() {
		return Cana28Map;
	}
	public static void setCana28Map(Map<String, Object> fastTenMap) {
		Cana28Map = fastTenMap;
	}
	
}
