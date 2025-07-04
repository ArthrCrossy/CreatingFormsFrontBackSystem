package gestaoRh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String nomeCompleto;

    @Column()
    private String email;

    @Column()
    private String telefone;

    @Column()
    private String cargo;

    @Enumerated(EnumType.STRING)
    @Column()
    private Departamento departamento;

    @Column()
    private LocalDate dataContratacao;

    @Column()
    private BigDecimal salario;
}
