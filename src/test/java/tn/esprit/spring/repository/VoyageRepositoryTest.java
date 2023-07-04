package tn.esprit.spring.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VoyageRepositoryTest {

    @Mock
    private VoyageRepository voyageRepository;

    @Test
    public void testRechercheVoyage() {
        // Create test data
        Voyage voyage1 = new Voyage();
        voyage1.setGareDepart(Ville.tunis);
        voyage1.setGareArrivee(Ville.sfax);
        voyage1.setHeureDepart(8.0);

        Voyage voyage2 = new Voyage();
        voyage2.setGareDepart(Ville.tunis);
        voyage2.setGareArrivee(Ville.SOUSSE);
        voyage2.setHeureDepart(9.0);

        // Define the expected result
        List<Voyage> expectedResult = new ArrayList<>();
        expectedResult.add(voyage1);

        // Mock the behavior of the voyageRepository
        Mockito.when(voyageRepository.RechercheVoyage(Ville.tunis, Ville.sfax, 8.0))
                .thenReturn(expectedResult);

        // Call the method under test
        List<Voyage> result = voyageRepository.RechercheVoyage(Ville.tunis, Ville.sfax, 8.0);

        // Verify the result
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(expectedResult.get(0), result.get(0));
    }
}
