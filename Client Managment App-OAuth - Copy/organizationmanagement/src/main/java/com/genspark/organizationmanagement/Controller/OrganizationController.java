package com.genspark.organizationmanagement.Controller;

import com.genspark.organizationmanagement.Entity.Organization;
import com.genspark.organizationmanagement.Service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orgs")
@RequiredArgsConstructor
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/")
    public List<Organization> getAllOrganizations() {return organizationService.getAllOrganizations();}

    @GetMapping("/{projectId}")
    public Organization getOrganizationById(@PathVariable Long id) {return organizationService.getOrganizationById(id);}

    @PostMapping("/")
    public Organization createOrganization(@RequestBody Organization organization) {return organizationService.createOrganization(organization);}

    @PutMapping("/{projectId}")
    public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization updatedOrganization) {return organizationService.updateOrganization(id, updatedOrganization);}

    @DeleteMapping("/{id}")
    public String deleteOrganization(@PathVariable Long id) { return organizationService.deleteOrganizationById(id);}
}
