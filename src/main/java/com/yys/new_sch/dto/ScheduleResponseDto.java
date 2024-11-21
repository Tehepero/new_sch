package com.yys.new_sch.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String workerName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String task, String workerName, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.task = task;
        this.workerName = workerName;
        this.createdAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
