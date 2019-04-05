package com.example.tableVaadinPostgreSQL;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByNameLikeIgnoreCase(String name, Pageable request);

    int countByNameLikeIgnoreCase(String name);
}