package com.tenco.demo_v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@RestController // IoC -> @Controller + @ResponseBody
// @RequestMapping("/xxxx"); 대문 달기
public class GetApiController {

    // 주소설계 : http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        // 메시지 컨버터가 동작 한다.
        // = StringHttpMessageConverter 객체가 동작
        return "Say Hello~";
    }

    // 쿼리스트링 방식(@RequestParam)
    // 주소설계 : http://localhost:8080/qs1?name=홍길동
    @GetMapping("qs1")
    public String qs1(@RequestParam(name="name") String name) {
        return "name=" + name;
    }
    
    // 쿼리스트링 방식(@RequestParam)
    // 주소설계 : http://localhost:8080/qs2?name=홍길동&age=20
    @GetMapping("qs2")
    public String qd2(@RequestParam(name="name") String name, 
                      @RequestParam(name="age", required = false, defaultValue = "1") Integer age) {
        return "name=" + name + " : age=" + age;
    }
    
    // 쿼리스트링 방식(@RequestParam)
    // 주소설계 : http://localhost:8080/qs3?name=홍길동&age=20&groupId=com.tenco
    @GetMapping("qs3")
    public String qd3(@RequestParam Map<String, String> data) {
        // Map 방식으로 동적으로 데이터 바인딩 하기
        StringBuffer sb = new StringBuffer();
        data.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
            sb.append(entry.getKey() + "=" + entry.getValue());
        });
        return sb.toString();
    }

    // 쿼리스트링 방식(@RequestParam)
    // 주소설계 : http://localhost:8080/qs4?name=홍길동&age=20&groupId=com.tenco
    // @GetMapping("/qs4")
    // public String qs4(User user) {
    //     // 메세지 컨버터
    //     return user.toString();
    // }

    // json 으로 응답을 내리고 싶다면
    @GetMapping("/qs4")
    public User qs4(User user) {
        // 메세지 컨버터
        return user;
    }
    
    // 클래스
    @AllArgsConstructor
    @Getter
    @ToString
    class User {
        private String name;
        private String age;
    }

}
