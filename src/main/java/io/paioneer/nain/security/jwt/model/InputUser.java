package io.paioneer.nain.security.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputUser { //로그인한 데이터를 가진 객체
    private String username, password;

    public void getUserid(String username) {
        this.username = username;
    }
}
