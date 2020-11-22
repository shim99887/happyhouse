package com.ssafy.happyhouse.model;

public class CoronaDto {
	private String totalCnt;
	private String todayCnt;
	private String todayFromKorea;
	private String todayFromAbroad;
	private String freeTotal;
	private String todayFree;
	private String coronaTotal;
	private String coronaToday;
	private String deadTotal;
	private String deadToday;
	@Override
	public String toString() {
		return "CoronaDto [totalCnt=" + totalCnt + ", todayCnt=" + todayCnt + ", todayFromKorea=" + todayFromKorea
				+ ", todayFromAbroad=" + todayFromAbroad + ", freeTotal=" + freeTotal + ", todayFree=" + todayFree
				+ ", coronaTotal=" + coronaTotal + ", coronaToday=" + coronaToday + ", deadTotal=" + deadTotal
				+ ", deadToday=" + deadToday + "]";
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
	public String getCoronaTotal() {
		return coronaTotal;
	}
	public void setCoronaTotal(String coronaTotal) {
		this.coronaTotal = coronaTotal;
	}
	public String getCoronaToday() {
		return coronaToday;
	}
	public void setCoronaToday(String coronaToday) {
		this.coronaToday = coronaToday;
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
