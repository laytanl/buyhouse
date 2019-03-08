package com.csuft.buyhouse.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class CodeUtil {
	public static String sign(String secret, String timeStr)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		// get signStr
		String signStr = "date: " + timeStr + "\n" + "source: " + "source";
		// get sig
		String sig = null;
		Mac mac1 = Mac.getInstance("HmacSHA1");
		byte[] hash;
		SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), mac1.getAlgorithm());
		mac1.init(secretKey);
		hash = mac1.doFinal(signStr.getBytes("UTF-8"));
		sig = new BASE64Encoder().encode(hash);
//	        System.out.println("signValue--->" + sig);
		return sig;
	}

	public static int code(String phone) {
		
		String result = "";
		BufferedReader in = null;
		int m = (int) (Math.random() * 9000+1000);
		System.out.println(m);
		// get current GMT time
		Calendar cd = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String timeStr = sdf.format(cd.getTime());

		String host = "service-4xrmju6b-1255399658.ap-beijing.apigateway.myqcloud.com";
		String path = "/dxsms";
		String query = "mobile=" + phone + "&param=code%3A" + m + "&tpl_id=TP1801042";
		String url = "http://service-4xrmju6b-1255399658.ap-beijing.apigateway.myqcloud.com/release";
		url = url + path + "?" + query;
		String source = "source";
		// 云市场分配的密钥Id
		String secretId = "AKID9Csyxp1ehj21o78Y6yCtwjNc8tt9kIr7Jid4";
		// 云市场分配的密钥Key
		String secretKey = "KqHtt2Ys6PbJgnGx8qvw9l3nbqjflnd4Zh3o2ym6";

		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			HttpURLConnection httpUrlCon = (HttpURLConnection) connection;
			// 设置通用的请求属性
			httpUrlCon.setRequestProperty("Host", host);
			httpUrlCon.setRequestProperty("Accept", "text/html, */*; q=0.01");
			httpUrlCon.setRequestProperty("Source", source);
			httpUrlCon.setRequestProperty("Date", timeStr);
			String sig = sign(secretKey, timeStr);
			String authen = "hmac id=\"" + secretId
					+ "\", algorithm=\"hmac-sha1\", headers=\"date source\", signature=\"" + sig + "\"";
//        System.out.println("authen --->" + authen);
			httpUrlCon.setRequestProperty("Authorization", authen);
			httpUrlCon.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			httpUrlCon.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			// 建立实际的连接
			httpUrlCon.connect();
			// 获取所有响应头字段
//        Map<String, List<String>> map = httpUrlCon.getHeaderFields();
			// 遍历所有的响应头字段
//        for (String key : map.keySet()) {
//            System.out.println(key + "--->" + map.get(key));
//        }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(httpUrlCon.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

			System.out.println(result);

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return m;
	}
}
