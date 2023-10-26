package com.genspark.projectmanagement.Controller;

import com.genspark.projectmanagement.Entity.Project;
import com.genspark.projectmanagement.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public List<Project> getAllProjects() {return projectService.getAllProjects();}

    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable Long id) {return projectService.getProjectById(id);}

    @PostMapping("/")
    public Project createProject(@RequestBody Project project) {return projectService.createProject(project);}

    @PutMapping("/{projectId}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {return projectService.updateProject(id, updatedProject);}

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) { return projectService.deleteProjectById(id);}

}
