package com.codetome.iis.controllers;

import com.codetome.iis.services.PokemonService;
import generated.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/api/jaxb/unmarshal")
    public Pokemon createPokemonFromXml() {
        return pokemonService.createPokemon();
    }

    @GetMapping("/api/jaxb/marshal")
    public String createXml() {
        pokemonService.createXml();
        return "Xml file has created";
    }
}