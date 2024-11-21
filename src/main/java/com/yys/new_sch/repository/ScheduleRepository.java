package com.yys.new_sch.repository;

import com.yys.new_sch.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {
    List<ScheduleResponseDto> findAll(String workerName, String modifiedDate);
}
