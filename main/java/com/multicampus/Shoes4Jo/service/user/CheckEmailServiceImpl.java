/*
 * package kr.co.dinner41.service.user;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.stereotype.Service;
 * 
 * import kr.co.dinner41.dao.UserDao; import
 * kr.co.dinner41.exception.login.UserNotFoundException; import
 * kr.co.dinner41.exception.user.UserException; import kr.co.dinner41.vo.UserVO;
 * 
 * @Service("checkEmailService") public class CheckEmailServiceImpl implements
 * CheckEmailService {
 * 
 * @Autowired
 * 
 * @Qualifier("userDao") private UserDao userDao;
 * 
 * @Override public UserVO execute(String email) throws UserException {
 * System.out.println("�떆�뒪�뀥 吏꾩엯"); UserVO user=userDao.selectByEmail(email);
 * if(user==null) { throw new
 * UserNotFoundException("�빐�떦�븯�뒗 �씠硫붿씪�쓣 媛�吏��뒗 �쉶�썝�씠 議댁옱�븯吏� �븡�뒿�땲�떎."); }
 * System.out.println(user.getEmail());
 * 
 * return user; }
 * 
 * }
 */