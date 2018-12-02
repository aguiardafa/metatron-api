/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.metatron.api.controller;

import br.com.metatron.api.service.UsuarioService;
import br.com.metatron.api.dto.UsuarioDTO;
import br.com.metatron.api.model.Usuario;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> listUsuarios() {

        //List<UsuarioDTO> usuarios = service.findAllUsuarios()
                //.stream()
                //.map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                //.collect(Collectors.toList());
        
        //return usuarios;
        return null;
    }


}
