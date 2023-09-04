package com.multi.shoes4jo.service.bookmark;

import java.util.List;

import com.multi.shoes4jo.vo.BookmarkVO;

public interface BookmarkService {

    public BookmarkVO check(String member_id, int gno);

    public List<BookmarkVO> BookmarkList(String member_id);

    public int insert(BookmarkVO vo);

    public int delete(int gno, String member_id);
}

