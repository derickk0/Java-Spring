package com.senai.projeto.controller;

import com.senai.projeto.model.Usuario;
import com.senai.projeto.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<Usuario> buscarUsuarioPortEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}
