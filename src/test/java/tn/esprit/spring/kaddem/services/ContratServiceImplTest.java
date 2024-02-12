package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {
    @Autowired
    IContratService iContratService;

    // Supposons que vous ayez les objets Date correspondant à la date de début et de fin du contrat
    static Date dateDebut = new Date(2024, 1, 1); // 1er janvier 2024 (attention : le mois est 0-indexé)
    static Date dateFin = new Date(2024, 11, 31); // 31 décembre 2024 (attention : le mois est 0-indexé)

    // En supposant que vous avez une classe Contrat avec un constructeur prenant les dates de début et de fin
    private static Contrat contrat = new Contrat(2, dateDebut, dateFin, Specialite.CLOUD, true, 10);

    @Test
    @Order(1)
    public void testRetrieveAllContrat() {
        List<Contrat> contratList  = iContratService.retrieveAllContrats();
        Assertions.assertNotNull(contratList);
    }
//    @Test
//    @Order(2)
//    void testAddContrat() {
//        Contrat et = iContratService.addContrat(ContratServiceImplTest.contrat);
//        Assertions.assertNotNull(et);
//        ContratServiceImplTest.contrat.setIdContrat(et.getIdContrat());
//    }
    /*@Test
    @Order(3)
    public void testRetrieveContrat() {
        Contrat retrievedContrat = iContratService.retrieveContrat(ContratServiceImplTest.contrat.getIdContrat());
        System.out.println("Retrieved Contrat:");
        System.out.println("ID: " + retrievedContrat.getIdContrat());
        System.out.println("Specialite: " + retrievedContrat.getSpecialite());
        Assertions.assertNotNull(retrievedContrat);
    }*/

}