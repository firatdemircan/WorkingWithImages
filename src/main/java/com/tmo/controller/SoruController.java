package com.tmo.controller;

import com.tmo.entity.SoruEntity;
import com.tmo.entity.dtos.saveDto.SoruSaveDTO;
import com.tmo.service.ISoruService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:31 PM
 * CreatedFor WorkingWithImages
 */
@RestController
@RequestMapping("/soru")
@AllArgsConstructor
public class SoruController {

    private final ISoruService soruService;

    @PostMapping("/add")
    public SoruEntity addSoru(@RequestBody SoruSaveDTO soruSaveDTO, @RequestParam("file") MultipartFile file) throws IOException {
        return soruService.add(soruSaveDTO,file);
    }

}
