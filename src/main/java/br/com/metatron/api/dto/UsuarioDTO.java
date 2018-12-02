/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.metatron.api.dto;

/**
 *
 * @author diego
 */
public class UsuarioDTO {
    private Long id;
    private String nome;
    private CargoDTO cargo;
    private TelefoneDTO telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

    public TelefoneDTO getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneDTO telefone) {
        this.telefone = telefone;
    }
    
    
}
