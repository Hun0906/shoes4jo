package com.multi.shoes4jo.bookmark;

import java.util.List;

import com.multi.shoes4jo.util.Criteria;

public interface BookmarkService {

	public BookmarkVO check(String member_id, int gno);
	//북마크 체크

	public List<BookmarkVO> BookmarkList(String member_id, Criteria cri);
	//북마크 리스트(내 북마크 목록 조회, 페이징)

	public int listCount();
	//페이징

	public int insert(BookmarkVO vo);

	public int delete(int gno, String member_id);
	
	public List<BookmarkVO> getAllBookmarks(String member_id);
	//북마크 리스트 조회(페이징 안함)
}
