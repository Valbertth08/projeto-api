package empre.rubik.api.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class ProfileTeste implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Estou no perfil teste");
    }
}
