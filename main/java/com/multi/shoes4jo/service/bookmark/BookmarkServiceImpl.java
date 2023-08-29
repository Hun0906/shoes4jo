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
	public List<BookmarkVO> getselectAll() {
		return bookmarkMapper.selectAll();
	}

	@Override
	public BookmarkVO getselectOne(int bookmark_no) {
		return bookmarkMapper.selectOne(bookmark_no);
	}

	@Override
	public void insert(BookmarkVO vo) {
		this.bookmarkMapper.insert(vo);
	}


	@Override
	public void delete(int bookmark_no) {
		this.bookmarkMapper.delete(bookmark_no);
	}
}
