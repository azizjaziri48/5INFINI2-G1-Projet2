package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Universite;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UniversiteServiceImplTest {
    @Autowired
    IUniversiteService iUniversiteService;
    private static Universite universite = new Universite(2,"Esprit");

    @Test
    @Order(1)
    public void testRetrieveAllEtudiants() {
        List<Universite> listUniversite  = iUniversiteService.retrieveAllUniversites();
        Assertions.assertNotNull(listUniversite);
    }
    @Test
    @Order(2)
    void testAddEtudiant() {
        Universite un = iUniversiteService.addUniversite(UniversiteServiceImplTest.universite);
        Assertions.assertNotNull(un);
        UniversiteServiceImplTest.universite.setIdUniv(un.getIdUniv());
    }
    @Test
    @Order(3)
    public void testUpdateUniversite() {
        Universite existingUniversite = iUniversiteService.retrieveUniversite(UniversiteServiceImplTest.universite.getIdUniv());
        System.out.println("Before Update - Existing Universite: " + existingUniversite);
        existingUniversite.setNomUniv("neww");
        Universite updatedUniversite = iUniversiteService.updateUniversite(existingUniversite);
        System.out.println("After Update - Updated Universite: " + updatedUniversite.getNomUniv());
    }

    @Test
    @Order(4)
    public void testRetrieveUniversite() {
        Universite retrievedUniversite = iUniversiteService.retrieveUniversite(UniversiteServiceImplTest.universite.getIdUniv());
        System.out.println("Retrieved Universite:");
        System.out.println("ID: " + retrievedUniversite.getIdUniv());
        System.out.println("Nom: " + retrievedUniversite.getNomUniv());
        Assertions.assertNotNull(retrievedUniversite);
    }
    @Test
    @Order(5)
    public void testRemoveUniversite() {
        iUniversiteService.deleteUniversite(UniversiteServiceImplTest.universite.getIdUniv());
    }
   /* @Test
    @Order(6)
    public void testAssignEtudiantToDepartement() {
        iEtudiantService.assignEtudiantToDepartement(EtudiantServiceImplTest.etudiant.getIdEtudiant(), 1);
        Etudiant assignedEtudiant = iEtudiantService.retrieveEtudiant(EtudiantServiceImplTest.etudiant.getIdEtudiant());
        Assertions.assertNotNull(assignedEtudiant);
    }
    @Test
    @Order(7)
    public void testAddAndAssignEtudiantToEquipeAndContract() {
        // je dois ajouter un contrat et une equipe pour que ça puisse me créer l'étudiant et l'affecter a un contrat et une équipe
        Integer contratId = 1;
        Integer equipeId = 1;
        Etudiant resultEtudiant = iEtudiantService.addAndAssignEtudiantToEquipeAndContract(EtudiantServiceImplTest.etudiant, contratId, equipeId);
        Assertions.assertNotNull(resultEtudiant);
    }
    @Test
    @Order(8)
    public void testGetEtudiantsByDepartement() {
        Integer departementId = 1;
        List<Etudiant> etudiants = iEtudiantService.getEtudiantsByDepartement(departementId);
        Assertions.assertNotNull(etudiants);
    }*/
}


