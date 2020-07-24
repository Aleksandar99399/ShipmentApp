package finalproject;

import finalproject.models.entities.Role;
import finalproject.models.entities.User;
import finalproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class init implements CommandLineRunner {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
       this.userRepository = userRepository;
       this.passwordEncoder = passwordEncoder;
   }

   @Override
   public void run(String... args) throws Exception {

    }
}
