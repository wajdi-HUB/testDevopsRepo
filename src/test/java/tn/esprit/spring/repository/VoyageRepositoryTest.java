package tn.esprit.spring.repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;

import java.util.List;
import org.junit.Assert;
@RunWith(SpringRunner.class)
@DataJpaTest
public class VoyageRepositoryTest {
    @Autowired
    private VoyageRepository voyageRepository;

    @Test
    public void testRechercheVoyage() {
        // Créer des objets Voyage pour le test
        Voyage voyage1 = new Voyage();
        voyage1.setGareDepart(Ville.tunis);
        voyage1.setGareArrivee(Ville.sfax);
        voyage1.setHeureDepart(8.0);

        Voyage voyage2 = new Voyage();
        voyage2.setGareDepart(Ville.tunis);
        voyage2.setGareArrivee(Ville.SOUSSE);
        voyage2.setHeureDepart(9.0);

        // Enregistrer les voyages dans la base de données
        voyageRepository.save(voyage1);
        voyageRepository.save(voyage2);

        // Appeler la méthode à tester
        List<Voyage> result = voyageRepository.RechercheVoyage(Ville.tunis, Ville.sfax, 8.0);

        // Vérifier le résultat
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(voyage1, result.get(0));
    }
}





