package com.cc.ccbackend.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserProficiency {
    @NonNull public UUID skillId;
    @NonNull public String name;
    @NonNull public int proficiency;
}
