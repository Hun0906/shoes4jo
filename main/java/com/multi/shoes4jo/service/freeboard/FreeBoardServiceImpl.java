package com.multi.shoes4jo.service.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.FreeBoardMapper;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.CommentVO;
import com.multi.shoes4jo.vo.FreeBoardVO;

@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper mapper;

	@Override
	public List<FreeBoardVO> listPage(Criteria cri) {
		return mapper.listPage(cri);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public FreeBoardVO select(int fno) {
		return mapper.select(fno);
	}

	@Override
	public List<CommentVO> selectComment(int fno) {
		return mapper.selectComment(fno);
	}

    @Override
    public List<CommentVO> selectByIdComment(String member_id) {
        return mapper.selectByIdComment(member_id);
    }

    @Override
    public void updateviewcnt(int fno) {
        mapper.updateCount(fno);
    }

    @Override
    public void insert(FreeBoardVO vo) {
        Integer maxFno = mapper.maxfno();
        vo.setFno((maxFno == null) ? 1 : maxFno + 1);
        mapper.insert(vo);
    }

    @Override
    public int insertComment(CommentVO comment) {
        return mapper.insertComment(comment);
    }

   @Override
   public int deleteComment(int cno) {
       return mapper.deleteComment(cno);
   }

   @Override
   public void update(FreeBoardVO vo) { 
      	mapper.update(vo); 
   } 

   @Override 
   public void delete(int fno){ 
     	mapper.delete(fno); 
   } 

   @Override 
 	public List<FreeBoardVO> selectCat(String category){
 		return	mapper.selectCat(category);  
  } 

  @Override  
 	public List<FreeBoardVO> FreeListById(String member_id){
 		return	mapper.FreeListById(member_id);  
  }
}
