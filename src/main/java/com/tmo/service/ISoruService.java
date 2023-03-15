package com.tmo.service;

import com.tmo.entity.SoruEntity;
import com.tmo.entity.dtos.saveDto.SoruSaveDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:28 PM
 * CreatedFor WorkingWithImages
 */
public interface ISoruService {

    SoruEntity add(SoruSaveDTO soruSaveDTO, MultipartFile file) throws IOException;

}
