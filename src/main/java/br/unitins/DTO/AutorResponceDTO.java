package br.unitins.DTO;

import br.unitins.model.Autor;
import br.unitins.model.Cor;

public record AutorResponceDTO(
        long idAutor,

        long idUsuario,
        String nomeArtistico
) {
        public AutorResponceDTO(Autor autor){
                this(
                        autor.getId(),
                        autor.getUsuario().getId(),
                        autor.getNomeArtistico()
                );
        }
}
