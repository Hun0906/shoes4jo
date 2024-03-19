package com.multi.shoes4jo.util;

public class Criteria {

	// 현재 페이지
	private int page;
	// 한 페이지에 표시되는 게시물 수
	private int perPageNum;
	// 시작 행 번호
	private int rowStart;
	// 마지막 행 번호
	private int rowEnd;
	//검색	
	private String searchType;
	private String keyword;

	// 기본 생성자, 초기값 설정 (1페이지, 페이지당 10개 게시물)
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	// 페이지 설정 메서드 (음수는 1로 처리)
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	// 페이지당 게시물 수 설정 메서드 (0보다 작거나 100보다 큰 경우는 10으로 설정)
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	// 현재 페이지 반환 메서드
	public int getPage() {
		return page;
	}

	// 페이징 처리를 위한 시작 지점 계산 메서드
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	// 페이지당 게시물 수 반환 메서드
	public int getPerPageNum() {
		return this.perPageNum;
	}

	// 시작 행 번호 계산 메서드
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}

	// 마지막 행 번호 계산 메서드
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}

	//검색
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	// 객체 정보 출력용 메서드
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}

}
