package com.genspark.projectmanagement.Service;

import com.genspark.projectmanagement.Entity.Project;
import com.genspark.projectmanagement.Entity.ProjectStatus;
import com.genspark.projectmanagement.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if(existingProject != null) {
            existingProject.setProjectName(updatedProject.getProjectName());
            existingProject.setProjectDescription(updatedProject.getProjectDescription());
            //existingProject.setClientId(updatedProject.getClientId());
            existingProject.setStartDate(updatedProject.getStartDate());
            existingProject.setEndDate(updatedProject.getEndDate());
            existingProject.setProjectStatus(updatedProject.getProjectStatus());
            return projectRepository.save(existingProject);
        }
        return null;
    }

    public String deleteProjectById(Long id) {
        projectRepository.deleteById(id);
        return "The project was deleted successfully";
    }
}
