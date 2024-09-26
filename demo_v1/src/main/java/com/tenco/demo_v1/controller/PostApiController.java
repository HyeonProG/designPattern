package com.tenco.demo_v1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo_v1.dto.UserDTO;

import java.util.Map;

@RestController // IoC 대상
@RequestMapping("/post")
public class PostApiController {

    // 주소 설계
    // http://localhost:8080/post/demo1 Method - POST
    // 테스트 데이터 - {"name" : "둘리", "age" : 11}
    // return type - String
    @PostMapping("/demo1")
    // 사용자가 던진 데이터를 바인딩 처리 -> HTTP 메세지 바디 영역
    public String demo1(@RequestBody Map<String, Object> reqData) {
        // POST --> 리소스 취득, 생성 --> DB 접근기술 --> 영구히 데이터 저장
        StringBuffer sb = new StringBuffer();
        reqData.entrySet().forEach((entry) -> {
            sb.append(entry.getKey() + "=" + entry.getValue());
        });
        // 메세지 컨버터가 동작 (리턴 타입 = String)
        return sb.toString();
    }
    
    /**
     * 주소 설계
     * http://localhost:8080/post/demo2 Method - POST
     * @param 본문 - {"name" : "둘리", "age" : 11, "phone_number" : "010-1234-1234"}
     * @return JSON
     * [POST 요청에서 본문이 있다. RequestBody - Object로 파싱]
     * 테스트 - postman 활용
     * DTO 방식으로 데이터 내려보기
     * @RequestBody 생략 가능
     */

    @PostMapping("/demo2")
    public String demo2(@RequestBody UserDTO userDTO) {
        return userDTO.toString();
    }
    

}
