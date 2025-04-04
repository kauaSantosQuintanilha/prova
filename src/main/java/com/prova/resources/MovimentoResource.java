package com.prova.resources;

import com.prova.dto.MovimentoDTO;
import com.prova.models.Movimento;
import com.prova.services.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimentos")
public class MovimentoResource {
    @Autowired
    private MovimentoService movimentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Movimento> buscarMovimentoPorId(@PathVariable Long id) {
        Movimento movimentoDTO = movimentoService.buscarMovimentoPorId(id);
        return ResponseEntity.ok(movimentoDTO);
    }



    @PostMapping()
    public ResponseEntity<MovimentoDTO> criarEvento(@RequestBody MovimentoDTO movimentoDTO) {
        return ResponseEntity.ok(movimentoService.salvarMovimento(movimentoDTO));
    }

    @PutMapping()
    public ResponseEntity<MovimentoDTO> atualizarMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        return ResponseEntity.ok(movimentoService.atualizarMovimento(movimentoDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        movimentoService.deletarMovimento(movimentoDTO.getId());
        return ResponseEntity.noContent().build();

    }
}

