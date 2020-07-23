package xsl.com.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfUtil{
	private static String Value="";

	public static String ReadConfig(String name){
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(rootPath+"/config.properties");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(rootPath+ "/config/config.properties");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Properties p = new PropertiesUtils();   
		try {   
			p.load(inputStream);   
		} catch (IOException e1) {   
			e1.printStackTrace();   
		} 
		finally {//关闭资源  
            if (inputStream != null) {  
                try {  
                	inputStream.close();  
                } catch (IOException e) {  
                }  
            }
		}
		//System.out.println("ip:"+p.getProperty("ip"));  
		Value=p.getProperty(name);
		return Value;

	}
	/** 
     * 修改或添加键值对 如果key存在，修改, 反之，添加。 
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties 
     * @param key 键 
     * @param value 键对应的值 
     */  
	/*public String ReadConfig(String name){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");

		Properties p = new Properties();   
		try {   
			p.load(inputStream);   
		} catch (IOException e1) {   
			e1.printStackTrace();   
		} 
		finally {//关闭资源  
            if (inputStream != null) {  
                try {  
                	inputStream.close();  
                } catch (IOException e) {  
                }  
            }
		}
		//System.out.println("ip:"+p.getProperty("ip"));  
		Value=p.getProperty(name);
		return Value;

	}*/
    public static void WriteConfig(String key, String value) {  
        //获取绝对路径  
        //filePath = ConfUtil.class.getResource("/" + filePath).toString();  
        //截掉路径的”file:/“前缀  
        //filePath = filePath.substring(6); 
        
        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        String filePath=rootPath+ "/config/config.properties";
              
        
        Properties prop = new PropertiesUtils();;  
        try {  
            File file = new File(filePath);  
            if (!file.exists())  
                file.createNewFile();  
            InputStream fis = new FileInputStream(file);  
            prop.load(fis);  
            //一定要在修改值之前关闭fis  
            fis.close();  
            OutputStream fos = new FileOutputStream(filePath);  
            prop.setProperty(key,value);  
            //保存，并加入注释  
            prop.store(fos, "Update '" + key + "' value");  
            fos.close();  
        } catch (IOException e) {  
            System.err.println("Visit " + filePath + " for updating " + value + " value error");  
        }  
    }  

}
