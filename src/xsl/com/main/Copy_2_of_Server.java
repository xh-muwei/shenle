package xsl.com.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.jsoup.Jsoup;

import xsl.com.tool.ConfUtil;
import xsl.com.tool.FunUtil;
import xsl.com.tool.GsonUtil;
import xsl.com.tool.HttpsUrlValidator;
import xsl.com.tool.Send163MailUtil;

public class Copy_2_of_Server {
	private static BasicCookieStore cookieStore = new BasicCookieStore();
	protected final static Log log = LogFactory.getLog(Copy_2_of_Server.class);
	private static boolean isLogin=false;
	private static int login_err_num=0;
	private static String codeId="";
	private static ConfUtil conf=new ConfUtil();
	
	public static void main(String[] args) throws Exception {
		StringBuilder str=new StringBuilder();
		str.append("score:10");str.append("\r\n");
		str.append("time:dfdfdfdfdf");str.append("\r\n");
		System.out.println(str.toString());
		Send163MailUtil.send("cana",str.toString());
       
    }
	
	
	public static String CodeImg() throws UnsupportedEncodingException {
		/*CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();*/
		CloseableHttpClient httpClient = FunUtil.HttpsClient();
	
		// 获取验证码
		String code = "";
		HttpGet codeGet = new HttpGet(conf.ReadConfig("url")+"verifycode");
		codeGet.setHeader("Connection", "keep-alive");
		codeGet.setHeader("Cache-Control", "no-cache");
		codeGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		try {
			HttpResponse response = httpClient.execute(codeGet,new BasicHttpContext());

			HttpEntity entity = response.getEntity();
			InputStream instream = entity.getContent();
			OutputStream outstream = new FileOutputStream(new File("c:/code",
					"code.png"));
			int l = -1;
			byte[] tmp = new byte[2048];
			while ((l = instream.read(tmp)) != -1) {
				outstream.write(tmp);
			}
			log.info("验证码图片获取成功！,正在解析图片");
			outstream.close();
			/*System.out.print("输入验证码：");
			Scanner scanner = new Scanner(System.in);  
			code = scanner.next(); */
			
			
			
			code = CodeImgHandle.code();
			if (code.equals("")) {
				log.info("验证码解析失败！");
			} else {
				log.info("验证码解析成功：" + code+";剩余提分："+CodeImgHandle.score());
			}
			return code;
		} catch (SocketTimeoutException e) {
			log.info("连接超时");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			log.info("访问主机失败！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			codeGet.releaseConnection();
		}
		return code;
	}

	public static String getCodeId() {
		return codeId;
	}

	public static void setCodeId(String codeId) {
		Copy_2_of_Server.codeId = codeId;
	}

	public static boolean Login() throws UnsupportedEncodingException {
		//CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
				CloseableHttpClient httpClient = FunUtil.HttpsClient();
      	

		boolean success=false;
		/*
		 * RequestConfig requestConfig = RequestConfig.custom()
		 * .setConnectTimeout(50000).setConnectionRequestTimeout(10000)
		 * .setSocketTimeout(50000).build();
		 */		
		HttpPost httpPost = new HttpPost(conf.ReadConfig("url")+"User/Login?act=login");

       /* JSONObject credentialsJsonParam = new JSONObject();
        credentialsJsonParam.put("logintype", 1);
        credentialsJsonParam.put("tbUserAccount", "18100822165");
        credentialsJsonParam.put("tbUserPwd", "mw50113516");
        credentialsJsonParam.put("mobile", "");
        credentialsJsonParam.put("code", "");

        log.info("map->" + credentialsJsonParam.toString());*/
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("logintype", "1", ContentType.MULTIPART_FORM_DATA);
        builder.addTextBody("tbUserAccount", "18100822165", ContentType.MULTIPART_FORM_DATA);
        builder.addTextBody("tbUserPwd", "mw50113516", ContentType.MULTIPART_FORM_DATA);
        builder.addTextBody("mobile", "", ContentType.MULTIPART_FORM_DATA);
        builder.addTextBody("code", "", ContentType.MULTIPART_FORM_DATA);

		//参数组装
		httpPost.setEntity(builder.build());
		
		log.info(httpPost.getEntity().toString());
		
		
		
		
		//formEntity.setContentType("Content-Type:application/json");
		//httpPost.setEntity(formEntity);
	/*	httpPost.setHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setHeader("Accept",
				"application/json, text/javascript, *//**; q=0.01");*/
		/*httpPost.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Cache-Control", "no-cache");*/
		/*httpPost.setHeader("X-Requested-With", "XMLHttpRequest");*/

		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Post请求
			response = httpClient.execute(httpPost);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			String str = "";
			if (responseEntity != null) {
				InputStream instreams = responseEntity.getContent();
				str = convertStreamToString(instreams);
			}
		
			log.info("返回结果登陆结果：" + str);

			Map<String, Object> map = GsonUtil.json2Object(str, Map.class);
			log.info("返回结果登陆结果：" + map);
			if(Integer.parseInt(map.get("ErrorCode").toString().split("\\.")[0])==0){
				log.info("登陆成功");
				isLogin=true;
				login_err_num=0;
				return true;
				
			}else{
				isLogin=false;
				//CodeImgHandle.code(Server.getCodeId());
				//Login(CodeImg());
				return false;
			}
			

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			log.info("登陆：访问主机失败！");
		} catch (IOException e) {
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
		return false;

	}


	public static boolean isLogin() {
		return isLogin;
	}

	public static void setLogin(boolean isLogin) {
		Copy_2_of_Server.isLogin = isLogin;
	}

	

	public static String convertStreamToString(InputStream is)
			throws IOException {

		InputStreamReader ir = new InputStreamReader(is, "utf-8");

		BufferedReader reader = new BufferedReader(ir);

		StringBuilder sb = new StringBuilder();

		String line = null;
		try {// .UnescapeDataString(line)
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return decode(sb.toString());
	}

	public static String decode(String unicodeStr) {
		if (unicodeStr == null) {
			return null;
		}
		StringBuffer retBuf = new StringBuffer();
		int maxLoop = unicodeStr.length();
		for (int i = 0; i < maxLoop; i++) {
			if (unicodeStr.charAt(i) == '\\') {
				if ((i < maxLoop - 5)
						&& ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr
								.charAt(i + 1) == 'U')))
					try {
						retBuf.append((char) Integer.parseInt(
								unicodeStr.substring(i + 2, i + 6), 16));
						i += 5;
					} catch (NumberFormatException localNumberFormatException) {
						retBuf.append(unicodeStr.charAt(i));
					}
				else
					retBuf.append(unicodeStr.charAt(i));
			} else {
				retBuf.append(unicodeStr.charAt(i));
			}
		}
		return retBuf.toString();
	}

	
	
	public static int getLogin_err_num() {
		return login_err_num;
	}

	public static void setLogin_err_num(int login_err_num) {
		Copy_2_of_Server.login_err_num = login_err_num;
	}


	public static BasicCookieStore getCookieStore() {
		return cookieStore;
	}


	public static void setCookieStore(BasicCookieStore cookieStore) {
		Copy_2_of_Server.cookieStore = cookieStore;
	}

}
