package pe.creativity.Restfull.service;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.creativity.Restfull.repository.UserRepository;


@Service("UsuarioService")
public class UsuarioServiceImpl {

    @Autowired
    private UserRepository userRepository;

    private static final Log LOGGER = LogFactory.getLog(UsuarioServiceImpl.class);




}
