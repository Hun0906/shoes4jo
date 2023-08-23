package com.multi.shoes4jo.command;

public class PageInfo {
	private int currentPage;

	private int pageLimit;

	private int listCount;

	private int listLimit;

	/**
	 * @param currentPage 현재 페이지
	 * @param pageLimit   한 페이지에 보여질 페이지의 수
	 * @param listCount   전체 리스트의 수
	 * @param listLimit   한 페이지에 표시될 리스트의 수
	 */
	public PageInfo(int currentPage, int pageLimit, int listCount, int listLimit) {
	    this.pageLimit = pageLimit;
	    this.listCount = listCount;
	    this.listLimit = listLimit;
	    this.currentPage = currentPage;
	    this.currentPage = validateCurrentPage(currentPage);
	}


	/**
	 * @return 전체 페이지 중 가장 마지막 페이지
	 */
	public int getMaxPage() {

		return (int) Math.ceil((double) this.listCount / this.listLimit);
	}

	/**
	 * @return 페이징 된 페이지 중 시작 페이지
	 */
	public int getStart() {

		return (this.pageLimit * ((this.currentPage - 1) / this.pageLimit)) + 1;
	}

	/**
	 * @return 페이징 된 페이지 중 마지막 페이지
	 */
	public int getEnd() {

		int endPage = getStart() + this.pageLimit - 1;

		return endPage > getMaxPage() ? getMaxPage() : endPage;
	}

	/**
	 * @return 이전 페이지
	 */
	public int getPrevPage() {
		int prevPage = this.getCurrentPage() - 1;

		return prevPage < 1 ? 1 : prevPage;
	}

	/**
	 * @return 다음 페이지
	 */
	public int getNextPage() {
		int nextPage = this.getCurrentPage() + 1;

		return nextPage > getMaxPage() ? getMaxPage() : nextPage;
	}


	public int getListLimit() {
		return listLimit;
	}

	public int getCurrentPage() {
	    return currentPage;
	}
	
	public int getListCount() {
	    return listCount;
	}
	
	
	private int validateCurrentPage(int currentPage) {
	    if (currentPage < 1) {
	        return 1;
	    }

	    int maxPage = getMaxPage();
	    if (currentPage > maxPage) {
	        return maxPage;
	    }

	    return currentPage;
	}
	   
	    /**
	     * @return 현재 페이지의 시작 글 인덱스
	     */
	    public int getStartIndex() {
	        return (this.currentPage - 1) * this.listLimit;
	    }

	    /**
	     * @return 현재 페이지의 마지막 글 인덱스
	     */
	    public int getEndIndex() {
	        return Math.min(this.listCount, this.currentPage * this.listLimit);
	    }
	    
	    

	    public void displayPageInfo() {
	        int maxPage = getMaxPage();
	        int startPage = getStart();
	        int endPage = getEnd();
	        int prevPage = getPrevPage();
	        int nextPage = getNextPage();
	        int startIndex = getStartIndex();
	        int endIndex = getEndIndex();

	        System.out.println("최대 페이지 : " + maxPage);
	        System.out.println("시작 페이지 : " + startPage);
	        System.out.println("마지막 페이지 : " + endPage);
	        System.out.println("이전 페이지 : " + prevPage);
	        System.out.println("다음 페이지 : " + nextPage);
	        System.out.println("시작 글 인덱스 : " + startIndex);
	        System.out.println("마지막 글 인덱스 : " + endIndex);
	    }
	}
