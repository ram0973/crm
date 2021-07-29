package ru.aretinsky.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aretinsky.crm.exception.ProjectNotFoundException;
import ru.aretinsky.crm.model.ErrorResponse;
import ru.aretinsky.crm.model.dto.ProjectDto;
import ru.aretinsky.crm.model.entity.Project;
import ru.aretinsky.crm.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    protected ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable long id) {
        return new ResponseEntity<>(projectService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all/{customerId}")
    public ResponseEntity<List<ProjectDto>> getAllProjectsByCustomerId(@PathVariable long customerId) {
        return new ResponseEntity<>(projectService.findAllByCustomerId(customerId), HttpStatus.OK);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> projectNotFoundExceptionHandler(ProjectNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(404, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
