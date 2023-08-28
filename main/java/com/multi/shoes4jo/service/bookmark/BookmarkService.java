package com.multi.shoes4jo.service.bookmark;

import java.util.List;

import com.multi.shoes4jo.vo.BookmarkVO;

public interface BookmarkService {

	List<BookmarkVO> getselectAll();

	BookmarkVO getselectOne(int bookmark_no);

	void insert(BookmarkVO vo);

	void delete(int bookmark_no);
}
