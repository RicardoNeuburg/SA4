package br.com.senai.sa4.services;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senai.sa4.orm.Livro;
@Service
public interface LivroService {
	public List<Livro> listarLivros();
	public Livro listarLivro(Integer id);
	public void apagarLivro(Integer id);
	public void alterarLivro(Livro livro);
	public void adicionarLivro(Livro livro);
}
