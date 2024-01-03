package com.cc.ccbackend.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SkillProficiency {

    @NonNull private UUID skillId;
    @NonNull private int proficiencyLevel;
}
