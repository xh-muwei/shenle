package school;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import xsl.com.main.Server;
import xsl.com.tool.FunUtil;
import xsl.com.tool.GsonUtil;
import xsl.com.tool.HttpClientUtil;
import xsl.com.tool.Send163MailUtil;

import com.google.gson.JsonSyntaxException;

public class Card {
	private static String cardTime="";
	protected static final Log log = LogFactory.getLog(Card.class);
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	
	public static String getCardTime() {
		return cardTime;
	}


	public static void setCardTime(String cardTime) {
		Card.cardTime = cardTime;
	}


	public static void add() throws UnsupportedEncodingException{

		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("typeId", 1093);
		paramMap.put("vC1", "999998");
		paramMap.put("vC2", "高新区菁蓉幼儿园");
		paramMap.put("vC3", "869");
		paramMap.put("vC4", "小三班");
		paramMap.put("vC5", "牟锦轩");
		paramMap.put("vC6", "36.5");
		paramMap.put("vC7", "否");
		paramMap.put("vC8", "");
		paramMap.put("vC13", "无上述接触");
		paramMap.put("vC18", "否");
		paramMap.put("vC23", "已阅读");
		String url="http://api.jpgzx.com/Special/QuestionSurvey/Submit";
		String rs=HttpClientUtil.sendPostByJson(url, GsonUtil.object2Json(paramMap));
		log.info("打卡返回结果:"+rs);
		try {
			Send163MailUtil.send("小孩儿自动打卡软件,返回结果",rs);
			
		} catch (NoClassDefFoundError e) {
			log.error("没法找到邮件类");
		}

	}

}
