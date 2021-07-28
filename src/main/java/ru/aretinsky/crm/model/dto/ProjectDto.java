package ru.aretinsky.crm.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDto {

    private long id;
    private String name;
    private int sum;
    private long customerId;
}
