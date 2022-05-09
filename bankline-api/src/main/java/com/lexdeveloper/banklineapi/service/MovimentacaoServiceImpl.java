package com.lexdeveloper.banklineapi.service;

import com.lexdeveloper.banklineapi.dto.MovimentacaoDto;
import com.lexdeveloper.banklineapi.model.Correntista;
import com.lexdeveloper.banklineapi.model.Movimentacao;
import com.lexdeveloper.banklineapi.model.MovimentacaoTipo;
import com.lexdeveloper.banklineapi.repository.CorrentistaRepository;
import com.lexdeveloper.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDto dto){
        Movimentacao movimentacao = new Movimentacao();
        Double valor = dto.getTipo()== MovimentacaoTipo.RECEITA ? dto.getValor() : dto.getValor() * -1;
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(dto.getDescricao());
        movimentacao.setIdConta(dto.getIdConta());
        movimentacao.setTipo(dto.getTipo());
        movimentacao.setValor(valor);
        Correntista correntista = correntistaRepository.findById(dto.getIdConta()).orElse(null);
        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo()+valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);
    }
}
