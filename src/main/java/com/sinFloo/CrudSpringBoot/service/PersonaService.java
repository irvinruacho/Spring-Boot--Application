package com.sinFloo.CrudSpringBoot.service;

import com.sinFloo.CrudSpringBoot.interfaceService.IPersonaService;
import com.sinFloo.CrudSpringBoot.interfaces.IPersona;
import com.sinFloo.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersona data;

    @Override
    public List<Persona> list() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> ListById(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Persona person) {
        Persona p = data.save(person);
       return null != p ? 0 : 1;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
