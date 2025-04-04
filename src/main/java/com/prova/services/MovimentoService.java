package com.prova.services;

import com.prova.dto.MovimentoDTO;
import com.prova.models.Movimento;
import com.prova.repositories.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoService {
    @Autowired
    private MovimentoRepository movimentoRepository;

    public MovimentoDTO salvarMovimento(MovimentoDTO movimentoDTO) {
        Movimento movimento = converterMovimentoDTOParaMovimento(movimentoDTO);
        movimento = movimentoRepository.save(movimento);
        return converterMovimentoParaMovimentoDTO(movimento);
    }

    public MovimentoDTO converterMovimentoParaMovimentoDTO(Movimento movimento) {
        MovimentoDTO movimentoDTO = new MovimentoDTO();
        movimentoDTO.setId(movimento.getId());
        movimentoDTO.setData_movimento(movimento.getData_movimento());
        movimentoDTO.setValor(movimento.getValor());
        movimentoDTO.setClassificacao(movimento.getClassificacao());
        return movimentoDTO;
    }

    public Movimento converterMovimentoDTOParaMovimento(MovimentoDTO movimentoDTO) {
        Movimento movimento = new Movimento();
        movimento.setId(movimentoDTO.getId());
        movimento.setData_movimento(movimentoDTO.getData_movimento());
        movimento.setValor(movimentoDTO.getValor());
        movimento.setClassificacao(movimentoDTO.getClassificacao());
        return movimento;
    }

    public Movimento buscarMovimentoPorId(Long id) {
        return movimentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movimento não encontrado"));
    }

    public MovimentoDTO atualizarMovimento(MovimentoDTO movimentoDTO) {
        if (movimentoDTO.getId() == null) {
            throw new IllegalArgumentException("id não informado");
        }
        Movimento movimento = movimentoRepository.findById(movimentoDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Movimento não encontrado"));
        movimento = converterMovimentoDTOParaMovimento(movimentoDTO);
        movimento = movimentoRepository.save(movimento);
        return converterMovimentoParaMovimentoDTO(movimento);
    }

    public void deletarMovimento(Long id) {
        movimentoRepository.deleteById(id);
    }

}