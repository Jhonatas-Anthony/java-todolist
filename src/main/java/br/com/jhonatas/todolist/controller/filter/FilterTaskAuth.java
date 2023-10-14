package br.com.jhonatas.todolist.controller.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.jhonatas.todolist.controller.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/* import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.Filter;
 */
@Component
public class FilterTaskAuth extends OncePerRequestFilter {

	@Autowired
	private IUserRepository userRepository;

	// Por enquanto essa verificação vai ser feita em todas as rotas

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Verificar se é a rota de tasks
		var serveltPath = request.getServletPath();

		if (serveltPath.startsWith("/tasks/")) {
			// Pegar autenticação *usuario + senha*
			var authorization = request.getHeader("Authorization");

			// filterChain.doFilter(request, response);
			var authEncoded = authorization.substring("Basic".length()).trim();

			byte[] decoded = Base64.getDecoder().decode(authEncoded);

			var authString = new String(decoded);

			String[] credeintials = authString.split(":");
			String username = credeintials[0];
			String password = credeintials[1];

			// Validar user
			var existsUser = this.userRepository.findByUsername(username);

			if (existsUser == null) {
				response.sendError(401, "usuário sem autorização");
			} else {
				// Validar senha
				var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), existsUser.getPassword());
				if (passwordVerify.verified) {
					request.setAttribute("userId", existsUser.getId());
					filterChain.doFilter(request, response);
				} else {
					response.sendError(401,  "Senha errada");
				}
			}
		} 
		else {
			filterChain.doFilter(request, response);
		}

	}

}
