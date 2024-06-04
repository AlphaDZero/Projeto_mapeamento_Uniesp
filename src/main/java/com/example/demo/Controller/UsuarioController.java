package com.example.demo.Controller;

import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario != null && usuarioService.validarSenha(usuario, password)) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas!";
        }
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByid(@PathVariable Long id) {
    	usuarioService.deleteById(id);
    }

}
