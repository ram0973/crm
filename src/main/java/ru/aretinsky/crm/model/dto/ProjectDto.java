package ru.aretinsky.crm.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aretinsky.crm.model.entity.Customer;

@Data
@NoArgsConstructor
public class ProjectDto {

    private long id;
    private String name;
    private int sum;
    private Customer customerId;
}
