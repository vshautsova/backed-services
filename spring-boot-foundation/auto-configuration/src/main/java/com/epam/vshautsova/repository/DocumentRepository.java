package com.epam.vshautsova.repository;

import com.epam.vshautsova.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Crud repository to work with Document entity.
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>
{
}