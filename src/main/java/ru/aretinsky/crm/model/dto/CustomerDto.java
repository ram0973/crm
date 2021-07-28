package ru.aretinsky.crm.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDto {

    private long id;
    private String firstName;
    private String surname;
    private List<ProjectDto> projects;
}
