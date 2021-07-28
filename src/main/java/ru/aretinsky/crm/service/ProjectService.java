package ru.aretinsky.crm.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.aretinsky.crm.exception.ProjectNotFoundException;
import ru.aretinsky.crm.model.dto.ProjectDto;
import ru.aretinsky.crm.model.entity.Customer;
import ru.aretinsky.crm.model.entity.Project;
import ru.aretinsky.crm.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    protected ProjectService(ProjectRepository projectRepository, ModelMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    public List<ProjectDto> findAll() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream()
                .map(customer -> mapper.map(customer, ProjectDto.class))
                .collect(Collectors.toList());
    }

    public ProjectDto findById(long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        return mapper.map(project, ProjectDto.class);
    }

    public List<ProjectDto> findAllByCustomerId(long customerId) {
        List<Project> projectList = projectRepository.findAllByCustomerId(customerId);
        return projectList.stream()
                .map(customer -> mapper.map(customer, ProjectDto.class))
                .collect(Collectors.toList());
    }

    public Project createProject(ProjectDto projectDto) {
        var project = mapper.map(projectDto, Project.class);
        return projectRepository.save(project);
    }
}
