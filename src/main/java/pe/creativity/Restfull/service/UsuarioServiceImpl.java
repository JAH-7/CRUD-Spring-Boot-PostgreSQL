package pe.creativity.Restfull.service;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.creativity.Restfull.security.JwtProvider;
import pe.creativity.Restfull.entity.Role;
import pe.creativity.Restfull.entity.User;
import pe.creativity.Restfull.repository.RoleRepository;
import pe.creativity.Restfull.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    private static final Log LOGGER = LogFactory.getLog(UsuarioServiceImpl.class);

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private JwtProvider jwtProvider;


    @Autowired
    public UsuarioServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }



    // Ingresa
    public Optional<String> signin(String username, String password) {
        LOGGER.info("Nuevo usuario que intenta ingresar ");
        Optional<String> token = Optional.empty();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username,user.get().getRole()));
            } catch (AuthenticationException e) {
                LOGGER.info("Registro de falla para el usuario {}", e);
                LOGGER.debug(username);
            }
        }
        return token;
    }

    //Registrate

    public Optional<User> signout(String username, String password, String lastname, String firstname) {
        LOGGER.info("Nuevo usuario que se registra: Validando en la bd ");
        Optional<User> user = Optional.empty();
        LOGGER.info("El usuario %user ya se encuentra "+ user);

        if (!userRepository.findByUsername(username).isPresent()) {
            LOGGER.info("El usuario no se encuentra en la bd se procede a crear ");
            Optional<Role> role = roleRepository.findByRoleName("ROLE_CSR");
            user = Optional.of(userRepository.save(new User(username,
                    passwordEncoder.encode(password),
                    role.get(),
                    firstname,
                    lastname)));
        }
        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
