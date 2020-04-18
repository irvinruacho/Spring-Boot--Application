package com.sinFloo.CrudSpringBoot.interfaceService;

import com.sinFloo.CrudSpringBoot.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public List<Persona> list();

    public Optional<Persona> ListById(int id);

    public int save(Persona person);

    public void delete(int id);
}
