package yavirac.labyac.service;
import yavirac.labyac.entity.*;
import yavirac.labyac.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

      public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
      return usuarioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Usuario no encontrado con id: " + id));
  }

  public Usuario createUsuario(Usuario usuario) {
      return usuarioRepository.save(usuario);
  }

  public Usuario updateUsuario(Long id, Usuario usuario) {
    Usuario usuarioExistente = getUsuarioById(id);
    usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
    usuarioExistente.setContrasena(usuario.getContrasena());
    usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());
    return usuarioRepository.save(usuarioExistente);
  }

  public void deleteUsuario(Long id) {
      usuarioRepository.deleteById(id);
  }

}
