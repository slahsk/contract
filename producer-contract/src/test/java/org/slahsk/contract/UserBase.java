package org.slahsk.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slahsk.contract.domain.Address;
import org.slahsk.contract.domain.User;
import org.slahsk.contract.service.UserService;
import org.slahsk.contract.web.UserController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class UserBase {

    @MockBean
    UserService userService;

    @BeforeEach
    void setup(){
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(new UserController(userService));
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);

        getUser();
    }

    public void getUser(){
        Address address = Address.builder().id(600L).address("서울시").message("다 내땅").build();
        User user = User.builder().id(1L).name("홍길동").email("my@email.com").address(address).build();

        Mockito.when(userService.get(Mockito.anyLong())).thenReturn(user);
    }
}
