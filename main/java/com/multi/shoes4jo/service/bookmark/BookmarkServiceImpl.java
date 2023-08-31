package com.multi.shoes4jo.service.bookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.BookmarkMapper;
import com.multi.shoes4jo.vo.BookmarkVO;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkMapper bookmarkMapper;

	
	@Override
	public BookmarkVO getcheck(int bookmark_no, String member_id) {
		return bookmarkMapper.check(bookmark_no, member_id);
	}

	@Override
	public List<BookmarkVO> getBookmarkList(String member_id) {
	    return bookmarkMapper.getBookmarkList(member_id);
	}

	@Override
	public void insert(BookmarkVO vo) {
		this.bookmarkMapper.insert(vo);
	}

	@Override
	public void delete(int bookmark_no, String member_id) {
		this.bookmarkMapper.delete(bookmark_no, member_id);
	}
}
