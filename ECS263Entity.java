package com.jiuxin.meeting.ecs263;

public class ECS263Entity {
	/**
	 * 会议主题(参数包含中文需要通过URLEncoder编码成UTF-8格式)
	 */
	private String conferenceName;
	/**
	 * 预约日期,格式:yyyy-MM-ddHH:mm:ss
	 */
	private String reserveTime;
	/**
	 * 会议时长,0-1440（单位：分钟）
	 */
	private int duration;
	/**
	 * 分账信息(参数包含中文需要通过URLEncoder编码成UTF-8格式)
	 */
	private String subAccount;
	/**
	 * 是否开启会议语音, 1:开启,0:不开启
	 */
	private int netMeeting;

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}

	public int getNetMeeting() {
		return netMeeting;
	}

	public void setNetMeeting(int netMeeting) {
		this.netMeeting = netMeeting;
	}

}
