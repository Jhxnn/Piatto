package com.Piatto.services;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class OcrService {

    private final ITesseract tesseract;

    public OcrService() {
        tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");
    }

    public String extractPlateText(MultipartFile multipartFile) {
        try {
            File tempFile = convertMultipartFileToFile(multipartFile);
            String result = tesseract.doOCR(tempFile).replaceAll("\\s", "");
            String resulFormat = result.replaceAll("[^a-zA-Z0-9\\\\s]", "");


            if (!tempFile.delete()) {
                System.err.println("Falha ao excluir o arquivo temporário: " + tempFile.getName());
            }

            return resulFormat;
        } catch (TesseractException | IOException e) {
            e.printStackTrace();
            return "Erro ao ler a placa";
        }
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("temp", ".png");
        file.transferTo(tempFile);
        return tempFile;
    }
}
