package com.tmo.service.impl;

import com.tmo.entity.SoruEntity;
import com.tmo.entity.dtos.saveDto.SoruSaveDTO;
import com.tmo.repository.SoruRepo;
import com.tmo.service.ISoruService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
@RequiredArgsConstructor
public class SoruService implements ISoruService {

    private final SoruRepo soruRepo;

    @Value("${ftp.adress}")
    String FTP_ADDRESS;
    @Value("${ftp.password}")
    String LOGIN;
    @Value("${ftp.user}")
    String PSW;


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



        FTPClient con = null;
        UUID fileName = UUID.randomUUID();

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);

            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                boolean result = con.storeFile(String.valueOf(fileName)+".jpg", file.getInputStream());
                con.logout();
                con.disconnect();

            }
        } catch (Exception e) {

        }
        return fileName;
    }

    private SoruEntity updateSoru(SoruSaveDTO soruSaveDTO, MultipartFile file) {
        return null;
    }
}
