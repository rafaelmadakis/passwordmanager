//package br.com.password.manager.core.security;
//
//import br.com.password.manager.domain.repository.DadoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DadoSecurity {
//
//
//    @Autowired
//    private DadoRepository dadoRepository;
//
//    public Authentication getAuthentication() {
//        return SecurityContextHolder.getContext().getAuthentication();
//    }
//
//    public boolean isAutenticado() {
//        return getAuthentication().isAuthenticated();
//    }
//
//    public Long getUsuarioId() {
//        Jwt jwt = (Jwt) getAuthentication().getPrincipal();
//
//        return jwt.getClaim("usuario_id");
//    }
//
//    public boolean usuarioAutenticadoIgual(Long usuarioId) {
//        return getUsuarioId() != null && usuarioId != null
//                && getUsuarioId().equals(usuarioId);
//    }
//
//    public boolean hasAuthority(String authorityName) {
//        return getAuthentication().getAuthorities().stream()
//                .anyMatch(authority -> authority.getAuthority().equals(authorityName));
//    }
//
//    public boolean temEscopoEscrita() {
//        return hasAuthority("SCOPE_WRITE");
//    }
//
//    public boolean temEscopoLeitura() {
//        return hasAuthority("SCOPE_READ");
//    }
//
//    public boolean podeConsultarDados() {
//        return isAutenticado() && temEscopoLeitura();
//    }
//
//    public boolean podeEditarDados() {
//        return isAutenticado() && temEscopoEscrita();
//    }
//
//    public boolean podeConsultarCidades() {
//        return isAutenticado() && temEscopoLeitura();
//    }
//
//    public boolean podeConsultarEstados() {
//        return isAutenticado() && temEscopoLeitura();
//    }
//
//    public boolean podeConsultarCozinhas() {
//        return isAutenticado() && temEscopoLeitura();
//    }
//
//    public boolean podeConsultarEstatisticas() {
//        return temEscopoLeitura() && hasAuthority("GERAR_RELATORIOS");
//    }
//
//}
