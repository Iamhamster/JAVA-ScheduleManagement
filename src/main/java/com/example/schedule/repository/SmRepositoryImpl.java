package com.example.schedule.repository;

import com.example.schedule.entity.ScheduleManagement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SmRepositoryImpl implements SmRepository {
    private final JdbcTemplate jdbcTemplate;

    public SmRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleManagement save(ScheduleManagement sm) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into schedule(name, pw, todo, createDate, updateDate) values(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, sm.getName());
            ps.setString(2, sm.getPw());
            ps.setString(3, sm.getTodo());
            ps.setTimestamp(4, Timestamp.valueOf(sm.getCreateTime()));
            ps.setTimestamp(5, Timestamp.valueOf(sm.getUpdateTime()));
            return ps;
        }, keyHolder);

        sm.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        return sm;
    }

    @Override
    public Optional<ScheduleManagement> findById(Long id) {
        List<ScheduleManagement> sms = jdbcTemplate.query(
                "select * from schedule where id = ?",
                (rs, rowNum) -> new ScheduleManagement(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("pw"),
                        rs.getString("todo"),
                        rs.getTimestamp("createDate").toLocalDateTime(),
                        rs.getTimestamp("updateDate").toLocalDateTime()),
                id
        );

        return sms.stream().findAny();
    }

    @Override
    public List<ScheduleManagement> findAll() {
        return jdbcTemplate.query(
                "select * from schedule order by updateDate desc",
                (rs, rowNum) ->
                        new ScheduleManagement(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("todo"),
                                rs.getTimestamp("createDate").toLocalDateTime(),
                                rs.getTimestamp("updateDate").toLocalDateTime())
        );
    }

    @Override
    public ScheduleManagement update(Long id, String name, String todo, LocalDateTime updateTime) {
        jdbcTemplate.update(
                "update schedule set name = ?, todo = ?, updateDate = ? where id = ?",
                name,
                todo,
                updateTime,
                id
        );

        return jdbcTemplate.queryForObject(
                "select * from schedule where id = ?",
                (rs, rowNum) -> new ScheduleManagement(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getTimestamp("createDate").toLocalDateTime(),
                        rs.getTimestamp("updateDate").toLocalDateTime()),
                id
        );
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(
                "delete from schedule where id = ?",
                id
        );
    }
}
