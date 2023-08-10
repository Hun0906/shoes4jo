package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkK {
<<<<<<< HEAD
		private int bookmark_id;
		private String member_id;
		private String start_date;
		private String end_date;
		private String time_unit;
		private String keywords;
		private String device;
		private String gender;
		private String ages;
		private String add_date;
	}

=======
		private int BookMarkID;
		private String MemberID;
		private String StartDate;
		private String EndDate;
		private String TimeUnit;
		private String Keywords;
		private String Device;
		private String Gender;
		private String Ages;
		private String AddDate;
	}



/* @Component 어노테이션은 스프링 프레임워크에서 사용되며, 클래스를 스프링 빈으로 등록하고, 빈의 이름을 지정하는 역할
*(빈 이름은 다른 빈들이 해당 컴포넌트에 의존성 주입을 요청할 때 사용)
*
* @Data: 클래스에 이 어노테이션을 사용하면 자동으로 getter,setter,toString(), equals() 및 hashCode() 메서드 생성
* 
* @NoArgsConstructor: 인자가 없는 기본 생성자를 자동으로 생성
* 
* @AllArgsConstructor: 모든 필드 값을 인자로 갖는 생성자를 자동으로 생성. 클래스의 모든 멤버 변수를 초기화
*/
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
