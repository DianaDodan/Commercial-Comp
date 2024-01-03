package com.cc.ccbackend.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Proficiency {

    @NonNull private UUID employeeId;
    @NonNull private List<SkillProficiency> skillProficiencies;
}
