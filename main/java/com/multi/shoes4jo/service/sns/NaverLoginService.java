package com.multi.shoes4jo.service.sns;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.SnsLoginlMapper;
import com.multi.shoes4jo.vo.SnsVO;

@Service
public class NaverLoginService {

	@Autowired
	private SnsLoginlMapper mapper;

	public void login(SnsVO vo, HttpSession session) {
		SnsVO existingUser = mapper.connect(vo.getSns_id());

		if (existingUser == null) {
			mapper.insert(vo.getSns_id(), vo.getSns_type(), vo.getSns_name(), vo.getSns_profile());

			existingUser = vo;
		}

		// existingUser로부터 값을 얻음
		session.setAttribute("sns_id", existingUser.getSns_id());
		session.setAttribute("sns_type", existingUser.getSns_type());
		session.setAttribute("sns_name", existingUser.getSns_name());
		session.setAttribute("sns_profile", existingUser.getSns_profile());   
	}
}
