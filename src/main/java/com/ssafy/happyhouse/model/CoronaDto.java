package com.ssafy.happyhouse.model;

public class CoronaDto {
	private String totalCnt;
	private String todayCnt;
	private String todayFromKorea;
	private String todayFromAbroad;
	private String freeTotal;
	private String todayFree;
	private String isolateTotal;
	private String isolateToday;
	private String deadTotal;
	private String deadToday;

	
	
	@Override
	public String toString() {
		return "CoronaDto [totalCnt=" + totalCnt + ", todayCnt=" + todayCnt + ", todayFromKorea=" + todayFromKorea
				+ ", todayFromAbroad=" + todayFromAbroad + ", freeTotal=" + freeTotal + ", todayFree=" + todayFree
				+ ", isolateTotal=" + isolateTotal + ", isolateToday=" + isolateToday + ", deadTotal=" + deadTotal
				+ ", deadToday=" + deadToday + "]";
	}
	public String getIsolateTotal() {
		return isolateTotal;
	}
	public void setIsolateTotal(String isolateTotal) {
		this.isolateTotal = isolateTotal;
	}
	public String getIsolateToday() {
		return isolateToday;
	}
	public void setIsolateToday(String isolateToday) {
		this.isolateToday = isolateToday;
	}
	public String getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	public String getTodayCnt() {
		return todayCnt;
	}
	public void setTodayCnt(String todayCnt) {
		this.todayCnt = todayCnt;
	}
	public String getTodayFromKorea() {
		return todayFromKorea;
	}
	public void setTodayFromKorea(String todayFromKorea) {
		this.todayFromKorea = todayFromKorea;
	}
	public String getTodayFromAbroad() {
		return todayFromAbroad;
	}
	public void setTodayFromAbroad(String todayFromAbroad) {
		this.todayFromAbroad = todayFromAbroad;
	}
	public String getFreeTotal() {
		return freeTotal;
	}
	public void setFreeTotal(String freeTotal) {
		this.freeTotal = freeTotal;
	}
	public String getTodayFree() {
		return todayFree;
	}
	public void setTodayFree(String todayFree) {
		this.todayFree = todayFree;
	}
	public String getDeadTotal() {
		return deadTotal;
	}
	public void setDeadTotal(String deadTotal) {
		this.deadTotal = deadTotal;
	}
	public String getDeadToday() {
		return deadToday;
	}
	public void setDeadToday(String deadToday) {
		this.deadToday = deadToday;
	}
	
	
}
