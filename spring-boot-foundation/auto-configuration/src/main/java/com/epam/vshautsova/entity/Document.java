package com.epam.vshautsova.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Documents entity.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Document
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;

    public Document(String name, String author)
    {
        this.name = name;
        this.author = author;
    }
}
