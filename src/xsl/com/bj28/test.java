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
		five();
	

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
	public static void three(){
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		List<Integer> list3=new ArrayList<Integer>();
		List<String> list4=new ArrayList<String>();
    	for(int i=1;i<=10;i++){
			list1.add(i);
			list2.add(i);
			list3.add(i);
		}
    	
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			for(int k=0;k<10;k++){
    				if(i!=j && j!=k && i!=k){
        				String a=i+":"+j+":"+k;
        				List<Integer> q=new ArrayList<>();
        				q.add(i);q.add(j);q.add(k);
        				System.out.println("当前："+q);
        				if(!notHaveThree(q, list4)){
        					System.out.println("加入");
        					list4.add(a);
        				}
        				
        			}
    			}
    		}
    	}
    	
    	System.out.println(list4.size());
    	System.out.println(list4);    	    	    	    		    	

	}
	public static boolean notHaveThree(List<Integer> a,List<String> list){
		System.out.println("aaaaa->"+a);
		if(list==null || list.size()==0){
			return false;
		}
		List<Integer> xxx=new ArrayList<>();
		xxx.add(1);
		xxx.add(3);
		xxx.add(5);
		
		for(String x:list){
			String[] as=x.split("\\:");
			List<Integer> b=new ArrayList<>();
			for(int i=0;i<as.length;i++){
				b.add(Integer.parseInt(as[i]));
			}
			b.retainAll(a);
			if(b.size()>=2){
				return true;
			}
		}
		return false;
	}
	public static void five(){
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		List<Integer> list3=new ArrayList<Integer>();
		List<Integer> list4=new ArrayList<Integer>();
		List<Integer> list5=new ArrayList<Integer>();
		List<String> list6=new ArrayList<String>();
    	for(int i=1;i<=10;i++){
			list1.add(i);
			list2.add(i);
			list3.add(i);
			list4.add(i);
			list5.add(i);
		}
    	
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			for(int k=0;k<10;k++){
    				for(int l=0;l<10;l++){
    					for(int m=0;m<10;m++){
    						List<Integer> q=new ArrayList<>();
	        				q.add(i);q.add(j);q.add(k);q.add(l);q.add(m);
	        				List yy=removeDuplicate(q);
    						if(yy.size()==5){
    	        				String a=i+":"+j+":"+k+":"+l+":"+m;
    	        				if(!notHaveFive(q, list6)){
    	        					System.out.println("加入"+q);
    	        					list6.add(a);
    	        				}
    	        				
    	        			}
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(list6.size());
    	System.out.println(list6);    	    	    	    		    	

	}
	public static boolean notHaveFive(List<Integer> a,List<String> list){
		if(list==null || list.size()==0){
			return false;
		}
		List<Integer> xxx=new ArrayList<>();
		for(String x:list){
			String[] as=x.split("\\:");
			List<Integer> b=new ArrayList<>();
			for(int i=0;i<as.length;i++){
				b.add(Integer.parseInt(as[i]));
			}
			b.retainAll(a);
			if(b.size()>=4){
				return true;
			}
		}
		return false;
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
	public static List removeDuplicate(List list){  
        List listTemp = new ArrayList();  
        for(int i=0;i<list.size();i++){  
            if(!listTemp.contains(list.get(i))){  
                listTemp.add(list.get(i));  
            }  
        }  
        return listTemp;  
    }

}
