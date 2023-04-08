package com.codetome.iis.services;

import generated.Pokemon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private JAXBContext context;
    private final String filesFolder = "E:\\MyData\\VUA\\Programsko_Inzinjerstvo\\6.Semestar\\Interoperabilnost informacijskih sustava\\Projekt\\PokemonApi\\resources\\xml";
    private final String filename = "pokemon.xml";

    @PostConstruct
    void init() throws JAXBException {
        context = JAXBContext.newInstance(Pokemon.class);
    }

    public void createXml() {
        Pokemon pokemon = new Pokemon();

        try {
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Path dir = Path.of(filesFolder);
            Path pathToFile = dir.resolve("pokemon.xml");

            if (Files.notExists(pathToFile)) {
                Files.createDirectories(dir);
                Files.createFile(pathToFile);
            }
            mar.marshal(pokemon, pathToFile.toFile());
        } catch (Exception e) {
            throw new RuntimeException("Can't write the file");
        }
    }

    public Pokemon createPokemon() {
        try {
            Pokemon pokemon = (Pokemon) context.createUnmarshaller()
                    .unmarshal(Path.of(filesFolder, filename).toFile());
            return pokemon;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}