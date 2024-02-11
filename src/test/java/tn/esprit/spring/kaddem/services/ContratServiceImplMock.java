package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ContratServiceImplMock {
    @Mock
    ContratRepository contratRepository;


    @InjectMocks
    ContratServiceImpl contratService;
    static Date dateDebut = new Date(2024, 1, 1); // 1er janvier 2024 (attention : le mois est 0-indexé)
    static Date dateFin = new Date(2024, 11, 31); // 31 décembre 2024 (attention : le mois est 0-indexé)

    // En supposant que vous avez une classe Contrat avec un constructeur prenant les dates de début et de fin
    private static Contrat contrat1 = new Contrat(2, dateDebut, dateFin, Specialite.CLOUD, true, 10);
    private static Contrat contrat2 = new Contrat(3, dateDebut, dateFin, Specialite.CLOUD, true, 10);

    @Test
    public void testRetrieveContrat () {
        Mockito.when(contratRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(contrat1));
        Contrat contrat1 = contratService.retrieveContrat(2);
        Assertions.assertNotNull(contrat1, "The retrieved contrat should not be null.");
    }
    @Test
    public void testRetrieveAllContrats() {
        Mockito.when(contratRepository.findAll()).thenReturn(Arrays.asList(contrat1,contrat2));
        List<Contrat> contratList = contratService.retrieveAllContrats();
        Assertions.assertNotNull(contratList, "The list of contrats should not be null.");
        Assertions.assertEquals(2, contratList.size(), "The expected size of the list is 2.");
    }
    @Test
    public void testAddContrat() {
        Mockito.when(contratRepository.save(Mockito.any(Contrat.class))).thenReturn(contrat1);
        Contrat addedContrat = contratService.addContrat(contrat1);
        Assertions.assertNotNull(addedContrat, "The added etudiant should not be null.");
        Assertions.assertEquals(contrat1.getDateDebutContrat(), addedContrat.getDateDebutContrat(), "The expected Date is '...'");
        Assertions.assertEquals(contrat1.getDateFinContrat(), addedContrat.getDateFinContrat(), "The expected Date is '...'");
    }



}
