package com.SpringBootMail.controller;

import com.SpringBootMail.domain.EmailDTO;
import com.SpringBootMail.domain.EmailFileDTO;
import com.SpringBootMail.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDTO emailDTO) {

        System.out.println("Llega mensaje: " + emailDTO.toString());

        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sendMailFile")
    public ResponseEntity<?> sendMailFile(@ModelAttribute EmailFileDTO emailFileDTO) {

        System.out.println("Llega mensaje: " + emailFileDTO.toString());

        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/main/files" + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailFile(emailFileDTO.getToUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Email sent successfully");
            response.put("file", fileName);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            throw new RuntimeException("Error sending email " + e);
        }
    }
}
