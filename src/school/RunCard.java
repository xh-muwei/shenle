package school;

import java.io.UnsupportedEncodingException;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xsl.com.tool.FunUtil;

public class RunCard extends TimerTask {
	protected final Log log = LogFactory.getLog(RunCard.class);
	@Override
	public void run() {
		int h=FunUtil.nowHour();
		int m=FunUtil.nowMin();
		//h>10 || h<7
		if(h>10 || h<7){
			log.info("未到打卡时间");
		}else{
			if(!FunUtil.nowDateNotTime().equals(Card.getCardTime())){
				Card.setCardTime(FunUtil.nowDateNotTime());
				try {
					Card.add();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("开始打卡:"+Card.getCardTime());
			}else{
				log.info("已近打卡:"+Card.getCardTime()+";不需要重复打卡");
			}
			
			
		}
	}

}
