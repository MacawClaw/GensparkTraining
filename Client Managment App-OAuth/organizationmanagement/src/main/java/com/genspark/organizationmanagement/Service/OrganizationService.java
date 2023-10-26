package com.genspark.organizationmanagement.Service;

import com.genspark.organizationmanagement.Entity.Organization;
import com.genspark.organizationmanagement.Repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long id, Organization updatedOrganization) {
        Organization existingOrganization = organizationRepository.findById(id).orElse(null);
        if(existingOrganization != null) {
            existingOrganization.setOrganizationName(updatedOrganization.getOrganizationName());
            existingOrganization.setClientSize(updatedOrganization.getClientSize());
            //existingProject.setClientId(updatedProject.getClientId());
            existingOrganization.setProjectSize(updatedOrganization.getProjectSize());
            return organizationRepository.save(existingOrganization);
        }
        return null;
    }

    public String deleteOrganizationById(Long id) {
        organizationRepository.deleteById(id);
        return "The organization was deleted successfully";
    }
}
