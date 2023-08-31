package com.multi.shoes4jo.service.bookmark;

import java.util.List;

import com.multi.shoes4jo.vo.BookmarkVO;

public interface BookmarkService {

	public BookmarkVO getcheck(int bookmark_no, String member_id);
	
	public List<BookmarkVO> getBookmarkList(String member_id);
	//본인 아이디의 북마크 전체 조회

	public void insert(BookmarkVO vo);

	public void delete(int bookmark_no, String member_id);
}
