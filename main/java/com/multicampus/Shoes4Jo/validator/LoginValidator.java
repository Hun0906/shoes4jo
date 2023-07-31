/*
 * package kr.co.dinner41.validator;
 * 
 * import org.springframework.validation.Errors; import
 * org.springframework.validation.Validator;
 * 
 * import kr.co.dinner41.command.LoginCommand;
 * 
 * public class LoginValidator implements Validator {
 * 
 * @Override public boolean supports(Class<?> clazz) { return
 * clazz.isAssignableFrom(LoginCommand.class); }
 * 
 * @Override public void validate(Object target, Errors errors) { LoginCommand
 * login=(LoginCommand)target; String email=login.getEmail(); String
 * password=login.getPassword(); if(email==null||email.trim().equals("")) {
 * errors.rejectValue("email",
 * "email:required","硫붿씪二쇱냼媛� �엯�젰�릺吏� �븡�븯�뒿�땲�떎."); }
 * if(password==null||password.trim().equals("")) {
 * errors.rejectValue("password",
 * "password:required","鍮꾨�踰덊샇媛� �엯�젰�릺吏� �븡�븯�뒿�땲�떎."); } }
 * 
 * }
 */