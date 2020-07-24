package finalproject.models.detailsService;

import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class MyUserDetails  implements UserDetailsService {

    private static final Logger LOGGER= LoggerFactory.getLogger(MyUserDetails.class);

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOpt = this.userRepository.findByEmail(email);

        LOGGER.debug("Trying to load user {}. Successful? {}",
                email, userOpt.isPresent());

        return userOpt
                .map(this::map)
                .orElseThrow(()-> new UsernameNotFoundException("No found user with email: "+email));
    }

    private org.springframework.security.core.userdetails.User map(User user){
        List<GrantedAuthority>authorities=user.getRoles()
                .stream()
                .map(r->new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());

        org.springframework.security.core.userdetails.User result=new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword() != null ? user.getPassword() : "",
                authorities
        );

        if (user.getPassword()==null){
            result.eraseCredentials();
        }
        return result;
    }
}

