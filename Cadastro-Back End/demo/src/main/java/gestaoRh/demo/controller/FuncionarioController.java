package gestaoRh.demo.controller;

import gestaoRh.demo.model.Departamento;
import gestaoRh.demo.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestaoRh.demo.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        System.out.println("=== DADOS RECEBIDOS ===");
        System.out.println("Nome Completo: " + funcionario.getNomeCompleto());
        System.out.println("Telefone: " + funcionario.getTelefone());
        System.out.println("Email: " + funcionario.getEmail());
        System.out.println("Departamento: " + funcionario.getDepartamento());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("=======================");
        
        Funcionario novoFuncionario = funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
                                                 @RequestBody Funcionario funcionario) {
        Optional<Funcionario> funcionarioExistente = funcionarioService.buscarPorId(id);

        if (funcionarioExistente.isPresent()) {
            funcionario.setId(Math.toIntExact(id));
            Funcionario funcionarioAtualizado = funcionarioService.salvar(funcionario);
            return ResponseEntity.ok(funcionarioAtualizado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);

        if (funcionario.isPresent()) {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<List<Funcionario>> buscarPorDepartamento(@PathVariable Departamento departamento) {
        List<Funcionario> funcionarios = funcionarioService.buscarPorDepartamento(departamento);
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<Funcionario>> buscarPorCargo(@PathVariable String cargo) {
        List<Funcionario> funcionarios = funcionarioService.buscarPorCargo(cargo);
        return ResponseEntity.ok(funcionarios);
    }
}