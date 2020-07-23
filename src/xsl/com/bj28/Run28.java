package xsl.com.bj28;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.HttpHostConnectException;

import xsl.com.main.Server;
import xsl.com.tool.ConfUtil;
import xsl.com.tool.FunUtil;

public class Run28 extends TimerTask{

	protected final Log log = LogFactory.getLog(Run28.class);
	private int bet_max=6;
	private int win_max=200000;
	private int win_min=-200000;
	private int runing=1;
	private int mode_value=200;
	//private int max=300000;
	@Override
	public void run() {
		int h=FunUtil.nowHour();
		int m=FunUtil.nowMin();
		win_max=Integer.parseInt(ConfUtil.ReadConfig("cana28_win_max"));
		win_min=Integer.parseInt(ConfUtil.ReadConfig("cana28_win_min"));
		runing=Integer.parseInt(ConfUtil.ReadConfig("cana28_run"));
		int is_morning=Integer.parseInt(ConfUtil.ReadConfig("cana28_morning"));
		String win_min_fixed=ConfUtil.ReadConfig("cana28_win_min_fixed");
		
		if(h==0 && m<2){
			GameData.getCana28Map().put("win_num", 0);
			ConfUtil.WriteConfig("cana28_win_min", win_min_fixed);
		}
		if(runing==1){
			try {
				if(is_morning==0){
					if(h>=9){
						single();
					}
				}else{
					single();
				}
		
				
			} catch (HttpHostConnectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			GameData.getCana28Map().put("index", 1);
			GameData.getCana28Map().clear();
			log.info("系统设置模式启动：停止");
		}	
		
			
	}
	public void  single() throws HttpHostConnectException{
		
		try {
			if(Server.isLogin()){

				GameData.GameData();
				
				if(GameData.getCana28Map()!=null){
					int a=(int)(Float.parseFloat(GameData.getCana28Map().get("win_num").toString()));
					int b=Integer.parseInt(ConfUtil.ReadConfig("cana28_win_min"));
					int c=Integer.parseInt(ConfUtil.ReadConfig("cana28_nowindex"));
					if(a-b>=400000*c){
						ConfUtil.WriteConfig("cana28_win_min", String.valueOf(b+100000));
					}
				
					if(GameData.getCana28Map().get("old_num")==null || 
							!GameData.getCana28Map().get("old_num").toString().equals(GameData.getCana28Map().get("now_num").toString())){
						
						  Betting.Betting(Betting.BigMode());
						  Betting.Log_Result();	
					}	
				}else{
					log.info("本期不投");
				}
					
			}else{
				log.info("你还没有登陆");
				try {
					Thread.sleep(1000*60*4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*if(Server.getLogin_err_num()<5){
					String code=Server.CodeImg();
					if(!code.equals("")){
						if(Server.Login(code)){
							log.info("重新登陆成功");
						}else{
							log.info("重新登陆失败");
							Server.setLogin_err_num(Server.getLogin_err_num()+1);
							
						}
					}else{
						log.info("获取验证码错误");
						Server.setLogin_err_num(Server.getLogin_err_num()+1);
					}
				}else{
					log.info("登陆失败次数过多");
					return;
				}
				*/
				
			}
							
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
			log.info("投注异常："+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("投注异常："+e.getMessage());
			
		}	
	}
	

}
