package com.lexdeveloper.banklineapi.service;

import com.lexdeveloper.banklineapi.dto.CorrentistaDto;
import com.lexdeveloper.banklineapi.model.Conta;
import com.lexdeveloper.banklineapi.model.Correntista;
import com.lexdeveloper.banklineapi.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaServiceImpl implements CorrentistaService{
    @Autowired
    private CorrentistaRepository repository;
    public void save(CorrentistaDto dto){
        Correntista correntista = new Correntista();
        correntista.setCpf(dto.getCpf());
        correntista.setNome(dto.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0d);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);
        repository.save(correntista);
    }
}
