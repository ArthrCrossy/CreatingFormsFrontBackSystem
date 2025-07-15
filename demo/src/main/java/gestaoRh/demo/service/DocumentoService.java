package gestaoRh.demo.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentoService {

    public void salvarPdf(MultipartFile file) throws Exception {
        System.out.println("Salvando PDF...");
        try (PDDocument documento = PDDocument.load(file.getInputStream())) {
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(documento);

            String[] palavras = texto.split("\\s+");
            for (String palavra : palavras) {
                System.out.println(palavra);
            }
        }
    }
}