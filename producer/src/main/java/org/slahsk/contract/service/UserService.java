package org.slahsk.contract.service;

import org.slahsk.contract.domain.Address;
import org.slahsk.contract.domain.User;

public class UserService {

    public User get(Long id){

        if(id == 1L){
            Address address = Address.builder().id(500L).address("서울시").message("다 내땅").build();
            User user = User.builder().id(1L).name("홍길동").email("test@email.com").address(address).build();

            return user;
        }

        return null;
    }

}
