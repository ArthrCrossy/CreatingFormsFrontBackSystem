package gestaoRh.demo.model;

import jakarta.persistence.*;

@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArquivo;

    @Lob
    private byte[] dadosPdf;

}

