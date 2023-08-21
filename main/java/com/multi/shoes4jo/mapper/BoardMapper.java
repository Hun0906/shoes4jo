package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.multi.shoes4jo.vo.BoardVO;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM 4jo_board ORDER BY bno DESC")
    List<BoardVO> selectAll();

    @Select("SELECT * FROM 4jo_board where category = 'news' ORDER BY bno DESC limit 3")
    List<BoardVO> selectNews();
    
    @Select("SELECT * FROM 4jo_board where category = 'events' ORDER BY bno DESC limit 3")
    List<BoardVO> selectEvents();
    
    @Select("SELECT * FROM 4jo_board where category = 'columns' ORDER BY bno DESC limit 3")
    List<BoardVO> selectColumns();
    
    @Select("SELECT * FROM 4jo_board WHERE category = #{category} ORDER BY bno DESC")
    List<BoardVO> selectOneCat(@Param("category") String category);

    @Select("SELECT * FROM 4jo_board WHERE bno = #{bno}")
    BoardVO select(@Param("bno") String bno);

    @Insert("INSERT INTO 4jo_board (category, title, content, writer, file, link) VALUES (#{category}, #{title}, #{content}, #{writer}, #{file}, #{link})")
    void insert(BoardVO board);

    @Update("UPDATE 4jo_board SET category = #{category}, title = #{title}, content = #{content}, file = #{file}, link = #{link} WHERE bno = #{bno}")
    void update(BoardVO board);

    @Update("UPDATE 4jo_board SET viewcnt = viewcnt + 1 WHERE bno = #{bno}")
    void updateCount(@Param("bno") String bno);

    @Delete("DELETE FROM 4jo_board WHERE bno = #{bno}")
    void delete(@Param("bno") String bno);
}
