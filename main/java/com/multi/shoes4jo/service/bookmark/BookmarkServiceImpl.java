package com.multi.shoes4jo.service.bookmark;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public BookmarkVO check(String member_id, int gno) {
		return bookmarkMapper.check(member_id, gno);
	}

	@Override
	public List<BookmarkVO> BookmarkList(String member_id) {
		return bookmarkMapper.BookmarkList(member_id);
	}

	@Override
	public int insert(BookmarkVO vo) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(new Date());

		vo.setAdd_date(dateString);

		if (this.check(vo.getMember_id(), vo.getGno()) != null) {
			this.delete(vo.getGno(), vo.getMember_id());
			return -1;
		}

		this.bookmarkMapper.insert(vo);

		return 1;
	}

	@Override
	public int delete(int gno, String member_id) {
		return this.bookmarkMapper.delete(gno, member_id);
	}
}