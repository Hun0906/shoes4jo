package com.multi.shoes4jo.bookmark;

import java.util.List;

public interface BookmarkService {

    public BookmarkVO check(String member_id, int gno);

    public List<BookmarkVO> BookmarkList(String member_id);

    public int insert(BookmarkVO vo);

    public int delete(int gno, String member_id);
}

