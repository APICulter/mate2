import com.afd.mate.domain.service.EventRepository;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;


    @Given("une base de donnée ne contenant aucun Evenement existe")
    public void uneBaseDeDonnéeNeContenantAucunEvenementExiste() {
        repository.deleteAll();
    }
}
