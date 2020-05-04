package pe.creativity.Restfull.service;

import pe.creativity.Restfull.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<User> getAll();
    public Optional<String> signin(String username, String password);
    public Optional<User> signout(String username, String password, String lastname, String firstname);

}
