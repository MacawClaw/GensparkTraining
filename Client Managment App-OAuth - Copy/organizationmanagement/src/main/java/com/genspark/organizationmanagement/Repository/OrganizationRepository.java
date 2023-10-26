package com.genspark.organizationmanagement.Repository;

import com.genspark.organizationmanagement.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
