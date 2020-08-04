package finalproject;

import finalproject.models.entities.Office;
import finalproject.models.entities.Role;
import finalproject.models.entities.Town;
import finalproject.models.entities.User;
import finalproject.repositories.TownRepository;
import finalproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class init implements CommandLineRunner {
    private final TownRepository townRepository;

    public init(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (townRepository.count()==0) {
            Town sofia = new Town().setName("Sofia");
            Office mladost = new Office().setTown(sofia).setName("Mladost");
            Office lulin = new Office().setTown(sofia).setName("Lulin");
            Office centre = new Office().setTown(sofia).setName("Centre");
            sofia.setOffices(List.of(mladost, lulin, centre));

            Town plovdiv = new Town().setName("Plovdiv");
            Office trakiq = new Office().setTown(plovdiv).setName("Trakiq");
            Office smirnenski = new Office().setTown(plovdiv).setName("Smirnenski");
            plovdiv.setOffices(List.of(trakiq, smirnenski));

            Town varna = new Town().setName("Varna");
            Office asparuhovo = new Office().setTown(varna).setName("Asparuhovo");
            Office galata = new Office().setTown(varna).setName("Garata");
            varna.setOffices(List.of(asparuhovo, galata));

            Town goceDelchev=new Town().setName("Goce Delchev");
            Office kulata=new Office().setTown(goceDelchev).setName("Kulata");
            goceDelchev.setOffices(List.of(kulata));

            townRepository.saveAll(List.of(sofia, plovdiv, varna,goceDelchev));
        }
    }
}
