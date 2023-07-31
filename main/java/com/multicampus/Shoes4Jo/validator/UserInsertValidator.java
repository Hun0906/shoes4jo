/*
 * package kr.co.dinner41.validator;
 * 
 * import org.springframework.validation.Errors; import
 * org.springframework.validation.Validator;
 * 
 * import kr.co.dinner41.command.UserInsertCommand;
 * 
 * public class UserInsertValidator implements Validator {
 * 
 * @Override public boolean supports(Class<?> clazz) { return
 * UserInsertCommand.class.isAssignableFrom(clazz); }
 * 
 * @Override public void validate(Object target, Errors errors) {
 * UserInsertCommand user=(UserInsertCommand)target; String
 * email=user.getEmail(); String password=user.getPassword(); String
 * passwordConfirm=user.getPasswordConfirm(); String name=user.getName(); String
 * address=user.getAddress(); String subAddress=user.getSubAddress(); String
 * phone1=user.getPhone1(); String phone2=user.getPhone2(); String
 * phone3=user.getPhone3(); String type=user.getType();
 * if(email.trim().equals("")) { errors.rejectValue("email",
 * "eamil:required","�씠硫붿씪�쓣 �엯�젰�빐二쇱꽭�슂"); } if(password.trim().equals("")) {
 * errors.rejectValue("password", "password:required","鍮꾨�踰덊샇瑜� �엯�젰�빐二쇱꽭�슂"); }
 * if(passwordConfirm.trim().equals("")) { errors.rejectValue("passwordConform",
 * "passwordConfirm:required","鍮꾨�踰덊샇�솗�씤�쓣 �엯�젰�빐二쇱꽭�슂"); }
 * if(name.trim().equals("")) { errors.rejectValue("name",
 * "name:required","�씠由꾩쓣 �엯�젰�빐二쇱꽭�슂"); } if(address.trim().equals("")) {
 * errors.rejectValue("address", "address:required","二쇱냼瑜�  �엯�젰�빐二쇱꽭�슂"); }
 * if(subAddress.trim().equals("")) { errors.rejectValue("subAddress",
 * "subAddress:required","鍮꾨�踰덊샇�솗�씤�쓣 �엯�젰�빐二쇱꽭�슂"); }
 * if(phone1.trim().equals("")) { errors.rejectValue("phone1",
 * "phone1:required","�쟾�솕 踰덊샇 �븵 �꽭�옄由щ�� �엯�젰�빐二쇱꽭�슂"); }
 * if(phone2.trim().equals("")) { errors.rejectValue("phone2",
 * "phone2:required","�쟾�솕踰덊샇 以묎컙 �꽕�옄由щ�� �엯�젰�빐二쇱꽭�슂"); }
 * if(phone3.trim().equals("")) { errors.rejectValue("phone3",
 * "phone3:required","�쟾�솕踰덊샇 留덉�留� �꽕�옄由щ�� �엯�젰�빐二쇱꽭�슂"); }
 * if(type.equals("")) { errors.rejectValue("type", "type:required",
 * "�쉶�썝 �쑀�삎�쓣 �엯�젰�븯�꽭�슂"); } }
 * 
 * }
 */