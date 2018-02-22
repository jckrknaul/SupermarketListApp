package br.com.jckrknaul.SupermarketList.controller;

import br.com.jckrknaul.SupermarketList.model.SupermarketList;
import br.com.jckrknaul.SupermarketList.repository.SupermarketlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupermarketlistController {

    private final SupermarketlistRepository supermarketlistRepository;

    @Autowired
    public SupermarketlistController(SupermarketlistRepository supermarketlistRepository) {
        this.supermarketlistRepository = supermarketlistRepository;
    }

    @RequestMapping(value = "/CadastrarLista", method = RequestMethod.GET)
    public String formGet(){
        return "supermarketList/formCadastrarLista";
    }

    @RequestMapping(value = "/CadastrarLista", method = RequestMethod.POST)
    public String formPost(SupermarketList supermarketList){
        supermarketlistRepository.save(supermarketList);
        return "redirect:/CadastrarLista";
    }

    @GetMapping("/history")
    public ModelAndView getListHistory(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<SupermarketList> history = supermarketlistRepository.findAll();
        modelAndView.addObject("supermarketList", history);
        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView detailSupermarket(@PathVariable("id") long id){
        SupermarketList sp = supermarketlistRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("supermarketList/detalhesSupermarket");
        modelAndView.addObject("supermarketList", sp);
        return modelAndView;
    }

}
