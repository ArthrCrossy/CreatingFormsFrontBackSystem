package gestaoRh.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulario")
public class UserController {

    @GetMapping("/getAll")
    public String handleGet() {
        return "oi";
    }
}