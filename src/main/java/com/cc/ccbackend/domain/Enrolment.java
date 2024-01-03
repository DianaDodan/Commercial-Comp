package com.cc.ccbackend.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Enrolment {

    @NonNull private UUID employeeId;
    @NonNull private UUID programmeId;
}
