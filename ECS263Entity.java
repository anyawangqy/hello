package com.jiuxin.meeting.ecs263;

public class ECS263Entity {
	/**
	 * ��������(��������������Ҫͨ��URLEncoder�����UTF-8��ʽ)
	 */
	private String conferenceName;
	/**
	 * ԤԼ����,��ʽ:yyyy-MM-ddHH:mm:ss
	 */
	private String reserveTime;
	/**
	 * ����ʱ��,0-1440����λ�����ӣ�
	 */
	private int duration;
	/**
	 * ������Ϣ(��������������Ҫͨ��URLEncoder�����UTF-8��ʽ)
	 */
	private String subAccount;
	/**
	 * �Ƿ�����������, 1:����,0:������
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
