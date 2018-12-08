package br.com.metatron.api.controller;

import br.com.metatron.api.service.UsuarioService;
import br.com.metatron.api.dto.UsuarioDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ResponseBody
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<UsuarioDTO> listUsuarios(
            @RequestParam(name = "nomeUsuario", defaultValue = "") String nomeUsuario,
            @RequestParam(name = "nomeCargo", defaultValue = "") String nomeCargo) {

        List<UsuarioDTO> usuarios = service.findAllUsuarios(nomeUsuario, nomeCargo)
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
        
        return usuarios;
    }
}
