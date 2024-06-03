//package io.paioneer.nain.member.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.paioneer.nain.NainProjectApplication;
//import io.paioneer.nain.member.model.dto.MemberDto;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= NainProjectApplication.class)
//@AutoConfigureMockMvc
//public class LoginControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    WebApplicationContext context;
//
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(this.context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @Test
//    //@WithMockUser(username="user01", password = "pass01", roles= "USER")
//    public void testLogin() throws Exception {
//        MemberDto loginUser = new MemberDto();
//        loginUser.setmemberEmail("memberEmail");
//        loginUser.setmemberPwd("memberPwd");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String loginRequestJson = objectMapper.writeValueAsString(loginUser);
//
//        mockMvc.perform(post("/api/auth/login")
//                        .content(loginRequestJson)
//                        .contentType(MediaType.APPLICATION_JSON)
//                ) //1. mockMvc 통해 post 메소드 실행
//                .andDo(print())//3. 결과 프린트
//                .andExpect(status().isOk()); //2. status 코드 값이 ok가 되었을 때
//    }
//
//
//
//
//}