package br.com.senai.sa4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa4.orm.Livro;
import br.com.senai.sa4.repository.LivroRepository;

@Service
public class LivroServiceCRUD implements LivroService {
	@Autowired
	private LivroRepository repositorio;

	@Override
	public List<Livro> listarLivros() {
		return (List<Livro>) repositorio.findAll();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Livro listarLivro(Integer id) {
		return (Livro) repositorio.getById(id);
	}

	@Override
	public void apagarLivro(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public void alterarLivro(Livro livro) {
		repositorio.save(livro);
	}

	@Override
	public void adicionarLivro(Livro livro) {
		repositorio.save(livro);
		
	}
}
