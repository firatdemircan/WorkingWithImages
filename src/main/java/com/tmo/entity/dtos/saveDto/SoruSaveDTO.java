package com.tmo.entity.dtos.saveDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:28 PM
 * CreatedFor WorkingWithImages
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoruSaveDTO {

    private Long id;
    private String soruText;

    private String fileName;

}
