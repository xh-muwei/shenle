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
		WriteProperties write=new WriteProperties();
		try {
			write.save("hg10_run", "0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("修改");
	

	}
	public static void tt(){
		List<Integer> list1=new ArrayList<Integer>();
    	for(int i=1;i<=10;i++){
			list1.add(i);
		}	 
    	Collections.shuffle(list1); 
    	Collections.shuffle(list1); 
		
		List<Integer> rs=new ArrayList<Integer>();
		for(int i=0;i<8;i++){
			int a=list1.get(i)%10;
			for(int j=0;j<=27;j++){
				if(j%10==a){
					rs.add(j);
				}
			}
			
		}	
		System.out.println(list1);

	}

}
