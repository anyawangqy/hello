package com.jiuxin.meeting.ecs263;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.actionsoft.awf.util.MD5;
import com.jiuxin.meeting.util.HttpNet;
import com.jiuxin.meeting.util.Value;


public class ECS263API {
	public final static String ECS_263_USERNAME = Value
			.getValue("ECS_263_USERNAME");
	public final static String ECS_263_PASSWORD = Value
			.getValue("ECS_263_PASSWORD");

	public final static String ECS_263_SITEKEY = Value
			.getValue("ECS_263_SITEKEY");

	public final static String ECS_263_SITEPWD = Value
			.getValue("ECS_263_SITEPWD");

	public final static String ECS263IP = Value.getValue("ECS263IP");
	
	public final static String ECS_263_MAIL_PASSWORD = Value.getValue("ECS_263_MAIL_PASSWORD");//发送会议通知的263邮箱密码	
	public final static String ECS_263_MAIL_FROMUSER = Value.getValue("ECS_263_MAIL_FROMUSER");//发送会议通知的263邮箱发件人
	public static ECS263API api = null;
	public static HttpNet httpNet = null;
	public ECS263API() {
		httpNet = new HttpNet();
	}

	public static ECS263API getInstance() {
		if (api == null) {
			api = new ECS263API();
		}
		return api;
	}

	/**
	 * 创建会议
	 * 
	 * @param Meet263Entity
	 * @return
	 */
	public String createMeet(ECS263Entity o) {
		StringBuffer sb = new StringBuffer();
		MD5 md5 = new MD5();
		sb.append("msgId=2001&");
		sb.append("siteKey=");
		sb.append(ECS_263_SITEKEY);
		sb.append("&");
		sb.append("sitePwd=");
		sb.append(ECS_263_SITEPWD);
		sb.append("&");
		sb.append("userName=");
		sb.append(ECS_263_USERNAME);
		sb.append("&");
		sb.append("password=");
		sb.append(md5.toDigest(ECS_263_PASSWORD));
		sb.append("&");
		sb.append("conferenceInfo={");
		sb.append("\"conferenceName\":\"");
		try {
			sb.append(URLEncoder.encode(o.getConferenceName(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("\",");
		sb.append("\"reserveTime\":\"");
		sb.append(o.getReserveTime());
		sb.append("\",");
		sb.append("\"duration\":\"");
		sb.append(o.getDuration());
		sb.append("\",");
		sb.append("\"subAccount\":\"");
		try {
			sb.append(URLEncoder.encode(o.getSubAccount(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("\",");
		sb.append("\"netMeeting\":\"");
		sb.append(o.getNetMeeting());
		sb.append("\"}");
		return httpNet.sendPost(ECS263IP, sb.toString());
	}

	/**
	 * 查找会议
	 * 
	 * @param o
	 * @param hostPasscode
	 * @return
	 */
	public String selectMeet(String hostPasscode) {
		StringBuffer sb = new StringBuffer();
		MD5 md5 = new MD5();
		sb.append("msgId=2002&");
		sb.append("siteKey=");
		sb.append(ECS_263_SITEKEY);
		sb.append("&");
		sb.append("sitePwd=");
		sb.append(ECS_263_SITEPWD);
		sb.append("&");
		sb.append("userName=");
		sb.append(ECS_263_USERNAME);
		sb.append("&");
		sb.append("password=");
		sb.append(md5.toDigest(ECS_263_PASSWORD));
		sb.append("&");
		sb.append("hostPasscode=");
		sb.append(hostPasscode);
		return httpNet.sendPost(ECS263IP , sb.toString());
	}

	/**
	 * 修改会议
	 * 
	 * @param Meet263Entity
	 * @return
	 */
	public String updateMeet(ECS263Entity o, String hostPasscode) {
		StringBuffer sb = new StringBuffer();
		MD5 md5 = new MD5();
		sb.append("msgId=2003&");
		sb.append("siteKey=");
		sb.append(ECS_263_SITEKEY);
		sb.append("&");
		sb.append("sitePwd=");
		sb.append(ECS_263_SITEPWD);
		sb.append("&");
		sb.append("userName=");
		sb.append(ECS_263_USERNAME);
		sb.append("&");
		sb.append("password=");
		sb.append(md5.toDigest(ECS_263_PASSWORD));
		sb.append("&");
		sb.append("conferenceInfo={");
		sb.append("\"conferenceName\":\"");
		try {
			sb.append(URLEncoder.encode(o.getConferenceName(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("\",");
		sb.append("\"reserveTime\":\"");
		sb.append(o.getReserveTime());
		sb.append("\",");
		sb.append("\"duration\":\"");
		sb.append(o.getDuration());
		sb.append("\",");
		sb.append("\"subAccount\":\"");
		try {
			sb.append(URLEncoder.encode(o.getSubAccount() + "", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("\",");
		sb.append("\"hostPasscode\":\"");
		sb.append(hostPasscode);
		sb.append("\"}");
		return httpNet.sendPost(ECS263IP , sb.toString());
	}

	/**
	 * 撤销会议
	 * 
	 * @param o
	 * @param hostPasscode
	 * @return
	 */
	public String deleteMeet(String hostPasscode) {
		StringBuffer sb = new StringBuffer();
		MD5 md5 = new MD5();
		sb.append("msgId=2004&");
		sb.append("siteKey=");
		sb.append(ECS_263_SITEKEY);
		sb.append("&");
		sb.append("sitePwd=");
		sb.append(ECS_263_SITEPWD);
		sb.append("&");
		sb.append("userName=");
		sb.append(ECS_263_USERNAME);
		sb.append("&");
		sb.append("password=");
		sb.append(md5.toDigest(ECS_263_PASSWORD));
		sb.append("&");
		sb.append("hostPasscode=");
		sb.append(hostPasscode);
		return httpNet.sendPost(ECS263IP, sb.toString());
	}

	public String getKeyvalue(String contxt, String keyString) {
		JSONObject jsonObject;
		Map result = new HashMap();
		try {
			jsonObject = new JSONObject(contxt);
			Iterator iterator = jsonObject.keys();
			String key = null;
			String value = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				value = jsonObject.getString(key);
				result.put(key, value);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		if (result.containsKey(keyString)) {
			return result.get(keyString).toString();
		} else {
			return "";
		}

	}
	
	public static void main(String[] args) {
//		ECS263Entity o=new ECS263Entity();
//		o.setConferenceName("都很费劲的11");
//		o.setReserveTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
//		o.setDuration(10);
//		o.setSubAccount("是多少");
//		o.setNetMeeting(0);
//		String selectMeet = ECS263API.getInstance().createMeet(o);
////		String selectMeet = ECS263API.getInstance().selectMeet("15805216");
//////		String deleteMeet = ECS263API.getInstance().deleteMeet("52007693");
//		System.err.println(selectMeet);
	}
}
