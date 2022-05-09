package com.lexdeveloper.banklineapi.resource;

import com.lexdeveloper.banklineapi.dto.MovimentacaoDto;
import com.lexdeveloper.banklineapi.model.Movimentacao;
import com.lexdeveloper.banklineapi.repository.MovimentacaoRepository;
import com.lexdeveloper.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoResource {

    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDto dto){
        service.save(dto);
    }
}
