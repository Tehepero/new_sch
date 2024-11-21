package com.yys.new_sch.repository;

import com.yys.new_sch.dto.ScheduleResponseDto;
import com.yys.new_sch.entity.Schedule;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ScheduleResponseDto> findAll(String workerName, String modifiedDate) {
        // 전체 조회하는 쿼리 정의
        return List.of();

        StringBuilder query = new StringBuilder("SELECT * FROM schedule WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (workerName != null) {
            query.append(" AND worker_name = ?");
            params.add(workerName);
        }

        if (modifiedDate != null) {
            query.append(" AND DATE_FORMAT(modified_at, '%Y-%m-%d') = ?)");
            params.add(modifiedDate);
        }

        query.append(" ORDER BY modified_at DESC");

        return jdbcTemplate.query(query.toString(), params.toArray(), scheduleRowMapper());
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("task"),
                        rs.getString("worker_name"),
                        rs.getObject("created at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class)
                );
            }
        }
    }
}
