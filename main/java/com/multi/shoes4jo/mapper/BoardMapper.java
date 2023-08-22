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

    @Select("SELECT * FROM 4jo_board where category = #{category} ORDER BY bno DESC limit 3")
    List<BoardVO> selectForMagazine(@Param("category") String category);

    @Select("SELECT * FROM 4jo_board WHERE category = #{category} ORDER BY bno DESC")
    List<BoardVO> selectOneCat(@Param("category") String category);

    @Select("SELECT * FROM 4jo_board WHERE bno = #{bno}")
    BoardVO select(@Param("bno") String bno);

    @Insert("INSERT INTO 4jo_board (bno, category, title, content, writer, file_name, file_path, link) VALUES (#{bno}, #{category}, #{title}, #{content}, #{writer}, #{file_name}, #{file_path}, #{link})")
    void insert(BoardVO board);

    @Update("UPDATE 4jo_board SET category = #{category}, title = #{title}, content = #{content}, file_name = #{file_name}, file_path = #{file_path}, link = #{link} WHERE bno = #{bno}")
    void update(BoardVO board);

    @Update("UPDATE 4jo_board SET viewcnt = viewcnt + 1 WHERE bno = #{bno}")
    void updateCount(@Param("bno") String bno);

    @Delete("DELETE FROM 4jo_board WHERE bno = #{bno}")
    void delete(@Param("bno") String bno);

    @Select("SELECT MAX(bno) FROM 4jo_board")
    Integer maxBno();
}

