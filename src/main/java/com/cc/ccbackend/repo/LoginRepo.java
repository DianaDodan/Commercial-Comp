package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.exception.UsernameNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LoginRepo {
    private final JdbcTemplate jdbcTemplate;

    public void createLogin(Login login, String salt) {
        jdbcTemplate.update("insert into auth (username,password,salt) values (?,?,?)",
            login.getUsername(),login.getPassword(),salt);
    }

    public Login authenticate(String username) {
        try{
            return jdbcTemplate.queryForObject("select * from auth where username = ?",
                new BeanPropertyRowMapper<>(Login.class),
                username);
        } catch (DataAccessException e) {
            throw new UsernameNotFoundException(username);
        }

    }
}
