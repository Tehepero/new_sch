package com.yys.new_sch.service;

import  com.yys.new_sch.dto.ScheduleRequestDto;
import  com.yys.new_sch.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    List<ScheduleResponseDto> findAll(String workerName, String modifiedDate);

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto);

    void deleteSchedule(Long id, String password);

    ScheduleResponseDto updateSchedule(Long id, String task, String workerName, String password);
}
