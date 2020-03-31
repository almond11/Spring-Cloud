package com.user.project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.project.exceptions.ResourceNotFoundException;
import com.user.project.model.User;

@Repository
public class JDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper < User > {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId((int) rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setAddress(rs.getString("address"));
            user.setEmailId(rs.getString("email_address"));
            return user;
        }
    }

    public List < User > findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    public  User findById(Long id) {
    
    		return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] {
                    id
                },
                new BeanPropertyRowMapper < User > (User.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from users where id=?", new Object[] {
            id
        });
    }

    public int insert(User user) {

        return jdbcTemplate.update("insert into users (id, first_name, last_name, email_address, address) " + "values(?, ?, ?, ?,?)",
            new Object[] {
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmailId(),user.getAddress()
            });
    }

 
    }
