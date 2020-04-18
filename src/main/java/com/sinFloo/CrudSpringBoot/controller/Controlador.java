package com.sinFloo.CrudSpringBoot.controller;

import com.sinFloo.CrudSpringBoot.interfaceService.IPersonaService;
import com.sinFloo.CrudSpringBoot.modelo.Persona;
import com.sinFloo.CrudSpringBoot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    private static final String ROOT = "/";

    @Autowired
    private IPersonaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        List<Persona> list = service.list();
        model.addAttribute("lista", list);
        return "index";
    }
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("person", new Persona());
        return "form";
    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@Valid Persona p, Model model) {
        service.save(p);
        return "redirect:" + ROOT;
    }
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int idPerson, Model model) {
        Optional<Persona> p = service.ListById(idPerson);
        model.addAttribute("persona", p);
        return "form";
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int idPerson, Model model) {
        service.delete(idPerson);
        return "redirect:" + ROOT;
    }
}
