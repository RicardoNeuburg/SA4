package br.com.senai.sa4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sa4.orm.Livro;
import br.com.senai.sa4.services.LivroService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	@Autowired()
	LivroService service;

	@GetMapping({ "/" })
	public String livro(Model model) {
		model.addAttribute("livros", service.listarLivros());
		return "livros";
	}

	@GetMapping("/deletar/{id}")
	public String deletarItem(@PathVariable Integer id,HttpSession session) {
		session.invalidate();
		service.apagarLivro(id);
		return "redirect:/";
	}

	@GetMapping({ "/alterar/{id}" })
	public String alterarLivro(@PathVariable Integer id, Model model,HttpSession session) {
		session.invalidate();
		model.addAttribute("livro", service.listarLivro(id));
		return "alterar";
	}

	@PostMapping({ "/alterar" })
	public String alterar(HttpServletRequest request, HttpSession session) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String autorLivro = request.getParameter("autorLivro");
		String tituloLivro = request.getParameter("tituloLivro");
		String isbn = request.getParameter("isbn");
		String linkImg = request.getParameter("linkImg");
		Livro livro = new Livro();
		livro.setId(id);
		livro.setAutorLivro(autorLivro);
		livro.setTituloLivro(tituloLivro);
		livro.setIsbn(isbn);
		livro.setLinkImg(linkImg);
		service.alterarLivro(livro);
		session.setAttribute("altera", "ok");
		return "redirect:/";
	}

	@GetMapping({ "/adicionar" })
	public String adicionarLivro(HttpSession session) {
		session.invalidate();
		return "cadastrar";
	}

	@PostMapping({ "/adicionar" })
	public String cadastrar(HttpServletRequest request, HttpSession session) {
		String autorLivro = request.getParameter("autorLivro");
		String tituloLivro = request.getParameter("tituloLivro");
		String isbn = request.getParameter("isbn");
		String linkImg = request.getParameter("linkImg");
		Livro livro = new Livro();
		livro.setAutorLivro(autorLivro);
		livro.setTituloLivro(tituloLivro);
		livro.setIsbn(isbn);
		livro.setLinkImg(linkImg);
		service.alterarLivro(livro);
		session.setAttribute("cadastro", "ok");
		return "redirect:/";
	}

}
