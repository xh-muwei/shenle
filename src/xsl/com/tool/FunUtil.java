package xsl.com.tool;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import xsl.com.main.Server;

public class FunUtil {
	
	public static void main(String[] args) {
		System.out.println(nowMin());
	}
	
	public static String nowDateNotTime() {
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		dd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String date = dd.format(new Date());
		return date;
	}
	public static int StringToInt(String str) {
		if(str==null || str.equals("")){
			return 0;
		};
		if(str.indexOf(",")>-1){
			str.replaceAll("\\,", " ");
		}
		return Integer.parseInt(str);
	}
	public static int StringToInt2(String str) {
		if(str==null || str.equals("")){
			return 0;
		};
		if(str.indexOf(",")>-1){
			String[] s=str.split(",");
			StringBuilder b=new StringBuilder();
			for (String string : s) {
				b.append(string);
			}
			str=b.toString().trim();
		}
		return Integer.parseInt(str);
	}
	public static int nowHour() {
		SimpleDateFormat dd = new SimpleDateFormat("H");
		dd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		int h = Integer.parseInt(dd.format(new Date()));
		return h;
	}
	public static int nowMin() {
		SimpleDateFormat dd = new SimpleDateFormat("m");
		dd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		int h = Integer.parseInt(dd.format(new Date()));
		return h;
	}
	
    public static Date strToDate(String str) {
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Date date = null;
		try {
			date = dd.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
    public static String RandomAlphanumeric(int count) {
		RandomStringUtils utils = new RandomStringUtils();
		String str = utils.randomAlphanumeric(count);
		
		return str;
	}
    public static String RandomNumber(int count) {
		RandomStringUtils utils = new RandomStringUtils();
		String str = utils.random(count, new char[]{'1','2','3','4','5','6','7','8','9','0'}); 
		return str;
	}
    public static String RandomWord(int num) {
		String[] beforeShuffle = new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "0" };
		List list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			int s = random.nextInt(list.size() - 1);
			sb.append(list.get(s));
		}
		String afterShuffle = sb.toString();
		return afterShuffle;
	}
    public static String RandomWordNoRepeat(int num) {
		String[] beforeShuffle = new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "0" };
		List list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			int s = random.nextInt(list.size() - 1);
			sb.append(list.get(s));
		}
		String afterShuffle = sb.toString();
		return afterShuffle;
	}
    public static String replace(String str) {
	    String destination = "";
	    if (str!=null) {
	        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	        Matcher m = p.matcher(str);
	        destination = m.replaceAll("");
	    }
	    return destination;
	}
    public static String MD5(String originstr) {
		String result = null;
		char hexDigits[] = {// 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		if (originstr != null) {
			try {
				// 返回实现指定摘要算法的 MessageDigest 对象
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用utf-8编码将originstr字符串编码并保存到source字节数组
				byte[] source = originstr.getBytes("utf-8");
				// 使用指定的 byte 数组更新摘要
				md.update(source);
				// 通过执行诸如填充之类的最终操作完成哈希计算，结果是一个128位的长整数
				byte[] tmp = md.digest();
				// 用16进制数表示需要32位
				char[] str = new char[32];
				for (int i = 0, j = 0; i < 16; i++) {
					// j表示转换结果中对应的字符位置
					// 从第一个字节开始，对 MD5 的每一个字节
					// 转换成 16 进制字符
					byte b = tmp[i];
					// 取字节中高 4 位的数字转换
					// 无符号右移运算符>>> ，它总是在左边补0
					// 0x代表它后面的是十六进制的数字. f转换成十进制就是15
					str[j++] = hexDigits[b >>> 4 & 0xf];
					// 取字节中低 4 位的数字转换
					str[j++] = hexDigits[b & 0xf];
				}
				result = new String(str);// 结果转换成字符串用于返回
			} catch (NoSuchAlgorithmException e) {
				// 当请求特定的加密算法而它在该环境中不可用时抛出此异常
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// 不支持字符编码异常
				e.printStackTrace();
			}
		}
		return result;
	}
/**
     * 获取https连接（不验证证书）
     *
     * @return
     */
    @SuppressWarnings("unused")
	public static CloseableHttpClient HttpsClient() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        // 指定信任密钥存储对象和连接套接字工厂
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            // 信任任何链接
            TrustStrategy anyTrustStrategy = new TrustStrategy() {
 
                @Override
                public boolean isTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                    // TODO Auto-generated method stub
                    return true;
                }
            };
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        // 设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        // 构建客户端
       // HttpClients.custom().setDefaultCookieStore(cookieStore).build()
        return HttpClientBuilder.create().setConnectionManager(connManager).setDefaultCookieStore(Server.getCookieStore()).build();
    }
	 public static Map<String,Integer> frequencyOfListElements( List<Integer> items ) {
	        if (items == null || items.size() == 0) return null;
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        for (Integer temp : items) {
	            Integer count = map.get(String.valueOf("k-"+temp));
	            map.put("k-"+temp, (count == null) ? 1 : count + 1);
	        }
	        return map;
	    }
}
