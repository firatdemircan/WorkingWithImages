package com.tmo.service.impl;

import com.tmo.entity.SoruEntity;
import com.tmo.entity.dtos.saveDto.SoruSaveDTO;
import com.tmo.repository.SoruRepo;
import com.tmo.service.ISoruService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:29 PM
 * CreatedFor WorkingWithImages
 */
@Service
public class SoruService implements ISoruService {

    private final SoruRepo soruRepo;
    private final Path fileStorageLocation;

    @Value("${file.upload-dir}")
    private String uploadPath;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadPath));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload folder!");
        }
    }

    public SoruService(SoruRepo soruRepo, Path fileStorageLocation)
    {
        this.soruRepo = soruRepo;
        this.fileStorageLocation = Paths.get(uploadPath);
    }

    @Override
    public SoruEntity add(SoruSaveDTO soruSaveDTO, MultipartFile file) throws IOException {
        if (soruSaveDTO.getId() == null) {
            SoruEntity soruEntity = new SoruEntity();
            soruEntity.setSoruText(soruSaveDTO.getSoruText());
            soruEntity.setFileName(saveFile(file));
            return soruRepo.save(soruEntity);

        } else {
            return updateSoru(soruSaveDTO, file);
        }
    }


    private UUID saveFile(MultipartFile file) throws IOException {

        UUID fileName = UUID.randomUUID();
        Path targetLocation = this.fileStorageLocation.resolve(String.valueOf(fileName));
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    private SoruEntity updateSoru(SoruSaveDTO soruSaveDTO, MultipartFile file) {
        return null;
    }
}
