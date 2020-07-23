package xsl.com.fast10;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import xsl.com.fast10.GameData;
import xsl.com.main.Server;
import xsl.com.tool.ConfUtil;
import xsl.com.tool.FunUtil;
import xsl.com.tool.GsonUtil;
import xsl.com.tool.Send163MailUtil;

import com.google.gson.JsonSyntaxException;

public class Copy_2_of_Betting {
	protected final static Log log = LogFactory.getLog(Copy_2_of_Betting.class);
	private static List<Map<String,Object>> mail=new ArrayList<Map<String,Object>>();
	private static int bet_num=0;
	private static int run_num=0;
	private static int betting_index1=1;
	private static int betting_index2=1;
	private static int betting_index3=1;
	private static int betting_index4=1;
	private static int betting_index5=1;
	private static int betting_index6=1;
	private static int betting_index7=1;
	private static int betting_index8=1;
	private static int betting_index9=1;
	private static int betting_index10=1;
	private static int betting_index11=1;
	private static int betting_index12=1;
	private static int betting_index13=1;
	private static int betting_index14=1;
	private static int betting_index15=1;
	private static int betting_index16=1;
	private static int betting_index17=1;
	private static int betting_index18=1;
	private static int betting_index19=1;
	private static int betting_index20=1;
	private static int betting_index21=1;
	private static int betting_index22=1;
	private static int betting_index23=1;
	private static int betting_index24=1;
	private static int betting_index25=1;
	private static int betting_index26=1;
	private static int betting_index27=1;
	private static int betting_index28=1;
	private static int betting_index29=1;
	private static int betting_index30=1;
	private static int betting_index31=1;
	private static int betting_index32=1;
	private static int betting_index33=1;
	private static int betting_index34=1;
	private static int betting_index35=1;
	private static int betting_index36=1;
	private static int betting_index37=1;
	private static int betting_index38=1;
	private static int betting_index39=1;
	private static int betting_index40=1;
	private static List<Integer> list1=new ArrayList<Integer>();
	private static List<Integer> list2=new ArrayList<Integer>();
	private static List<Integer> list3=new ArrayList<Integer>();
	private static List<Integer> list4=new ArrayList<Integer>();
	private static List<Integer> list5=new ArrayList<Integer>();
	private static List<Integer> list6=new ArrayList<Integer>();
	private static List<Integer> list7=new ArrayList<Integer>();
	private static List<Integer> list8=new ArrayList<Integer>();
	private static List<Integer> list9=new ArrayList<Integer>();
	private static List<Integer> list10=new ArrayList<Integer>();
	private static List<Integer> list11=new ArrayList<Integer>();
	private static List<Integer> list12=new ArrayList<Integer>();
	private static List<Integer> list13=new ArrayList<Integer>();
	private static List<Integer> list14=new ArrayList<Integer>();
	private static List<Integer> list15=new ArrayList<Integer>();
	private static List<Integer> list16=new ArrayList<Integer>();
	private static List<Integer> list17=new ArrayList<Integer>();
	private static List<Integer> list18=new ArrayList<Integer>();
	private static List<Integer> list19=new ArrayList<Integer>();
	private static List<Integer> list20=new ArrayList<Integer>();
	private static List<Integer> list21=new ArrayList<Integer>();
	private static List<Integer> list22=new ArrayList<Integer>();
	private static List<Integer> list23=new ArrayList<Integer>();
	private static List<Integer> list24=new ArrayList<Integer>();
	private static List<Integer> list25=new ArrayList<Integer>();
	private static List<Integer> list26=new ArrayList<Integer>();
	private static List<Integer> list27=new ArrayList<Integer>();
	private static List<Integer> list28=new ArrayList<Integer>();
	private static List<Integer> list29=new ArrayList<Integer>();
	private static List<Integer> list30=new ArrayList<Integer>();
	private static List<Integer> list31=new ArrayList<Integer>();
	private static List<Integer> list32=new ArrayList<Integer>();
	private static List<Integer> list33=new ArrayList<Integer>();
	private static List<Integer> list34=new ArrayList<Integer>();
	private static List<Integer> list35=new ArrayList<Integer>();
	private static List<Integer> list36=new ArrayList<Integer>();
	private static List<Integer> list37=new ArrayList<Integer>();
	private static List<Integer> list38=new ArrayList<Integer>();
	private static List<Integer> list39=new ArrayList<Integer>();
	private static List<Integer> list40=new ArrayList<Integer>();
	public static Map<String, Object> mode1(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			if(GameData.getFastTenMap().get("bettingNum1")==null){
				GameData.getFastTenMap().put("index1", 1);
				list1=ListValue();
			}else{
				if(!single_win("bettingNum1")){
					if(betting_index1==1){
						betting_index1=2;
					}else{
						betting_index1=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index1").toString())>=bet_max){
						list1=ListValue();
						GameData.getFastTenMap().put("index1", 1);
						GameData.getFastTenMap().
						put("m1", GameData.getFastTenMap().get("m1")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m1").toString())+1));
					}else{
						GameData.getFastTenMap().put("index1", 
								Integer.parseInt(GameData.getFastTenMap().get("index1").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index1", 1);
					list1=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index1").toString());
			int mode=getMode(index);
			/*if(mode==0){
				list=list1;
			}else{
				list1=otherList(list1,mode);
				list=list1;
				
			}*/
			list=(List<Integer>) GameData.getFastTenMap().get("touMin");
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum1",str.toString());
			return map;
		}
	    public static Map<String, Object> mode2(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value2"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max2"));
			
			if(GameData.getFastTenMap().get("bettingNum2")==null){
				GameData.getFastTenMap().put("index2", 1);
				list2=ListValue();
			}else{
				if(!single_win("bettingNum2")){
					if(betting_index2==1){
						betting_index2=2;
					}else{
						betting_index2=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index2").toString())>=bet_max){
						list2=ListValue();
						GameData.getFastTenMap().put("index2", 1);
						GameData.getFastTenMap().
						put("m2", GameData.getFastTenMap().get("m2")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m2").toString())+1));
					}else{
						GameData.getFastTenMap().put("index2", 
								Integer.parseInt(GameData.getFastTenMap().get("index2").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index2", 1);
					list2=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index2").toString());
			int mode=getMode(index);
			/*if(mode==0){
				list=list2;
			}else{
				list2=otherList(list2,mode);
				list=list2;
			}*/
			list=(List<Integer>) GameData.getFastTenMap().get("touMax");
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingTwoValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum2",str.toString());
			return map;
		}
	   
	    public static Map<String,Object> FullMap(){
			Map<String,Object> map=new HashMap<String,Object>();

			map.put("tb0", 1);
			map.put("tb14", 75);
			map.put("tb1", 3);
			map.put("tb15", 73);
			map.put("tb2", 6);
			map.put("tb16", 69);
			map.put("tb3", 10);
			map.put("tb17", 63);
			map.put("tb4", 15);
			map.put("tb18", 55);
			map.put("tb5", 21);
			map.put("tb19", 45);
			map.put("tb6", 28);
			map.put("tb20", 36);
			map.put("tb7", 36);
			map.put("tb21", 28);
			map.put("tb8", 45);
			map.put("tb22", 21);
			map.put("tb9", 55);
			map.put("tb23", 15);
			map.put("tb10", 63);
			map.put("tb24", 10);
			map.put("tb11", 69);
			map.put("tb25", 6);
			map.put("tb12", 73);
			map.put("tb26", 3);
			map.put("tb13", 75);
			map.put("tb27", 1);
			return map;
		}
	    public static int  getMode(int index){
	    	String[] xx=ConfUtil.ReadConfig("hg10_bet_mode_index").split(",");
	    	for(int i=0;i<xx.length;i++){
	    		int a=Integer.parseInt(xx[i]);
	    		if(i==index-1){
	    			return a;
	    		}
	    	}
	    	return 0;
	    }
	    public static List<Integer> ListValue(){
	    	List<Integer> list1=new ArrayList<Integer>();
	    	List<Integer> list2=new ArrayList<Integer>();
	    	for(int i=1;i<=5;i++){
				list1.add(i);
			}
	    	for(int i=6;i<=10;i++){
				list2.add(i);
			}
			Collections.shuffle(list1);
			Collections.shuffle(list2);
			List<Integer> rs=new ArrayList<Integer>();
			rs=(List<Integer>) GameData.getFastTenMap().get("touMin");
			
			return rs;
	    }
	    public static List<Integer> otherList(List<Integer> paramList,int mode){
	    	List<Integer> list1=new ArrayList<Integer>();
	    	List<Integer> list2=new ArrayList<Integer>();
	    	for(int i=1;i<=5;i++){
				list1.add(i);
			}
	    	for(int i=6;i<=10;i++){
				list2.add(i);
			}	   	    	
			Collections.shuffle(list1);
			Collections.shuffle(list2);
			List<Integer> rs=new ArrayList<Integer>();
			if(mode==1){
				rs=ListValue();
			}else if(mode==2){
				for(int i=1;i<10;i++){
					rs.add(i);
					
				}
				if(GameData.getFastTenMap().get("touMin")!=null){
					List<Integer> xx=(List<Integer>) GameData.getFastTenMap().get("touMin");
					rs.removeAll(xx);
				}else{
					rs=ListValue();
				}
				
			}else if(mode==3){
				for(int i=1;i<10;i++){
					rs.add(i);
					
				}
				if(GameData.getFastTenMap().get("touMax")!=null){
					rs=(List<Integer>) GameData.getFastTenMap().get("touMax");
					
				}else{
					rs=ListValue();
				}
				
			}else if(mode==4){
				for(int i=1;i<10;i++){
					rs.add(i);	
				}
				if(GameData.getFastTenMap().get("touMax")!=null){
					List<Integer> list=(List<Integer>) GameData.getFastTenMap().get("touMax");
					List<Integer> listxx=new ArrayList<>();
					Collections.shuffle(list);
					Collections.shuffle(list);
					for(int i=0;i<2;i++){
						listxx.add(list.get(i));
					}
					rs.remove(listxx);
					
				}else{
					rs=ListValue();
				}
				
			}else if(mode==11){
				rs=(List<Integer>) GameData.getFastTenMap().get("touMin");
				
			}else if(mode==12){
				rs=(List<Integer>) GameData.getFastTenMap().get("touMax");
				
			}
			
			return rs;
	    }
 	public static Map<String, Object> BigMode(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", GameData.getFastTenMap().get("now_num"));
		Map<String, Object> map1=mode1();
		Map<String, Object> map2=mode2();
		
		int all=0;
		int xx=0;
		for(int i=1;i<=10;i++){	
			int a=0;
		    a+=Integer.parseInt(map1.get("tb"+i)==null?"0":map1.get("tb"+i).toString());
		    a+=Integer.parseInt(map2.get("tb"+i)==null?"0":map2.get("tb"+i).toString());
			xx+=a;
			
		}
		StringBuilder tz=new StringBuilder();
		for(int i=1;i<=10;i++){	
			int a=0;
			if(xx<1000){
				a+=100;
			}
			a+=Integer.parseInt(map1.get("betting[f"+i+"]")==null?"0":map1.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map2.get("betting[f"+i+"]")==null?"0":map2.get("betting[f"+i+"]").toString());
				if(a>0){
					tz.append(i+":"+a);
					tz.append(",");
				}else{
				}
			all+=a;
		}
		map.put("total", all);
		map.put("d", tz.toString());
		log.info("本期投注："+all);
	
		return map;
	}
	 public static boolean single_win(String str){
		 try{
				String[] betting=GameData.getFastTenMap().get(str).toString().split(",");
				String rs=GameData.getFastTenMap().get("result").toString().split(",")[0];
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
			String[] num=ConfUtil.ReadConfig("hg10_bet_one_value").split(",");
			
			int a=Integer.parseInt(num[index-1]);
			
			return a;
		}
		public static int BettingTwoValue(int index){
			String[] num=ConfUtil.ReadConfig("hg10_bet_one_value2").split(",");
			
			int a=Integer.parseInt(num[index-1]);
			
			return a;
		}
	public static int BettingValue(int index){
		String ss=ConfUtil.ReadConfig("jx_model");
		String[] num={
				"1",
				"2",
				"4",
				"8",
				"16","32","64","128"
				};
		/*String[] num={
				"1",
				"2",
				"4",
				"8",
				"16",
				"32","64","128","1",
				"1","1","1"
				};*/
		//String[] num=ss.split(",");
		int a=Integer.parseInt(num[index-1]);
		
		return a;
	}
	public static void Log_Result(){
	    log.info("Cana10总运行期数："+(++run_num));
	    log.info("Cana10总投注期数："+(bet_num));
		log.info("Cana10上期结果："+GameData.getFastTenMap().get("result"));
		log.info("本期投注1->"+GameData.getFastTenMap().get("bettingNum1")+";index10->"+GameData.getFastTenMap().get("index1")+";m->"+(GameData.getFastTenMap().get("m1")==null?0:GameData.getFastTenMap().get("m1")));
		log.info("本期投注2->"+GameData.getFastTenMap().get("bettingNum2")+";index10->"+GameData.getFastTenMap().get("index2")+";m->"+(GameData.getFastTenMap().get("m2")==null?0:GameData.getFastTenMap().get("m2")));
		
		log.info("当前序号："+GameData.getFastTenMap().get("now_num"));
		log.info("投注序号："+GameData.getFastTenMap().get("old_num"));
		log.info("当前win："+GameData.getFastTenMap().get("win_num"));
		log.info("当前分值："+GameData.getFastTenMap().get("nowscore"));
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("SCORE", GameData.getFastTenMap().get("win_num"));
		map.put("value", GameData.getFastTenMap().get("nowscore"));
		mail.add(map);
		if(mail.size()>=50){
			String ss=mail.get(mail.size()-1).toString();
			try {
				Send163MailUtil.send("hg10",ss);
				mail.clear();
				
			} catch (NoClassDefFoundError e) {
				log.error("没法找到邮件类");
			}
			
		}
			
	
			
		}

	public static void Betting(Map<String, Object> paramMap) throws UnsupportedEncodingException {
		int num=Integer.parseInt(paramMap.get("total").toString());
		int win_max=Integer.parseInt(ConfUtil.ReadConfig("jx_win_max"));
		int win_min=Integer.parseInt(ConfUtil.ReadConfig("jx_win_min"));
		int c=Integer.parseInt(ConfUtil.ReadConfig("hg10_nowindex"));
		if(Float.parseFloat(GameData.getFastTenMap().get("win_num").toString())>=win_max){
			log.info("达到盈利上限，本期不投");
			GameData.getFastTenMap().put("old_num", GameData.getFastTenMap().get("now_num"));
			return;
		}
		if(Float.parseFloat(GameData.getFastTenMap().get("win_num").toString())<=win_min){
			log.info("达到亏损上限，本期不投");
			GameData.getFastTenMap().put("old_num", GameData.getFastTenMap().get("now_num"));
			return;
		}
		if(num==0){
			log.info("投注总数为0，本期不投注");
			GameData.getFastTenMap().put("old_num", GameData.getFastTenMap().get("now_num"));
			return;
		}
		if(num>=600000*c){
			log.info("你怎么能这么投呢,我不让你投，本期不投注");
			GameData.getFastTenMap().put("old_num", GameData.getFastTenMap().get("now_num"));
			return;
		}
		log.info("开始进行投注");
		int id=Integer.parseInt(ConfUtil.ReadConfig("id10"));

		CloseableHttpClient httpClient = FunUtil.HttpsClient();
		HttpGet httpGet = new HttpGet(ConfUtil.ReadConfig("url")+"game/inSert?gameId="+id+"&lotteryNo="+paramMap.get("num")+"&d="+paramMap.get("d"));
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
			log.info("投注结果："+str);
		
			if(!str.trim().contains("507")){
				GameData.getFastTenMap().put("old_num", GameData.getFastTenMap().get("now_num"));
				log.info("投注成功");
				bet_num++;
			}else{
				log.info("投注失败："+str);
			}

		}catch(JsonSyntaxException e){
			e.printStackTrace();
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
