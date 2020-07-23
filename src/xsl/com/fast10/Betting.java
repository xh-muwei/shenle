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

public class Betting {
	protected final static Log log = LogFactory.getLog(Betting.class);
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
			if(mode==0){
				list=list1;
			}else{
				list1=otherList(list1,mode);
				list=list1;
				
			}
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
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
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
			if(mode==0){
				list=list2;
			}else{
				list2=otherList(list2,mode);
				list=list2;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum2",str.toString());
			return map;
		}
	    public static Map<String, Object> mode3(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));

			if(GameData.getFastTenMap().get("bettingNum3")==null){
				GameData.getFastTenMap().put("index3", 1);
				list3=ListValue();
			}else{
				if(!single_win("bettingNum3")){
					if(betting_index3==1){
						betting_index3=2;
					}else{
						betting_index3=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index3").toString())>=bet_max){
						list3=ListValue();
						GameData.getFastTenMap().put("index3", 1);
						GameData.getFastTenMap().
						put("m3", GameData.getFastTenMap().get("m3")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m3").toString())+1));
					}else{
						GameData.getFastTenMap().put("index3", 
								Integer.parseInt(GameData.getFastTenMap().get("index3").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index3", 1);
					list3=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index3").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list3;
			}else{
				list3=otherList(list3,mode);
				list=list3;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum3",str.toString());
			return map;
		}
	    public static Map<String, Object> mode4(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum4")==null){
				GameData.getFastTenMap().put("index4", 1);
				list4=ListValue();
			}else{
				if(!single_win("bettingNum4")){
					if(betting_index4==1){
						betting_index4=2;
					}else{
						betting_index4=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index4").toString())>=bet_max){
						list4=ListValue();
						GameData.getFastTenMap().put("index4", 1);
						GameData.getFastTenMap().
						put("m4", GameData.getFastTenMap().get("m4")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m4").toString())+1));
					}else{
						GameData.getFastTenMap().put("index4", 
								Integer.parseInt(GameData.getFastTenMap().get("index4").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index4", 1);
					list4=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index4").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list4;
			}else{
				list4=otherList(list4,mode);
				list=list4;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum4",str.toString());
			return map;
		}
	    public static Map<String, Object> mode5(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			if(GameData.getFastTenMap().get("bettingNum5")==null){
				GameData.getFastTenMap().put("index5", 1);
				list5=ListValue();
			}else{
				if(!single_win("bettingNum5")){
					if(betting_index5==1){
						betting_index5=2;
					}else{
						betting_index5=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index5").toString())>=bet_max){
						list5=ListValue();
						GameData.getFastTenMap().put("index5", 1);
						GameData.getFastTenMap().
						put("m5", GameData.getFastTenMap().get("m5")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m5").toString())+1));
					}else{
						GameData.getFastTenMap().put("index5", 
								Integer.parseInt(GameData.getFastTenMap().get("index5").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index5", 1);
					list5=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index5").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list5;
			}else{
				list5=otherList(list5,mode);
				list=list5;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum5",str.toString());
			return map;
		}
	    public static Map<String, Object> mode6(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			if(GameData.getFastTenMap().get("bettingNum6")==null){
				GameData.getFastTenMap().put("index6", 1);
				list6=ListValue();
			}else{
				if(!single_win("bettingNum6")){
					if(betting_index6==1){
						betting_index6=2;
					}else{
						betting_index6=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index6").toString())>=bet_max){
						list6=ListValue();
						GameData.getFastTenMap().put("index6", 1);
						GameData.getFastTenMap().
						put("m6", GameData.getFastTenMap().get("m6")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m6").toString())+1));
					}else{
						GameData.getFastTenMap().put("index6", 
								Integer.parseInt(GameData.getFastTenMap().get("index6").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index6", 1);
					list6=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index6").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list6;
			}else{
				list6=otherList(list6,mode);
				list=list6;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum6",str.toString());
			return map;
		}
	    public static Map<String, Object> mode7(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			if(GameData.getFastTenMap().get("bettingNum7")==null){
				GameData.getFastTenMap().put("index7", 1);
				list7=ListValue();
			}else{
				if(!single_win("bettingNum7")){
					if(betting_index7==1){
						betting_index7=2;
					}else{
						betting_index7=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index7").toString())>=bet_max){
						list7=ListValue();
						GameData.getFastTenMap().put("index7", 1);
						GameData.getFastTenMap().
						put("m7", GameData.getFastTenMap().get("m7")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m7").toString())+1));
					}else{
						GameData.getFastTenMap().put("index7", 
								Integer.parseInt(GameData.getFastTenMap().get("index7").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index7", 1);
					list7=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index7").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list7;
			}else{
				list7=otherList(list7,mode);
				list=list7;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum7",str.toString());
			return map;
		}
	    public static Map<String, Object> mode8(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
	
			if(GameData.getFastTenMap().get("bettingNum8")==null){
				GameData.getFastTenMap().put("index8", 1);
				list8=ListValue();
			}else{
				if(!single_win("bettingNum8")){
					if(betting_index8==1){
						betting_index8=2;
					}else{
						betting_index8=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index8").toString())>=bet_max){
						list8=ListValue();
						GameData.getFastTenMap().put("index8", 1);
						GameData.getFastTenMap().
						put("m8", GameData.getFastTenMap().get("m8")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m8").toString())+1));
					}else{
						GameData.getFastTenMap().put("index8", 
								Integer.parseInt(GameData.getFastTenMap().get("index8").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index8", 1);
					list8=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index8").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list8;
			}else{
				list8=otherList(list8,mode);
				list=list8;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum8",str.toString());
			return map;
		}
	    public static Map<String, Object> mode9(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum9")==null){
				GameData.getFastTenMap().put("index9", 1);
				list9=ListValue();
			}else{
				if(!single_win("bettingNum9")){
					if(betting_index9==1){
						betting_index9=2;
					}else{
						betting_index9=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index9").toString())>=bet_max){
						list9=ListValue();
						GameData.getFastTenMap().put("index9", 1);
						GameData.getFastTenMap().
						put("m9", GameData.getFastTenMap().get("m9")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m9").toString())+1));
					}else{
						GameData.getFastTenMap().put("index9", 
								Integer.parseInt(GameData.getFastTenMap().get("index9").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index9", 1);
					list9=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index9").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list9;
			}else{
				list9=otherList(list9,mode);
				list=list9;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum9",str.toString());
			return map;
		}
	    public static Map<String, Object> mode10(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum10")==null){
				GameData.getFastTenMap().put("index10", 1);
				list10=ListValue();
			}else{
				if(!single_win("bettingNum10")){
					if(betting_index10==1){
						betting_index10=2;
					}else{
						betting_index10=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index10").toString())>=bet_max){
						list10=ListValue();
						GameData.getFastTenMap().put("index10", 1);
						GameData.getFastTenMap().
						put("m10", GameData.getFastTenMap().get("m10")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m10").toString())+1));
					}else{
						GameData.getFastTenMap().put("index10", 
								Integer.parseInt(GameData.getFastTenMap().get("index10").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index10", 1);
					list10=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index10").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list10;
			}else{
				list10=otherList(list10,mode);
				list=list10;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum10",str.toString());
			return map;
		}
	    public static Map<String, Object> mode11(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum11")==null){
				GameData.getFastTenMap().put("index11", 1);
				list11=ListValue();
			}else{
				if(!single_win("bettingNum11")){
					if(betting_index11==1){
						betting_index11=2;
					}else{
						betting_index11=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index11").toString())>=bet_max){
						list11=ListValue();
						GameData.getFastTenMap().put("index11", 1);
						GameData.getFastTenMap().
						put("m11", GameData.getFastTenMap().get("m11")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m11").toString())+1));
					}else{
						GameData.getFastTenMap().put("index11", 
								Integer.parseInt(GameData.getFastTenMap().get("index11").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index11", 1);
					list11=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index11").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list11;
			}else{
				list11=otherList(list11,mode);
				list=list11;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum11",str.toString());
			return map;
		}
	    public static Map<String, Object> mode12(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum12")==null){
				GameData.getFastTenMap().put("index12", 1);
				list12=ListValue();
			}else{
				if(!single_win("bettingNum12")){
					if(betting_index12==1){
						betting_index12=2;
					}else{
						betting_index12=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index12").toString())>=bet_max){
						list12=ListValue();
						GameData.getFastTenMap().put("index12", 1);
						GameData.getFastTenMap().
						put("m12", GameData.getFastTenMap().get("m12")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m12").toString())+1));
					}else{
						GameData.getFastTenMap().put("index12", 
								Integer.parseInt(GameData.getFastTenMap().get("index12").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index12", 1);
					list12=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index12").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list12;
			}else{
				list12=otherList(list12,mode);
				list=list12;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum12",str.toString());
			return map;
		}
	    public static Map<String, Object> mode13(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum13")==null){
				GameData.getFastTenMap().put("index13", 1);
				list13=ListValue();
			}else{
				if(!single_win("bettingNum13")){
					if(betting_index13==1){
						betting_index13=2;
					}else{
						betting_index13=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index13").toString())>=bet_max){
						list13=ListValue();
						GameData.getFastTenMap().put("index13", 1);
						GameData.getFastTenMap().
						put("m13", GameData.getFastTenMap().get("m13")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m13").toString())+1));
					}else{
						GameData.getFastTenMap().put("index13", 
								Integer.parseInt(GameData.getFastTenMap().get("index13").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index13", 1);
					list13=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index13").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list13;
			}else{
				list13=otherList(list13,mode);
				list=list13;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum13",str.toString());
			return map;
		}
	    public static Map<String, Object> mode14(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum14")==null){
				GameData.getFastTenMap().put("index14", 1);
				list14=ListValue();
			}else{
				if(!single_win("bettingNum14")){
					if(betting_index14==1){
						betting_index14=2;
					}else{
						betting_index14=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index14").toString())>=bet_max){
						list14=ListValue();
						GameData.getFastTenMap().put("index14", 1);
						GameData.getFastTenMap().
						put("m14", GameData.getFastTenMap().get("m14")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m14").toString())+1));
					}else{
						GameData.getFastTenMap().put("index14", 
								Integer.parseInt(GameData.getFastTenMap().get("index14").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index14", 1);
					list14=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index14").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list14;
			}else{
				list14=otherList(list14,mode);
				list=list14;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum14",str.toString());
			return map;
		}
	    public static Map<String, Object> mode15(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum15")==null){
				GameData.getFastTenMap().put("index15", 1);
				list15=ListValue();
			}else{
				if(!single_win("bettingNum15")){
					if(betting_index15==1){
						betting_index15=2;
					}else{
						betting_index15=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index15").toString())>=bet_max){
						list15=ListValue();
						GameData.getFastTenMap().put("index15", 1);
						GameData.getFastTenMap().
						put("m15", GameData.getFastTenMap().get("m15")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m15").toString())+1));
					}else{
						GameData.getFastTenMap().put("index15", 
								Integer.parseInt(GameData.getFastTenMap().get("index15").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index15", 1);
					list15=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index15").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list15;
			}else{
				list15=otherList(list15,mode);
				list=list15;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum15",str.toString());
			return map;
		}
	    public static Map<String, Object> mode16(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum16")==null){
				GameData.getFastTenMap().put("index16", 1);
				list16=ListValue();
			}else{
				if(!single_win("bettingNum16")){
					if(betting_index16==1){
						betting_index16=2;
					}else{
						betting_index16=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index16").toString())>=bet_max){
						list16=ListValue();
						GameData.getFastTenMap().put("index16", 1);
						GameData.getFastTenMap().
						put("m16", GameData.getFastTenMap().get("m16")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m16").toString())+1));
					}else{
						GameData.getFastTenMap().put("index16", 
								Integer.parseInt(GameData.getFastTenMap().get("index16").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index16", 1);
					list16=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index16").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list16;
			}else{
				list16=otherList(list16,mode);
				list=list16;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum16",str.toString());
			return map;
		}
	    public static Map<String, Object> mode17(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum17")==null){
				GameData.getFastTenMap().put("index17", 1);
				list17=ListValue();
			}else{
				if(!single_win("bettingNum17")){
					if(betting_index17==1){
						betting_index17=2;
					}else{
						betting_index17=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index17").toString())>=bet_max){
						list17=ListValue();
						GameData.getFastTenMap().put("index17", 1);
						GameData.getFastTenMap().
						put("m17", GameData.getFastTenMap().get("m17")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m17").toString())+1));
					}else{
						GameData.getFastTenMap().put("index17", 
								Integer.parseInt(GameData.getFastTenMap().get("index17").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index17", 1);
					list17=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index17").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list17;
			}else{
				list17=otherList(list17,mode);
				list=list17;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum17",str.toString());
			return map;
		}
	    public static Map<String, Object> mode18(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum18")==null){
				GameData.getFastTenMap().put("index18", 1);
				list18=ListValue();
			}else{
				if(!single_win("bettingNum18")){
					if(betting_index18==1){
						betting_index18=2;
					}else{
						betting_index18=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index18").toString())>=bet_max){
						list18=ListValue();
						GameData.getFastTenMap().put("index18", 1);
						GameData.getFastTenMap().
						put("m18", GameData.getFastTenMap().get("m18")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m18").toString())+1));
					}else{
						GameData.getFastTenMap().put("index18", 
								Integer.parseInt(GameData.getFastTenMap().get("index18").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index18", 1);
					list18=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index18").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list18;
			}else{
				list18=otherList(list18,mode);
				list=list18;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum18",str.toString());
			return map;
		}
	    public static Map<String, Object> mode19(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum19")==null){
				GameData.getFastTenMap().put("index19", 1);
				list19=ListValue();
			}else{
				if(!single_win("bettingNum19")){
					if(betting_index19==1){
						betting_index19=2;
					}else{
						betting_index19=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index19").toString())>=bet_max){
						list19=ListValue();
						GameData.getFastTenMap().put("index19", 1);
						GameData.getFastTenMap().
						put("m19", GameData.getFastTenMap().get("m19")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m19").toString())+1));
					}else{
						GameData.getFastTenMap().put("index19", 
								Integer.parseInt(GameData.getFastTenMap().get("index19").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index19", 1);
					list19=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index19").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list19;
			}else{
				list19=otherList(list19,mode);
				list=list19;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum19",str.toString());
			return map;
		}
	    public static Map<String, Object> mode20(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum20")==null){
				GameData.getFastTenMap().put("index20", 1);
				list20=ListValue();
			}else{
				if(!single_win("bettingNum20")){
					if(betting_index20==1){
						betting_index20=2;
					}else{
						betting_index20=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index20").toString())>=bet_max){
						list20=ListValue();
						GameData.getFastTenMap().put("index20", 1);
						GameData.getFastTenMap().
						put("m20", GameData.getFastTenMap().get("m20")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m20").toString())+1));
					}else{
						GameData.getFastTenMap().put("index20", 
								Integer.parseInt(GameData.getFastTenMap().get("index20").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index20", 1);
					list20=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index20").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list20;
			}else{
				list20=otherList(list20,mode);
				list=list20;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum20",str.toString());
			return map;
		}
	    public static Map<String, Object> mode21(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum21")==null){
				GameData.getFastTenMap().put("index21", 1);
				list21=ListValue();
			}else{
				if(!single_win("bettingNum21")){
					if(betting_index21==1){
						betting_index21=2;
					}else{
						betting_index21=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index21").toString())>=bet_max){
						list21=ListValue();
						GameData.getFastTenMap().put("index21", 1);
						GameData.getFastTenMap().
						put("m21", GameData.getFastTenMap().get("m21")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m21").toString())+1));
					}else{
						GameData.getFastTenMap().put("index21", 
								Integer.parseInt(GameData.getFastTenMap().get("index21").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index21", 1);
					list21=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index21").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list21;
			}else{
				list21=otherList(list21,mode);
				list=list21;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum21",str.toString());
			return map;
		}
	    public static Map<String, Object> mode22(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum22")==null){
				GameData.getFastTenMap().put("index22", 1);
				list22=ListValue();
			}else{
				if(!single_win("bettingNum22")){
					if(betting_index22==1){
						betting_index22=2;
					}else{
						betting_index22=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index22").toString())>=bet_max){
						list22=ListValue();
						GameData.getFastTenMap().put("index22", 1);
						GameData.getFastTenMap().
						put("m22", GameData.getFastTenMap().get("m22")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m22").toString())+1));
					}else{
						GameData.getFastTenMap().put("index22", 
								Integer.parseInt(GameData.getFastTenMap().get("index22").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index22", 1);
					list22=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index22").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list22;
			}else{
				list22=otherList(list22,mode);
				list=list22;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum22",str.toString());
			return map;
		}
	    public static Map<String, Object> mode23(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum23")==null){
				GameData.getFastTenMap().put("index23", 1);
				list23=ListValue();
			}else{
				if(!single_win("bettingNum23")){
					if(betting_index23==1){
						betting_index23=2;
					}else{
						betting_index23=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index23").toString())>=bet_max){
						list23=ListValue();
						GameData.getFastTenMap().put("index23", 1);
						GameData.getFastTenMap().
						put("m23", GameData.getFastTenMap().get("m23")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m23").toString())+1));
					}else{
						GameData.getFastTenMap().put("index23", 
								Integer.parseInt(GameData.getFastTenMap().get("index23").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index23", 1);
					list23=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index23").toString());
			int mode=getMode(index);	
			if(mode==0){
				list=list23;
			}else{
				list23=otherList(list23,mode);
				list=list23;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum23",str.toString());
			return map;
		}
	    public static Map<String, Object> mode24(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum24")==null){
				GameData.getFastTenMap().put("index24", 1);
				list24=ListValue();
			}else{
				if(!single_win("bettingNum24")){
					if(betting_index24==1){
						betting_index24=2;
					}else{
						betting_index24=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index24").toString())>=bet_max){
						list24=ListValue();
						GameData.getFastTenMap().put("index24", 1);
						GameData.getFastTenMap().
						put("m24", GameData.getFastTenMap().get("m24")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m24").toString())+1));
					}else{
						GameData.getFastTenMap().put("index24", 
								Integer.parseInt(GameData.getFastTenMap().get("index24").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index24", 1);
					list24=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index24").toString());
			int mode=getMode(index);	
			if(mode==0){
				list=list24;
			}else{
				list24=otherList(list24,mode);
				list=list24;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum24",str.toString());
			return map;
		}
	    public static Map<String, Object> mode25(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum25")==null){
				GameData.getFastTenMap().put("index25", 1);
				list25=ListValue();
			}else{
				if(!single_win("bettingNum25")){
					if(betting_index25==1){
						betting_index25=2;
					}else{
						betting_index25=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index25").toString())>=bet_max){
						list25=ListValue();
						GameData.getFastTenMap().put("index25", 1);
						GameData.getFastTenMap().
						put("m25", GameData.getFastTenMap().get("m25")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m25").toString())+1));
					}else{
						GameData.getFastTenMap().put("index25", 
								Integer.parseInt(GameData.getFastTenMap().get("index25").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index25", 1);
					list25=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index25").toString());
			int mode=getMode(index);	
			if(mode==0){
				list=list25;
			}else{
				list25=otherList(list25,mode);
				list=list25;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum25",str.toString());
			return map;
		}
	    public static Map<String, Object> mode26(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum26")==null){
				GameData.getFastTenMap().put("index26", 1);
				list26=ListValue();
			}else{
				if(!single_win("bettingNum26")){
					if(betting_index26==1){
						betting_index26=2;
					}else{
						betting_index26=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index26").toString())>=bet_max){
						list26=ListValue();
						GameData.getFastTenMap().put("index26", 1);
						GameData.getFastTenMap().
						put("m26", GameData.getFastTenMap().get("m26")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m26").toString())+1));
					}else{
						GameData.getFastTenMap().put("index26", 
								Integer.parseInt(GameData.getFastTenMap().get("index26").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index26", 1);
					list26=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index26").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list26;
			}else{
				list26=otherList(list26,mode);
				list=list26;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum26",str.toString());
			return map;
		}
	    public static Map<String, Object> mode27(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum27")==null){
				GameData.getFastTenMap().put("index27", 1);
				list27=ListValue();
			}else{
				if(!single_win("bettingNum27")){
					if(betting_index27==1){
						betting_index27=2;
					}else{
						betting_index27=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index27").toString())>=bet_max){
						list27=ListValue();
						GameData.getFastTenMap().put("index27", 1);
						GameData.getFastTenMap().
						put("m27", GameData.getFastTenMap().get("m27")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m27").toString())+1));
					}else{
						GameData.getFastTenMap().put("index27", 
								Integer.parseInt(GameData.getFastTenMap().get("index27").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index27", 1);
					list27=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index27").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list27;
			}else{
				list27=otherList(list27,mode);
				list=list27;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum27",str.toString());
			return map;
		}
	    public static Map<String, Object> mode28(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum28")==null){
				GameData.getFastTenMap().put("index28", 1);
				list28=ListValue();
			}else{
				if(!single_win("bettingNum28")){
					if(betting_index28==1){
						betting_index28=2;
					}else{
						betting_index28=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index28").toString())>=bet_max){
						list28=ListValue();
						GameData.getFastTenMap().put("index28", 1);
						GameData.getFastTenMap().
						put("m28", GameData.getFastTenMap().get("m28")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m28").toString())+1));
					}else{
						GameData.getFastTenMap().put("index28", 
								Integer.parseInt(GameData.getFastTenMap().get("index28").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index28", 1);
					list28=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index28").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list28;
			}else{
				list28=otherList(list28,mode);
				list=list28;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum28",str.toString());
			return map;
		}
	    public static Map<String, Object> mode29(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			if(GameData.getFastTenMap().get("bettingNum29")==null){
				GameData.getFastTenMap().put("index29", 1);
				list29=ListValue();
			}else{
				if(!single_win("bettingNum29")){
					if(betting_index29==1){
						betting_index29=2;
					}else{
						betting_index29=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index29").toString())>=bet_max){
						list29=ListValue();
						GameData.getFastTenMap().put("index29", 1);
						GameData.getFastTenMap().
						put("m29", GameData.getFastTenMap().get("m29")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m29").toString())+1));
					}else{
						GameData.getFastTenMap().put("index29", 
								Integer.parseInt(GameData.getFastTenMap().get("index29").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index29", 1);
					list29=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index29").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list29;
			}else{
				list29=otherList(list29,mode);
				list=list29;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum29",str.toString());
			return map;
		}
	    public static Map<String, Object> mode30(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			if(GameData.getFastTenMap().get("bettingNum30")==null){
				GameData.getFastTenMap().put("index30", 1);
				list30=ListValue();
			}else{
				if(!single_win("bettingNum30")){
					if(betting_index30==1){
						betting_index30=2;
					}else{
						betting_index30=1;
					}
					if(Integer.parseInt(GameData.getFastTenMap().get("index30").toString())>=bet_max){
						list30=ListValue();
						GameData.getFastTenMap().put("index30", 1);
						GameData.getFastTenMap().
						put("m30", GameData.getFastTenMap().get("m30")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m30").toString())+1));
					}else{
						GameData.getFastTenMap().put("index30", 
								Integer.parseInt(GameData.getFastTenMap().get("index30").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index30", 1);
					list30=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index30").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list30;
			}else{
				list30=otherList(list30,mode);
				list=list30;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum30",str.toString());
			return map;
		}
	    public static Map<String, Object> mode31(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			betting_index31++;
			if(GameData.getFastTenMap().get("bettingNum31")==null){
				GameData.getFastTenMap().put("index31", 1);
				list31=ListValue();
			}else{
				if(!single_win("bettingNum31")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index31").toString())>=bet_max){
						list31=ListValue();
						GameData.getFastTenMap().put("index31", 1);
						GameData.getFastTenMap().
						put("m31", GameData.getFastTenMap().get("m31")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m31").toString())+1));
					}else{
						GameData.getFastTenMap().put("index31", 
								Integer.parseInt(GameData.getFastTenMap().get("index31").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index31", 1);
					list31=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index31").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list31;
			}else{
				list31=otherList(list31,mode);
				list=list31;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			
			GameData.getFastTenMap().put("bettingNum31",str.toString());
			return map;
		}
	    public static Map<String, Object> mode32(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index32++;
			if(GameData.getFastTenMap().get("bettingNum32")==null){
				GameData.getFastTenMap().put("index32", 1);
				list32=ListValue();
			}else{
				if(!single_win("bettingNum32")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index32").toString())>=bet_max){
						list32=ListValue();
						GameData.getFastTenMap().put("index32", 1);
						GameData.getFastTenMap().
						put("m32", GameData.getFastTenMap().get("m32")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m32").toString())+1));
					}else{
						GameData.getFastTenMap().put("index32", 
								Integer.parseInt(GameData.getFastTenMap().get("index32").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index32", 1);
					list32=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index32").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list32;
			}else{
				list32=otherList(list32,mode);
				list=list32;
			}
		
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum32",str.toString());
			return map;
		}
	    public static Map<String, Object> mode33(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			betting_index33++;
			if(GameData.getFastTenMap().get("bettingNum33")==null){
				GameData.getFastTenMap().put("index33", 1);
				list33=ListValue();
			}else{
				if(!single_win("bettingNum33")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index33").toString())>=bet_max){
						list33=ListValue();
						GameData.getFastTenMap().put("index33", 1);
						GameData.getFastTenMap().
						put("m33", GameData.getFastTenMap().get("m33")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m33").toString())+1));
					}else{
						GameData.getFastTenMap().put("index33", 
								Integer.parseInt(GameData.getFastTenMap().get("index33").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index33", 1);
					list33=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index33").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list33;
			}else{
				list33=otherList(list33,mode);
				list=list33;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum33",str.toString());
			return map;
		}
	    public static Map<String, Object> mode34(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			betting_index34++;
			if(GameData.getFastTenMap().get("bettingNum34")==null){
				GameData.getFastTenMap().put("index34", 1);
				list34=ListValue();
			}else{
				if(!single_win("bettingNum34")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index34").toString())>=bet_max){
						list34=ListValue();
						GameData.getFastTenMap().put("index34", 1);
						GameData.getFastTenMap().
						put("m34", GameData.getFastTenMap().get("m34")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m34").toString())+1));
					}else{
						GameData.getFastTenMap().put("index34", 
								Integer.parseInt(GameData.getFastTenMap().get("index34").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index34", 1);
					list34=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index34").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list34;
			}else{
				list34=otherList(list34,mode);
				list=list34;
			}
		
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum34",str.toString());
			return map;
		}
	    public static Map<String, Object> mode35(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index35++;
			if(GameData.getFastTenMap().get("bettingNum35")==null){
				GameData.getFastTenMap().put("index35", 1);
				list35=ListValue();
			}else{
				if(!single_win("bettingNum35")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index35").toString())>=bet_max){
						list35=ListValue();
						GameData.getFastTenMap().put("index35", 1);
						GameData.getFastTenMap().
						put("m35", GameData.getFastTenMap().get("m35")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m35").toString())+1));
					}else{
						GameData.getFastTenMap().put("index35", 
								Integer.parseInt(GameData.getFastTenMap().get("index35").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index35", 1);
					list35=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index35").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list35;
			}else{
				list35=otherList(list35,mode);
				list=list35;
			}
		
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum35",str.toString());
			return map;
		}
	    public static Map<String, Object> mode36(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index36++;
			if(GameData.getFastTenMap().get("bettingNum36")==null){
				GameData.getFastTenMap().put("index36", 1);
				list36=ListValue();
			}else{
				if(!single_win("bettingNum36")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index36").toString())>=bet_max){
						list36=ListValue();
						GameData.getFastTenMap().put("index36", 1);
						GameData.getFastTenMap().
						put("m36", GameData.getFastTenMap().get("m36")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m36").toString())+1));
					}else{
						GameData.getFastTenMap().put("index36", 
								Integer.parseInt(GameData.getFastTenMap().get("index36").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index36", 1);
					list36=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index36").toString());
	
			int mode=getMode(index);
			if(mode==0){
				list=list36;
			}else{
				list36=otherList(list36,mode);
				list=list36;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum36",str.toString());
			return map;
		}
	    public static Map<String, Object> mode37(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index37++;
			if(GameData.getFastTenMap().get("bettingNum37")==null){
				GameData.getFastTenMap().put("index37", 1);
				list37=ListValue();
			}else{
				if(!single_win("bettingNum37")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index37").toString())>=bet_max){
						list37=ListValue();
						GameData.getFastTenMap().put("index37", 1);
						GameData.getFastTenMap().
						put("m37", GameData.getFastTenMap().get("m37")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m37").toString())+1));
					}else{
						GameData.getFastTenMap().put("index37", 
								Integer.parseInt(GameData.getFastTenMap().get("index37").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index37", 1);
					list37=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index37").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list37;
			}else{
				list37=otherList(list37,mode);
				list=list37;
			}
		
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum37",str.toString());
			return map;
		}
	    public static Map<String, Object> mode38(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
			
			betting_index38++;
			if(GameData.getFastTenMap().get("bettingNum38")==null){
				GameData.getFastTenMap().put("index38", 1);
				list38=ListValue();
			}else{
				if(!single_win("bettingNum38")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index38").toString())>=bet_max){
						list38=ListValue();
						GameData.getFastTenMap().put("index38", 1);
						GameData.getFastTenMap().
						put("m38", GameData.getFastTenMap().get("m38")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m38").toString())+1));
					}else{
						GameData.getFastTenMap().put("index38", 
								Integer.parseInt(GameData.getFastTenMap().get("index38").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index38", 1);
					list38=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index38").toString());
			
			int mode=getMode(index);
			if(mode==0){
				list=list38;
			}else{
				list38=otherList(list38,mode);
				list=list38;
			}
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum38",str.toString());
			return map;
		}
	    public static Map<String, Object> mode39(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index39++;
			if(GameData.getFastTenMap().get("bettingNum39")==null){
				GameData.getFastTenMap().put("index39", 1);
				list39=ListValue();
			}else{
				if(!single_win("bettingNum39")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index39").toString())>=bet_max){
						list39=ListValue();
						GameData.getFastTenMap().put("index39", 1);
						GameData.getFastTenMap().
						put("m39", GameData.getFastTenMap().get("m39")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m39").toString())+1));
					}else{
						GameData.getFastTenMap().put("index39", 
								Integer.parseInt(GameData.getFastTenMap().get("index39").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index39", 1);
					list39=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index39").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list39;
			}else{
				list39=otherList(list39,mode);
				list=list39;
			}
		
			for(int j=0;j<list.size();j++){
					map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
					str.append(list.get(j));
					str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum39",str.toString());
			return map;
		}
	    public static Map<String, Object> mode40(){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mapid", 36);
			map.put("orderid", GameData.getFastTenMap().get("now_num"));
			StringBuilder str=new StringBuilder();
			List<Integer> list=ListValue();
			int ss=Integer.parseInt(ConfUtil.ReadConfig("hg10_mode_one_value"));
			int bet_max=Integer.parseInt(ConfUtil.ReadConfig("hg10_bet_one_max"));
		
			betting_index40++;
			if(GameData.getFastTenMap().get("bettingNum40")==null){
				GameData.getFastTenMap().put("index40", 1);
				list40=ListValue();
			}else{
				if(!single_win("bettingNum40")){
					if(Integer.parseInt(GameData.getFastTenMap().get("index40").toString())>=bet_max){
						list40=ListValue();
						GameData.getFastTenMap().put("index40", 1);
						GameData.getFastTenMap().
						put("m40", GameData.getFastTenMap().get("m40")==null?1:
							(Integer.parseInt(GameData.getFastTenMap().get("m40").toString())+1));
					}else{
						GameData.getFastTenMap().put("index40", 
								Integer.parseInt(GameData.getFastTenMap().get("index40").toString())+1);
					}
							
				}else{
					GameData.getFastTenMap().put("index40", 1);
					list40=ListValue();
				
				}
			}
			int index=Integer.parseInt(GameData.getFastTenMap().get("index40").toString());
			int mode=getMode(index);
			if(mode==0){
				list=list40;
			}else{
				list40=otherList(list40,mode);
				list=list40;
			}
		
			for(int j=0;j<list.size();j++){
				map.put("betting[f"+list.get(j)+"]", ss*BettingOneValue(index));
				str.append(list.get(j));
				str.append(",");
				
			}
			GameData.getFastTenMap().put("bettingNum40",str.toString());
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
	    	List<Integer> list3=new ArrayList<Integer>();
	    	List<Integer> list4=new ArrayList<Integer>();
	    	List<Integer> list5=new ArrayList<Integer>();
	    	for(int i=1;i<=5;i++){
				list1.add(i);
			}
	    	Collections.shuffle(list1);
			Collections.shuffle(list1);
	    	for(int i=6;i<=10;i++){
				list2.add(i);
			}
	    	Collections.shuffle(list2);
			Collections.shuffle(list2);
	    	for(int i=1;i<=9;i+=2){
				list3.add(i);
			}
	    	Collections.shuffle(list3);
			Collections.shuffle(list3);
	    	for(int i=2;i<=10;i+=2){
				list4.add(i);
			}
	    	Collections.shuffle(list4);
			Collections.shuffle(list4);   	
	    	for(int i=3;i<=7;i++){
				list5.add(i);
			}
	    	Collections.shuffle(list5);
			Collections.shuffle(list5);
			List<Integer> rs=new ArrayList<Integer>();
			for(int i=0;i<5;i++){
				if(!ishas(list1.get(i),rs)){
					rs.add(list1.get(i));
					break;
				}else{
					
				}		
			}
			for(int i=0;i<5;i++){
				if(!ishas(list2.get(i),rs)){
					rs.add(list2.get(i));
					break;
				}else{
					
				}		
			}
			for(int i=0;i<5;i++){
				if(!ishas(list3.get(i),rs)){
					rs.add(list3.get(i));
					break;
				}else{
					
				}		
			}
			for(int i=0;i<5;i++){
				if(!ishas(list4.get(i),rs)){
					rs.add(list4.get(i));
					break;
				}else{
					
				}		
			}
			for(int i=0;i<5;i++){
				if(!ishas(list5.get(i),rs)){
					rs.add(list5.get(i));
					break;
				}else{
					
				}		
			}
			
			return rs;
	    }
	    public static boolean ishas(int s,List<Integer> r){
	    	
	    	if(r.size()==0){
	    		return false;
	    	}
	    	for(int a:r){
	    		if(s==a){
	    			return true;
	    		}
	    	}
	    	return false;
	    	
	    }
	    public static List<Integer> otherList(List<Integer> paramList,int mode){
	    	List<Integer> list1=new ArrayList<Integer>();
	    	for(int i=1;i<=10;i++){
				list1.add(i);
			}   	    	
			List<Integer> rs=new ArrayList<Integer>();
			if(mode==1){
				rs=ListValue();
			}else if(mode==2){
				list1.removeAll(paramList);
				rs=list1;
				
			}else if(mode==3){
				if(GameData.getFastTenMap().get("touMax")!=null){
					rs=(List<Integer>) GameData.getFastTenMap().get("touMax");
					
				}else{
					for(int i=1;i<=8;i++){
						rs.add(i);
					} 
				}
				
			}
			else if(mode==4){
				for(int i=1;i<=8;i++){
					rs.add(i);
				} 
				
			}
			else if(mode==5){
				rs=valuexx();
				
			}else if(mode==6){
				List<Integer> x=new ArrayList<Integer>();
				for(int i=1;i<=3;i++){
					x.add(i);
				}
				Collections.shuffle(x);
				int a=x.get(0);
				switch (a) {
				case 1:
					rs=(List<Integer>) GameData.getFastTenMap().get("touMax");
					break;
				case 2:
					for(int i=1;i<=8;i++){
						rs.add(i);
					} 
					break;
				case 3:
					rs=valuexx();
				default:
					break;
				}
				rs=valuexx();
				
				
			}
			return rs;
	    }
	    public static List<Integer> valuexx(){
	    	List<Integer> list1=new ArrayList<Integer>();
	    	List<Integer> rs=new ArrayList<Integer>();
	    	for(int i=1;i<=10;i++){
				list1.add(i);
			}
	    	Collections.shuffle(list1);
			Collections.shuffle(list1);
			for(int i=2;i<10;i++){
				rs.add(list1.get(i));	
			}
			return rs;
	    }
 	public static Map<String, Object> BigMode(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", GameData.getFastTenMap().get("now_num"));
		Map<String, Object> map1=mode1();
		Map<String, Object> map2=mode2();
		Map<String, Object> map3=mode3();
		Map<String, Object> map4=mode4();
		Map<String, Object> map5=mode5();
		Map<String, Object> map6=mode6();
		Map<String, Object> map7=mode7();
		Map<String, Object> map8=mode8();
		Map<String, Object> map9=mode9();
		Map<String, Object> map10=mode10();
		
		Map<String, Object> map11=mode11();
		Map<String, Object> map12=mode12();
		Map<String, Object> map13=mode13();
		Map<String, Object> map14=mode14();
		Map<String, Object> map15=mode15();
		Map<String, Object> map16=mode16();
		Map<String, Object> map17=mode17();
		Map<String, Object> map18=mode18();
		Map<String, Object> map19=mode19();
		Map<String, Object> map20=mode20();
		
		Map<String, Object> map21=mode21();
		Map<String, Object> map22=mode22();
		Map<String, Object> map23=mode23();
		Map<String, Object> map24=mode24();
		Map<String, Object> map25=mode25();
		Map<String, Object> map26=mode26();
		Map<String, Object> map27=mode27();
		Map<String, Object> map28=mode28();
		Map<String, Object> map29=mode29();
		Map<String, Object> map30=mode30();
		
		Map<String, Object> map31=mode31();
		Map<String, Object> map32=mode32();
		Map<String, Object> map33=mode33();
		Map<String, Object> map34=mode34();
		Map<String, Object> map35=mode35();
		Map<String, Object> map36=mode36();
		Map<String, Object> map37=mode37();
		Map<String, Object> map38=mode38();
		Map<String, Object> map39=mode39();
		Map<String, Object> map40=mode40();
		int all=0;
		
		/*for(int i=1;i<=10;i++){	
			int a=0;
		    a+=Integer.parseInt(map1.get("tb"+i)==null?"0":map1.get("tb"+i).toString());
		    a+=Integer.parseInt(map2.get("tb"+i)==null?"0":map2.get("tb"+i).toString());
		    a+=Integer.parseInt(map3.get("tb"+i)==null?"0":map3.get("tb"+i).toString());
		    a+=Integer.parseInt(map4.get("tb"+i)==null?"0":map4.get("tb"+i).toString());
		    a+=Integer.parseInt(map5.get("tb"+i)==null?"0":map5.get("tb"+i).toString());
			map.put("tb"+i, a);	
			all+=a;
			
		}*/
		StringBuilder tz=new StringBuilder();
		for(int i=1;i<=10;i++){	
			int a=0;
			a+=Integer.parseInt(map1.get("betting[f"+i+"]")==null?"0":map1.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map2.get("betting[f"+i+"]")==null?"0":map2.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map3.get("betting[f"+i+"]")==null?"0":map3.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map4.get("betting[f"+i+"]")==null?"0":map4.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map5.get("betting[f"+i+"]")==null?"0":map5.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map6.get("betting[f"+i+"]")==null?"0":map6.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map7.get("betting[f"+i+"]")==null?"0":map7.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map8.get("betting[f"+i+"]")==null?"0":map8.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map9.get("betting[f"+i+"]")==null?"0":map9.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map10.get("betting[f"+i+"]")==null?"0":map10.get("betting[f"+i+"]").toString());
			
			a+=Integer.parseInt(map11.get("betting[f"+i+"]")==null?"0":map11.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map12.get("betting[f"+i+"]")==null?"0":map12.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map13.get("betting[f"+i+"]")==null?"0":map13.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map14.get("betting[f"+i+"]")==null?"0":map14.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map15.get("betting[f"+i+"]")==null?"0":map15.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map16.get("betting[f"+i+"]")==null?"0":map16.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map17.get("betting[f"+i+"]")==null?"0":map17.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map18.get("betting[f"+i+"]")==null?"0":map18.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map19.get("betting[f"+i+"]")==null?"0":map19.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map20.get("betting[f"+i+"]")==null?"0":map20.get("betting[f"+i+"]").toString());
	
			a+=Integer.parseInt(map21.get("betting[f"+i+"]")==null?"0":map21.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map22.get("betting[f"+i+"]")==null?"0":map22.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map23.get("betting[f"+i+"]")==null?"0":map23.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map24.get("betting[f"+i+"]")==null?"0":map24.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map25.get("betting[f"+i+"]")==null?"0":map25.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map26.get("betting[f"+i+"]")==null?"0":map26.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map27.get("betting[f"+i+"]")==null?"0":map27.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map28.get("betting[f"+i+"]")==null?"0":map28.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map29.get("betting[f"+i+"]")==null?"0":map29.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map30.get("betting[f"+i+"]")==null?"0":map30.get("betting[f"+i+"]").toString());
	
			
				a+=Integer.parseInt(map31.get("betting[f"+i+"]")==null?"0":map31.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map32.get("betting[f"+i+"]")==null?"0":map32.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map33.get("betting[f"+i+"]")==null?"0":map33.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map34.get("betting[f"+i+"]")==null?"0":map34.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map35.get("betting[f"+i+"]")==null?"0":map35.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map36.get("betting[f"+i+"]")==null?"0":map36.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map37.get("betting[f"+i+"]")==null?"0":map37.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map38.get("betting[f"+i+"]")==null?"0":map38.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map39.get("betting[f"+i+"]")==null?"0":map39.get("betting[f"+i+"]").toString());
				a+=Integer.parseInt(map40.get("betting[f"+i+"]")==null?"0":map40.get("betting[f"+i+"]").toString());
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
		log.info("本期投注3->"+GameData.getFastTenMap().get("bettingNum3")+";index10->"+GameData.getFastTenMap().get("index3")+";m->"+(GameData.getFastTenMap().get("m3")==null?0:GameData.getFastTenMap().get("m3")));
		log.info("本期投注4->"+GameData.getFastTenMap().get("bettingNum4")+";index10->"+GameData.getFastTenMap().get("index4")+";m->"+(GameData.getFastTenMap().get("m4")==null?0:GameData.getFastTenMap().get("m4")));		
		log.info("本期投注5->"+GameData.getFastTenMap().get("bettingNum5")+";index10->"+GameData.getFastTenMap().get("index5")+";m->"+(GameData.getFastTenMap().get("m5")==null?0:GameData.getFastTenMap().get("m5")));
		log.info("本期投注6->"+GameData.getFastTenMap().get("bettingNum6")+";index10->"+GameData.getFastTenMap().get("index6")+";m->"+(GameData.getFastTenMap().get("m6")==null?0:GameData.getFastTenMap().get("m6")));
		log.info("本期投注7->"+GameData.getFastTenMap().get("bettingNum7")+";index10->"+GameData.getFastTenMap().get("index7")+";m->"+(GameData.getFastTenMap().get("m7")==null?0:GameData.getFastTenMap().get("m7")));
		log.info("本期投注8->"+GameData.getFastTenMap().get("bettingNum8")+";index10->"+GameData.getFastTenMap().get("index8")+";m->"+(GameData.getFastTenMap().get("m8")==null?0:GameData.getFastTenMap().get("m8")));
		log.info("本期投注9->"+GameData.getFastTenMap().get("bettingNum9")+";index10->"+GameData.getFastTenMap().get("index9")+";m->"+(GameData.getFastTenMap().get("m9")==null?0:GameData.getFastTenMap().get("m9")));
		log.info("本期投注10->"+GameData.getFastTenMap().get("bettingNum10")+";index10->"+GameData.getFastTenMap().get("index10")+";m->"+(GameData.getFastTenMap().get("m10")==null?0:GameData.getFastTenMap().get("m10")));
		log.info("==========================================================================");
		log.info("本期投注11->"+GameData.getFastTenMap().get("bettingNum11")+";index10->"+GameData.getFastTenMap().get("index11")+";m->"+(GameData.getFastTenMap().get("m11")==null?0:GameData.getFastTenMap().get("m11")));
		log.info("本期投注12->"+GameData.getFastTenMap().get("bettingNum12")+";index10->"+GameData.getFastTenMap().get("index12")+";m->"+(GameData.getFastTenMap().get("m12")==null?0:GameData.getFastTenMap().get("m12")));
		log.info("本期投注13->"+GameData.getFastTenMap().get("bettingNum13")+";index10->"+GameData.getFastTenMap().get("index13")+";m->"+(GameData.getFastTenMap().get("m13")==null?0:GameData.getFastTenMap().get("m13")));
		log.info("本期投注14->"+GameData.getFastTenMap().get("bettingNum14")+";index10->"+GameData.getFastTenMap().get("index14")+";m->"+(GameData.getFastTenMap().get("m14")==null?0:GameData.getFastTenMap().get("m14")));
		log.info("本期投注15->"+GameData.getFastTenMap().get("bettingNum15")+";index10->"+GameData.getFastTenMap().get("index15")+";m->"+(GameData.getFastTenMap().get("m15")==null?0:GameData.getFastTenMap().get("m15")));
		log.info("本期投注16->"+GameData.getFastTenMap().get("bettingNum16")+";index10->"+GameData.getFastTenMap().get("index16")+";m->"+(GameData.getFastTenMap().get("m16")==null?0:GameData.getFastTenMap().get("m16")));
		log.info("本期投注17->"+GameData.getFastTenMap().get("bettingNum17")+";index10->"+GameData.getFastTenMap().get("index17")+";m->"+(GameData.getFastTenMap().get("m17")==null?0:GameData.getFastTenMap().get("m17")));
		log.info("本期投注18->"+GameData.getFastTenMap().get("bettingNum18")+";index10->"+GameData.getFastTenMap().get("index18")+";m->"+(GameData.getFastTenMap().get("m18")==null?0:GameData.getFastTenMap().get("m18")));
		log.info("本期投注19->"+GameData.getFastTenMap().get("bettingNum19")+";index10->"+GameData.getFastTenMap().get("index19")+";m->"+(GameData.getFastTenMap().get("m19")==null?0:GameData.getFastTenMap().get("m19")));
		log.info("本期投注20->"+GameData.getFastTenMap().get("bettingNum20")+";index10->"+GameData.getFastTenMap().get("index20")+";m->"+(GameData.getFastTenMap().get("m20")==null?0:GameData.getFastTenMap().get("m20")));
		log.info("==========================================================================");
		log.info("本期投注21->"+GameData.getFastTenMap().get("bettingNum21")+";index10->"+GameData.getFastTenMap().get("index21")+";m->"+(GameData.getFastTenMap().get("m21")==null?0:GameData.getFastTenMap().get("m21")));
		log.info("本期投注22->"+GameData.getFastTenMap().get("bettingNum22")+";index10->"+GameData.getFastTenMap().get("index22")+";m->"+(GameData.getFastTenMap().get("m22")==null?0:GameData.getFastTenMap().get("m22")));
		log.info("本期投注23->"+GameData.getFastTenMap().get("bettingNum23")+";index10->"+GameData.getFastTenMap().get("index23")+";m->"+(GameData.getFastTenMap().get("m23")==null?0:GameData.getFastTenMap().get("m23")));
		log.info("本期投注24->"+GameData.getFastTenMap().get("bettingNum24")+";index10->"+GameData.getFastTenMap().get("index24")+";m->"+(GameData.getFastTenMap().get("m24")==null?0:GameData.getFastTenMap().get("m24")));
		log.info("本期投注25->"+GameData.getFastTenMap().get("bettingNum25")+";index10->"+GameData.getFastTenMap().get("index25")+";m->"+(GameData.getFastTenMap().get("m25")==null?0:GameData.getFastTenMap().get("m25")));
		log.info("本期投注26->"+GameData.getFastTenMap().get("bettingNum26")+";index10->"+GameData.getFastTenMap().get("index26")+";m->"+(GameData.getFastTenMap().get("m26")==null?0:GameData.getFastTenMap().get("m26")));
		log.info("本期投注27->"+GameData.getFastTenMap().get("bettingNum27")+";index10->"+GameData.getFastTenMap().get("index27")+";m->"+(GameData.getFastTenMap().get("m27")==null?0:GameData.getFastTenMap().get("m27")));
		log.info("本期投注28->"+GameData.getFastTenMap().get("bettingNum28")+";index10->"+GameData.getFastTenMap().get("index28")+";m->"+(GameData.getFastTenMap().get("m28")==null?0:GameData.getFastTenMap().get("m28")));
		log.info("本期投注29->"+GameData.getFastTenMap().get("bettingNum29")+";index10->"+GameData.getFastTenMap().get("index29")+";m->"+(GameData.getFastTenMap().get("m29")==null?0:GameData.getFastTenMap().get("m29")));
		log.info("本期投注30->"+GameData.getFastTenMap().get("bettingNum30")+";index10->"+GameData.getFastTenMap().get("index30")+";m->"+(GameData.getFastTenMap().get("m30")==null?0:GameData.getFastTenMap().get("m30")));
		log.info("==========================================================================");
		log.info("本期投注31->"+GameData.getFastTenMap().get("bettingNum31")+";index10->"+GameData.getFastTenMap().get("index31")+";m->"+(GameData.getFastTenMap().get("m31")==null?0:GameData.getFastTenMap().get("m31")));
		log.info("本期投注32->"+GameData.getFastTenMap().get("bettingNum32")+";index10->"+GameData.getFastTenMap().get("index32")+";m->"+(GameData.getFastTenMap().get("m32")==null?0:GameData.getFastTenMap().get("m32")));
		log.info("本期投注33->"+GameData.getFastTenMap().get("bettingNum33")+";index10->"+GameData.getFastTenMap().get("index33")+";m->"+(GameData.getFastTenMap().get("m33")==null?0:GameData.getFastTenMap().get("m33")));
		log.info("本期投注34->"+GameData.getFastTenMap().get("bettingNum34")+";index10->"+GameData.getFastTenMap().get("index34")+";m->"+(GameData.getFastTenMap().get("m34")==null?0:GameData.getFastTenMap().get("m34")));
		log.info("本期投注35->"+GameData.getFastTenMap().get("bettingNum35")+";index10->"+GameData.getFastTenMap().get("index35")+";m->"+(GameData.getFastTenMap().get("m35")==null?0:GameData.getFastTenMap().get("m35")));
		log.info("本期投注36->"+GameData.getFastTenMap().get("bettingNum36")+";index10->"+GameData.getFastTenMap().get("index36")+";m->"+(GameData.getFastTenMap().get("m36")==null?0:GameData.getFastTenMap().get("m36")));
		log.info("本期投注37->"+GameData.getFastTenMap().get("bettingNum37")+";index10->"+GameData.getFastTenMap().get("index37")+";m->"+(GameData.getFastTenMap().get("m37")==null?0:GameData.getFastTenMap().get("m37")));
		log.info("本期投注38->"+GameData.getFastTenMap().get("bettingNum38")+";index10->"+GameData.getFastTenMap().get("index38")+";m->"+(GameData.getFastTenMap().get("m38")==null?0:GameData.getFastTenMap().get("m38")));
		log.info("本期投注39->"+GameData.getFastTenMap().get("bettingNum39")+";index10->"+GameData.getFastTenMap().get("index39")+";m->"+(GameData.getFastTenMap().get("m39")==null?0:GameData.getFastTenMap().get("m39")));
		log.info("本期投注40->"+GameData.getFastTenMap().get("bettingNum40")+";index10->"+GameData.getFastTenMap().get("index40")+";m->"+(GameData.getFastTenMap().get("m40")==null?0:GameData.getFastTenMap().get("m40")));
		log.info("==========================================================================");
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
