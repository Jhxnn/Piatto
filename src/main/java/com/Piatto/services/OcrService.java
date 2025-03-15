package com.Piatto.services;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.bytedeco.javacv.*;
import org.bytedeco.opencv.opencv_core.Mat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

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
            Mat processedMat = processImageWithJavaCV(tempFile);
            Path tempProcessedImage = Files.createTempFile("processed_", ".png");
            imwrite(tempProcessedImage.toString(), processedMat);
            String result = tesseract.doOCR(tempProcessedImage.toFile()).replaceAll("\\s", "");
            String resultFormat = result.replaceAll("[^a-zA-Z0-9\\\\s]", "");
            Files.delete(tempProcessedImage);
            if (!tempFile.delete()) {
                System.err.println("Falha ao excluir o arquivo temporário: " + tempFile.getName());
            }
            return resultFormat;
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

    private Mat processImageWithJavaCV(File inputFile) {
        Mat image = imread(inputFile.getAbsolutePath());
        Mat grayImage = new Mat();
        cvtColor(image, grayImage, COLOR_BGR2GRAY);
        Mat contrastImage = new Mat();
        equalizeHist(grayImage, contrastImage);
        Mat blurredImage = new Mat();
        GaussianBlur(contrastImage, blurredImage, new org.bytedeco.opencv.opencv_core.Size(5, 5), 0);
        return blurredImage;
    }
}
