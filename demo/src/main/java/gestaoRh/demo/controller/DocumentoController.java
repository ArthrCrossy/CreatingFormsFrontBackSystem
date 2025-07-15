package gestaoRh.demo.controller;

import gestaoRh.demo.service.DocumentoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class DocumentoController {
    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping("/upload")
    public String uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            documentoService.salvarPdf(file);
            return "PDF salvo com sucesso!";
        } catch (Exception e) {
            return "Erro ao salvar PDF: " + e.getMessage();
        }
    }
}
