package com.lexdeveloper.banklineapi.resource;

import com.lexdeveloper.banklineapi.dto.CorrentistaDto;
import com.lexdeveloper.banklineapi.model.Correntista;
import com.lexdeveloper.banklineapi.repository.CorrentistaRepository;
import com.lexdeveloper.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaResource {

    @Autowired
    private CorrentistaRepository repository;
    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDto dto){
        service.save(dto);
    }
}
