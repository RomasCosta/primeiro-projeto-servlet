package br.com.alura.gerenciador.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresaServlet")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//se alterar "service" por "doPost ou doGet" ele só vai aceitar o método escolhido. Service aceita ambos.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//request.setAttribute("empresa", empresa.getNome());//manda as empresas cadastradas para a página HTML
		
		response.sendRedirect("listaEmpresasServlet");
		
//		//chamar o JPS
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresasServlet");
//		request.setAttribute("empresa", empresa.getNome());//manda as empresas cadastradas para a página HTML
//		rd.forward(request, response);
//	}

	}
}
