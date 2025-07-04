package gestaoRh.demo.repository;

import gestaoRh.demo.model.Departamento;
import gestaoRh.demo.model.Funcionario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamento(Departamento departamento);

    List<Funcionario> findByCargoContainingIgnoreCase(String cargo);

    Optional<Funcionario> findByEmail(String email);

    @Query("SELECT * FROM funcionarios WHERE nome_completo ILIKE %:nome%")
    List<Funcionario> findByNomeCompletoContaining(@Param("nome") String nome);

    @Query("SELECT * FROM funcionarios WHERE salario BETWEEN :salarioMin AND :salarioMax")
    List<Funcionario> findBySalarioBetween(@Param("salarioMin") BigDecimal salarioMin,
                                           @Param("salarioMax") BigDecimal salarioMax);

}
