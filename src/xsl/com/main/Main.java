package xsl.com.main;

import java.io.IOException;
import java.util.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import school.RunCard;
import xsl.com.bj28.Run28;
import xsl.com.fast10.Run10;
import xsl.com.pk10.RunPk10;
import xsl.com.tool.ConfUtil;


public class Main {
protected final static Log log = LogFactory.getLog(Main.class);
	
	

	public static void main(String[] args) throws IOException {
		//String code=Server.CodeImg();
		Timer timer=new Timer();
	/*	if(!code.equals("")){
			if(Server.Login(code)){
				//timer.scheduleAtFixedRate(new Beij28Betting(), 1000, 1000*60*2);
				//timer.scheduleAtFixedRate(new Run10(), 2000, 1000*25);
				timer.scheduleAtFixedRate(new Run10(), 2000, 1000*50);
				//timer.scheduleAtFixedRate(new Run10(), 2000, 1000*25);
				//timer.scheduleAtFixedRate(new Run16(), 2000, 1000*20);
			}else{
				log.info("登陆失败");	
			}
		}else{
			log.info("获取验证码错误");
		}*/
	
		if(Server.Login()){
			int id=Integer.parseInt(ConfUtil.ReadConfig("id28"));
			if(id==72){
				timer.scheduleAtFixedRate(new Run10(), 2000, 1000*40);
				timer.scheduleAtFixedRate(new Run28(), 8000, 1000*40);
			}else{
				timer.scheduleAtFixedRate(new Run10(), 2000, 1000*70);
				timer.scheduleAtFixedRate(new Run28(), 8000, 1000*70);
			}
			
		}else{
			log.info("登陆失败");	
		}
		

	}
}



