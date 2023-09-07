package io.github.filme.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.filme.domain.entity.Filme;
import io.github.filme.rest.dto.FilmeDTO;

public class FilmeDTOMapper {

	public static FilmeDTO from(Filme filme) {
		FilmeDTO dto = FilmeDTO
						.builder()
						.id(filme.getId())
						.nome(filme.getNome())
						.autor(filme.getAutor())
						.lancamento(filme.getLancamento())
						.genero(filme.getGenero())
						.build();
		
		return dto;						
	}
	
	public static List<FilmeDTO> fromList(List<Filme> filme) {
		List<FilmeDTO> filmeDto = new ArrayList<>();
		
		for(Filme f : filme) {
			FilmeDTO dto = FilmeDTO
							.builder()
							.id(f.getId())
							.nome(f.getNome())
							.autor(f.getAutor())
							.lancamento(f.getLancamento())
							.genero(f.getGenero())
							.build();
		
			filmeDto.add(dto);
			
//
		}
		return filmeDto;
	}
}
