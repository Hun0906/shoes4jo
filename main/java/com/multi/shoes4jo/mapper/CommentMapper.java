package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.multi.shoes4jo.freeboard.CommentVO;

@Mapper
public interface CommentMapper {

	@Insert("insert into comment (cno, fno, content, member_id, date) values (#{cno}, #{fno}, #{content}, #{member_id}, NOW())")
	public int insert(CommentVO vo);

    @Select("select count(*) from comment where fno=#{fno}")
    public int getTotal(int fno);

    @Select("SELECT * FROM comment where fno = #{fno}")
    public List<CommentVO> commentList(int fno);

    @Select("SELECT * FROM comment WHERE member_id=#{member_id}")
    public List<CommentVO> myComment(String member_id);

    @Update("UPDATE comment SET content=#{content}, update_date=NOW() WHERE cno=#{cno}")
    public int update(CommentVO vo);

	@Delete("DELETE FROM comment where cno=#{cno}")
	public int delete(int cno);

}
