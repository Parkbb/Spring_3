package com.iu.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage=1;
		}
		
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	public Pager() {
		perPage=10;
	}
	
	public void makePager(int totalCount) {
		
		int totalPage = totalCount / perPage;
		if(totalCount % perPage != 0) {
			totalPage++;
		}
	}
	
	public RowMaker makeRow() {
		
		int startRow = (this.getCurPage()-1)*perPage +1;
		int lastRow = (this.getCurPage())*perPage;
		
		RowMaker rowMaker = new RowMaker();
		
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
		
	}
	
}
