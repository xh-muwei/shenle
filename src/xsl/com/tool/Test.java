package xsl.com.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		// 第一步：获取到properties文件的路径和名称
				String binPath = Test.class.getClassLoader().getResource("").getFile();
				File file = new File(binPath);
				String propPath = file.getParent() + File.separator + "config" + File.separator + "config.properties";
				try {
					// 第二步：获取文件的输入流
					InputStream in = new FileInputStream(propPath);
					/*************第二种获取文件的输入流方式（使用这种最好）*********************/		
		           // 使用ClassLoader加载properties配置文件生成对应的输入流
		           // InputStream in = PropertiesMain.class.getClassLoader().getResourceAsStream("resource/prop.properties");
					//实例化java.util下的Properties当属性变化的时候会改变文件里面的属性和注释的顺序
					// Properties prop = new Properties();
					// 实例化PropertiesUtil，重写了Properties类的一些方法，保证修改文件时原来文件顺序的不改变
					Properties prop = new PropertiesUtils();
					// 第三步：加载properties对象
					prop.load(in);
					// 第四部步：关闭输入流
					in.close();
					System.out.println(prop.getProperty("cana28_run"));
					// 第五步：创建输出流， false表示不以追加的方式输出，默认false,不过一些同学会采坑。
					OutputStream out = new FileOutputStream(propPath, false);
					// 第六步：修改/添加properties文件的属性值（key如果有修改，key如果没有则添加）
					prop.setProperty("cana28_run", "55");
					// 第七步：输出prop对象，"propertiesDemo"添加到文件第一行的注释
					prop.store(out, "propertiesDemo");
					// 关闭输出流
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}
