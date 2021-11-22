package org.slahsk.contract.web;

import lombok.RequiredArgsConstructor;
import org.slahsk.contract.domain.Address;
import org.slahsk.contract.domain.User;
import org.slahsk.contract.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        return ResponseEntity.ok(userService.get(id));
    }
}
