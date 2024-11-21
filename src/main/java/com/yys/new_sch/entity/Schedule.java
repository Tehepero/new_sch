package com.yys.new_sch.entity;

import java.time.LocalDateTime;

public class Schedule {
    // 할일, 작성자명, 비밀번호, 작성일, 수정일
    private Long id;
    private String task;
    private String workerName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
