package com.tmo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:24 PM
 * CreatedFor WorkingWithImages
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SoruEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String soruText;

    private UUID fileName;
}
