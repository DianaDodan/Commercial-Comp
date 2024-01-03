package com.cc.ccbackend.domain.request;

import lombok.*;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TrainingSkillsProficiencyRequest {
    private final UUID employeeId;
    private final UUID programmeId;
}
