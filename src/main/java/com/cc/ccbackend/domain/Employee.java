package com.cc.ccbackend.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private UUID id;
    @NonNull private String name;
    @NonNull private Role role;

    public enum Role {
        MANAGER,
        SUPERVISOR,
        TRAINEE;
    }
}
