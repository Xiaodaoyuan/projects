package com.xiaody.application.model.vo;

public class Page {
	/**
	 * ÿҳ��ʾ����
	 */
	private int pageSize = 10;
	/**
	 * ��ǰ�ڼ�ҳ
	 */
	private int pageNo = 1;
	/**
	 * ��ҳ��
	 */
	private int pageTotal;
	/**
	 * ������
	 */
	private int totalNum;

	@SuppressWarnings("unused")
	private int pageStart;

	public int getPageStart() {
		return pageSize * (pageNo - 1);
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

}
