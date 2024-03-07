package com.playground.pgapp.transactional;

import com.playground.pgapp.util.PgJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
class UsersDaoImpl extends PgJdbcTemplate implements UsersDao {
    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users (first_name, last_name, age) values (?,?,?)",
                new Object[] {user.getFirstName(), user.getLastName(), user.getAge()},
                new int[] {Types.VARCHAR, Types.VARCHAR, Types.BIGINT});
    }
}
