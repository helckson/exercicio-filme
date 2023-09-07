package io.github.filme.mapper;

import io.github.filme.domain.entity.Filme;
import io.github.filme.rest.dto.FilmeDTO;

public class FilmeMapper {

	public static Filme from(FilmeDTO dto) {
		Filme filme = Filme
						.builder()
						.nome(dto.getNome())
						.autor(dto.getAutor())
						.lancamento(dto.getLancamento())
						.genero(dto.getGenero())
						.build();
		
		return filme;
	}
}
