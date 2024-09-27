package com.tenco.demo_v1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo_v1.dto.CarUserDTO;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController // IoC(싱글톤 패턴으로 관리 됨)
public class PutApiController {

    /**
     * 주소 설계
     * http://localhost:8080/put/demo1/100
     * 
     * @return JSON
     */
    @PutMapping("/put/demo1/{id}")
    public CarUserDTO putMethodName(@PathVariable(name = "id") String id, 
                                @RequestBody CarUserDTO userDTO) {
        System.out.println("id : " + id);
        System.out.println("userDTO : " + userDTO.toString());
        // 메세지 컨버터 동작 (CarUserDTO) --> Json 반환을 해서 --> 클라이언트에 응답 처리
        return userDTO;
    }

    // @PutMapping("/put/demo1/{id}")
    // public CarUserDTO putMethodName(@PathVariable(name = "id") String id) {
    //     System.out.println("id : " + id);
    //     // System.out.println("userDTO : " + userDTO).toString();
    //     // 메세지 컨버터 동작 (CarUserDTO) --> Json 반환을 해서 --> 클라이언트에 응답 처리
    //     return null;
    // }

}