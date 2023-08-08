package com.multi.shoes4jo.mail;

import java.util.Random;

//인증번호 보낼 클래스, 몇 자리 수로 할 건지 사이즈를 파라미터로 보냄
//member테이블에서 mail_key에는 TempKey.java에서 생성한 난수 저장
//member테이블에서 mail_auth는 기본값 0, 이메일 인증 성공 시 1로 변경해 로그인 성공하게 함
// 임 시 보 관
public class TempKey{
    private boolean lowerCheck;
    private int size;

    public String getKey(int size, boolean lowerCheck) {
        this.size = size;
        this.lowerCheck = lowerCheck;
        return init();
    }

    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num  = 0;
        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }
        } while (sb.length() < size);
        if (lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }
}