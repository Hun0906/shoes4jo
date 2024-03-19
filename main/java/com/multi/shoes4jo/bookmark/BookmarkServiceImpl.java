package com.multi.shoes4jo.bookmark;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.BookmarkMapper;
import com.multi.shoes4jo.util.Criteria;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkMapper mapper;

	@Override
	public BookmarkVO check(String member_id, int gno) {
		return mapper.check(member_id, gno);
	}

	@Override
	public List<BookmarkVO> BookmarkList(String member_id, Criteria cri) {
	    return mapper.BookmarkList(member_id, cri);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}
	
	@Override
	public List<BookmarkVO> getAllBookmarks(String member_id) {
	    return mapper.getAllBookmarks(member_id);
	}
	//페이징 안한 북마크 리스트

	@Override
	public int insert(BookmarkVO vo) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(new Date());

		vo.setAdd_date(dateString);

		if (this.check(vo.getMember_id(), vo.getGno()) != null) {
			this.delete(vo.getGno(), vo.getMember_id());
			return -1;
		}

		this.mapper.insert(vo);

		return 1;
	}

	@Override
	public int delete(int gno, String member_id) {
		return this.mapper.delete(gno, member_id);
	}
}