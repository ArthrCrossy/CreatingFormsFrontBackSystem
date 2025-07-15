package gestaoRh.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/documentos")
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file", required = false) MultipartFile file) {
        if (file == null || file.isEmpty()) {
            System.out.println("Arquivo ausente");
            // Trate a ausência do arquivo
            return "Arquivo ausente";
        }
        // Prossegue com o upload
        System.out.println("Arquivo recebido: " + file.getOriginalFilename());
        return "Oi";
    }

}
