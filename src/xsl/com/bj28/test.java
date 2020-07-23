package xsl.com.bj28;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import xsl.com.tool.ConfUtil;
import xsl.com.tool.WriteProperties;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ConfUtil.WriteConfig("hg10_run", "0");
		tt();
	

	}
	public static void tt(){
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		List<String> list3=new ArrayList<String>();
    	for(int i=1;i<=10;i++){
			list1.add(i);
			list2.add(i);
		}
    	
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			if(i!=j){
    				String a=i+":"+j;
    				String b=j+":"+i;
    				if(!notHave(a, list3) && !notHave(b,list3)){
    					list3.add(a);
    				}
    				
    			}
    		}
    	}
    	
    	System.out.println(list3.size());
    	System.out.println(list3);
    	
    	
    	
    	
    	
    	

	}
	public static boolean notHave(String a,List<String> list){
		if(list==null || list.size()==0){
			return false;
		}
		for(String x:list){
			if(a.equals(x)){
				return true;
			}
		}
		return false;
	}

}
