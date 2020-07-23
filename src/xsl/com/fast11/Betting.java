package xsl.com.fast11;

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
import xsl.com.tool.FunUtil;
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
	/*public static Map<String, Object> mode1(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);
		Collections.shuffle(list);
		Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum1")==null){
			GameData.getFastElevenMap().put("index1", 1);
			list1=list;
		}else{
			if(!single_win("bettingNum1")){
				if(betting_index1==1){
					betting_index1=2;
				}else{
					betting_index1=1;
				}
				if(Integer.parseInt(GameData.getFastElevenMap().get("index1").toString())>=bet_max){
					GameData.getFastElevenMap().put("index1", 1);
					GameData.getFastElevenMap().
					put("m1", GameData.getFastElevenMap().get("m1")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m1").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index1", 
							Integer.parseInt(GameData.getFastElevenMap().get("index1").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index1", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index1").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum1",str.toString());
		return map;
	}
	public static Map<String, Object> mode2(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum2")==null){
			GameData.getFastElevenMap().put("index2", 1);
			list2=list;
		}else{
			if(!single_win("bettingNum2")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index2").toString())>=bet_max){
					GameData.getFastElevenMap().put("index2", 1);
					GameData.getFastElevenMap().
					put("m2", GameData.getFastElevenMap().get("m2")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m2").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index2", 
							Integer.parseInt(GameData.getFastElevenMap().get("index2").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index2", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index2").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum2",str.toString());
		return map;
	}
	public static Map<String, Object> mode3(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum3")==null){
			GameData.getFastElevenMap().put("index3", 1);
			list3=list;
		}else{
			if(!single_win("bettingNum3")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index3").toString())>=bet_max){
					GameData.getFastElevenMap().put("index3", 1);
					GameData.getFastElevenMap().
					put("m3", GameData.getFastElevenMap().get("m3")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m3").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index3", 
							Integer.parseInt(GameData.getFastElevenMap().get("index3").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index3", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index3").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum3",str.toString());
		return map;
	}
	public static Map<String, Object> mode4(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum4")==null){
			GameData.getFastElevenMap().put("index4", 1);
			list4=list;
		}else{
			if(!single_win("bettingNum4")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index4").toString())>=bet_max){
					GameData.getFastElevenMap().put("index4", 1);
					GameData.getFastElevenMap().
					put("m4", GameData.getFastElevenMap().get("m4")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m4").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index4", 
							Integer.parseInt(GameData.getFastElevenMap().get("index4").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index4", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index4").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum4",str.toString());
		return map;
	}
	public static Map<String, Object> mode5(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum5")==null){
			GameData.getFastElevenMap().put("index5", 1);
			list5=list;
		}else{
			if(!single_win("bettingNum5")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index5").toString())>=bet_max){
					GameData.getFastElevenMap().put("index5", 1);
					GameData.getFastElevenMap().
					put("m5", GameData.getFastElevenMap().get("m5")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m5").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index5", 
							Integer.parseInt(GameData.getFastElevenMap().get("index5").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index5", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index5").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum5",str.toString());
		return map;
	}
	public static Map<String, Object> mode6(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum6")==null){
			GameData.getFastElevenMap().put("index6", 1);
			list6=list;
		}else{
			if(!single_win("bettingNum6")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index6").toString())>=bet_max){
					GameData.getFastElevenMap().put("index6", 1);
					GameData.getFastElevenMap().
					put("m6", GameData.getFastElevenMap().get("m6")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m6").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index6", 
							Integer.parseInt(GameData.getFastElevenMap().get("index6").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index6", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index6").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum6",str.toString());
		return map;
	}
	public static Map<String, Object> mode7(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum7")==null){
			GameData.getFastElevenMap().put("index7", 1);
			list7=list;
		}else{
			if(!single_win("bettingNum7")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index7").toString())>=bet_max){
					GameData.getFastElevenMap().put("index7", 1);
					GameData.getFastElevenMap().
					put("m7", GameData.getFastElevenMap().get("m7")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m7").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index7", 
							Integer.parseInt(GameData.getFastElevenMap().get("index7").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index7", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index7").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum7",str.toString());
		return map;
	}
	public static Map<String, Object> mode8(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum8")==null){
			GameData.getFastElevenMap().put("index8", 1);
			list8=list;
		}else{
			if(!single_win("bettingNum8")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index8").toString())>=bet_max){
					GameData.getFastElevenMap().put("index8", 1);
					GameData.getFastElevenMap().
					put("m8", GameData.getFastElevenMap().get("m8")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m8").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index8", 
							Integer.parseInt(GameData.getFastElevenMap().get("index8").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index8", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index8").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum8",str.toString());
		return map;
	}
	public static Map<String, Object> mode9(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum9")==null){
			GameData.getFastElevenMap().put("index9", 1);
			list9=list;
		}else{
			if(!single_win("bettingNum9")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index9").toString())>=bet_max){
					GameData.getFastElevenMap().put("index9", 1);
					GameData.getFastElevenMap().
					put("m9", GameData.getFastElevenMap().get("m9")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m9").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index9", 
							Integer.parseInt(GameData.getFastElevenMap().get("index9").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index9", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index9").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum9",str.toString());
		return map;
	}
	public static Map<String, Object> mode10(){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		List<String> list=mode();
		Collections.shuffle(list);Collections.shuffle(list);Collections.shuffle(list);
		if(GameData.getFastElevenMap().get("bettingNum10")==null){
			GameData.getFastElevenMap().put("index10", 1);
			list10=list;
		}else{
			if(!single_win("bettingNum10")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index10").toString())>=bet_max){
					GameData.getFastElevenMap().put("index10", 1);
					GameData.getFastElevenMap().
					put("m10", GameData.getFastElevenMap().get("m10")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m10").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index10", 
							Integer.parseInt(GameData.getFastElevenMap().get("index10").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index10", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index10").toString());
		String[] val=list.get(0).split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum10",str.toString());
		return map;
	}
	*/
	public static Map<String, Object> mode11(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		if(GameData.getFastElevenMap().get("bettingNum11")==null){
			GameData.getFastElevenMap().put("index11", 1);
		}else{
			if(!single_win("bettingNum11")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index11").toString())>=bet_max){
					GameData.getFastElevenMap().put("index11", 1);
					GameData.getFastElevenMap().
					put("m11", GameData.getFastElevenMap().get("m11")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m11").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index11", 
							Integer.parseInt(GameData.getFastElevenMap().get("index11").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index11", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index11").toString());
		String[] val=sss.split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum11",str.toString());
		return map;
	}
	public static Map<String, Object> mode12(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		if(GameData.getFastElevenMap().get("bettingNum12")==null){
			GameData.getFastElevenMap().put("index12", 1);
		}else{
			if(!single_win("bettingNum12")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index12").toString())>=bet_max){
					GameData.getFastElevenMap().put("index12", 1);
					GameData.getFastElevenMap().
					put("m12", GameData.getFastElevenMap().get("m12")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m12").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index12", 
							Integer.parseInt(GameData.getFastElevenMap().get("index12").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index12", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index12").toString());
		String[] val=sss.split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum12",str.toString());
		return map;
	}
	public static Map<String, Object> mode13(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		if(GameData.getFastElevenMap().get("bettingNum13")==null){
			GameData.getFastElevenMap().put("index13", 1);
		}else{
			if(!single_win("bettingNum13")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index13").toString())>=bet_max){
					GameData.getFastElevenMap().put("index13", 1);
					GameData.getFastElevenMap().
					put("m13", GameData.getFastElevenMap().get("m13")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m13").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index13", 
							Integer.parseInt(GameData.getFastElevenMap().get("index13").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index13", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index13").toString());
		String[] val=sss.split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum13",str.toString());
		return map;
	}
	public static Map<String, Object> mode14(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		if(GameData.getFastElevenMap().get("bettingNum14")==null){
			GameData.getFastElevenMap().put("index14", 1);
		}else{
			if(!single_win("bettingNum14")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index14").toString())>=bet_max){
					GameData.getFastElevenMap().put("index14", 1);
					GameData.getFastElevenMap().
					put("m14", GameData.getFastElevenMap().get("m14")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m14").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index14", 
							Integer.parseInt(GameData.getFastElevenMap().get("index14").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index14", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index14").toString());
		String[] val=sss.split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum14",str.toString());
		return map;
	}
	public static Map<String, Object> mode15(String sss){
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuilder str=new StringBuilder();
		int ss=Integer.parseInt(ConfUtil.ReadConfig("jx11_mode_value"));
		int bet_max=Integer.parseInt(ConfUtil.ReadConfig("jx11_bet_max"));
		if(GameData.getFastElevenMap().get("bettingNum15")==null){
			GameData.getFastElevenMap().put("index15", 1);
		}else{
			if(!single_win("bettingNum15")){
		
				if(Integer.parseInt(GameData.getFastElevenMap().get("index15").toString())>=bet_max){
					GameData.getFastElevenMap().put("index15", 1);
					GameData.getFastElevenMap().
					put("m15", GameData.getFastElevenMap().get("m15")==null?1:
						(Integer.parseInt(GameData.getFastElevenMap().get("m15").toString())+1));
				}else{
					GameData.getFastElevenMap().put("index15", 
							Integer.parseInt(GameData.getFastElevenMap().get("index15").toString())+1);
				}
						
			}else{
				GameData.getFastElevenMap().put("index15", 1);
			
			}
		}
		int index=Integer.parseInt(GameData.getFastElevenMap().get("index15").toString());
		String[] val=sss.split(",");
		for(int j=0;j<val.length;j++){
			map.put("betting[f"+val[j]+"]", ss*FullMap(Integer.parseInt(val[j]))*BettingOneValue(index));
			str.append(val[j]);
			str.append(",");
		}	
		
		GameData.getFastElevenMap().put("bettingNum15",str.toString());
		return map;
	}

 
	public static Map<String, Object> BigMode(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("oldBtnCoins", 0);
		map.put("gt", "h5");
		map.put("method", "addbetten");
		map.put("arr_len", 0);
		map.put("bnum", bet_num);
		map.put("bnum", GameData.getFastElevenMap().get("now_num"));
		List<String> list=mode();
		Collections.shuffle(list);
		Collections.shuffle(list);
		Collections.shuffle(list);
		Map<String, Object> map11=mode11(list.get(0));
		Map<String, Object> map12=mode12(list.get(1));
		Map<String, Object> map13=mode13(list.get(2));
		Map<String, Object> map14=mode14(list.get(3));
		Map<String, Object> map15=mode15(list.get(4));
		int all=0;
		for(int i=2;i<=12;i++){	
			int a=0;
			a+=Integer.parseInt(map11.get("betting[f"+i+"]")==null?"0":map11.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map12.get("betting[f"+i+"]")==null?"0":map12.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map13.get("betting[f"+i+"]")==null?"0":map13.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map14.get("betting[f"+i+"]")==null?"0":map14.get("betting[f"+i+"]").toString());
			a+=Integer.parseInt(map15.get("betting[f"+i+"]")==null?"0":map15.get("betting[f"+i+"]").toString());
			
			if(a>0){
				map.put("SMONEY", a);
			}else{
				map.put("SMONEY", "");
			}
			map.put("ck_", 1);
				
			all+=a;
		}
		map.put("SMONEYSUM", all);
		log.info("本期投注："+all);
	
		return map;
	}
	 public static boolean single_win(String str){
		 try{
				String[] betting=GameData.getFastElevenMap().get(str).toString().split(",");
				String rs=GameData.getFastElevenMap().get("result").toString();
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
			String[] num=ConfUtil.ReadConfig("jx11_bet_mode").split(",");
			
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
	    log.info("Hg10总投注期数："+(++bet_num));
		log.info("Hg10上期结果："+GameData.getFastElevenMap().get("result"));
	   log.info("============================================================");
		log.info("本期投注11->"+GameData.getFastElevenMap().get("bettingNum11")+";index->"+GameData.getFastElevenMap().get("index11")+";m->"+(GameData.getFastElevenMap().get("m11")==null?0:GameData.getFastElevenMap().get("m11")));
		log.info("本期投注12->"+GameData.getFastElevenMap().get("bettingNum12")+";index->"+GameData.getFastElevenMap().get("index12")+";m->"+(GameData.getFastElevenMap().get("m12")==null?0:GameData.getFastElevenMap().get("m12")));
		log.info("本期投注13->"+GameData.getFastElevenMap().get("bettingNum13")+";index->"+GameData.getFastElevenMap().get("index13")+";m->"+(GameData.getFastElevenMap().get("m13")==null?0:GameData.getFastElevenMap().get("m13")));
		log.info("本期投注14->"+GameData.getFastElevenMap().get("bettingNum14")+";index->"+GameData.getFastElevenMap().get("index14")+";m->"+(GameData.getFastElevenMap().get("m14")==null?0:GameData.getFastElevenMap().get("m14")));		
		log.info("本期投注15->"+GameData.getFastElevenMap().get("bettingNum15")+";index->"+GameData.getFastElevenMap().get("index15")+";m->"+(GameData.getFastElevenMap().get("m15")==null?0:GameData.getFastElevenMap().get("m15")));
		log.info("当前序号："+GameData.getFastElevenMap().get("now_num"));
		log.info("投注序号："+GameData.getFastElevenMap().get("old_num"));
		log.info("当前分值："+GameData.getFastElevenMap().get("win_num"));
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("SCORE", GameData.getFastElevenMap().get("win_num"));
		map.put("value", GameData.getFastElevenMap().get("score"));
		mail.add(map);
		if(mail.size()>=120){
			String ss=mail.get(mail.size()-1).toString();
			try {
				Send163MailUtil.send("jx11",ss);
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
			GameData.getFastElevenMap().put("old_num", GameData.getFastElevenMap().get("now_num"));
			return;
		}

		CloseableHttpClient httpClient = FunUtil.HttpsClient();
		/*BasicClientCookie cookie = new BasicClientCookie("p_mapid", "5");
		cookie.setVersion(0);
		cookie.setDomain("vip.xsj2800.com"); // 设置范围
		cookie.setPath("/");
		Server.getCookieStore().addCookie(cookie);*/
		HttpPost httpPost = new HttpPost(
				ConfUtil.ReadConfig("url")+"inc/gcom");
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
			if(map.get("ErrorCode").toString().equals("0")){
				GameData.getFastElevenMap().put("old_num", GameData.getFastElevenMap().get("now_num"));
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
