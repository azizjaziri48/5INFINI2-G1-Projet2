package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EtudiantServiceImplTest {
    @Autowired
     IEtudiantService iEtudiantService;
    private static Etudiant etudiant = new Etudiant(2,"Jaziri","aziz", Option.GAMIX);

   @Test
    @Order(1)
    public void testRetrieveAllEtudiants() {
        List<Etudiant> listEtudiant  = iEtudiantService.retrieveAllEtudiants();
        Assertions.assertNotNull(listEtudiant);
    }
    @Test
    @Order(2)
    void testAddEtudiant() {
        Etudiant et = iEtudiantService.addEtudiant(EtudiantServiceImplTest.etudiant);
        Assertions.assertNotNull(et);
        EtudiantServiceImplTest.etudiant.setIdEtudiant(et.getIdEtudiant());
    }
    @Test
    @Order(3)
    public void testUpdateEtudiant() {
        Etudiant existingEtudiant = iEtudiantService.retrieveEtudiant(EtudiantServiceImplTest.etudiant.getIdEtudiant());
        System.out.println("Before Update - Existing Etudiant: " + existingEtudiant);
        existingEtudiant.setNomE("neww");
        Etudiant updatedEtudiant = iEtudiantService.updateEtudiant(existingEtudiant);
        System.out.println("After Update - Updated Etudiant: " + updatedEtudiant.getNomE());
    }

    @Test
    @Order(4)
    public void testRetrieveEtudiant() {
        Etudiant retrievedEtudiant = iEtudiantService.retrieveEtudiant(EtudiantServiceImplTest.etudiant.getIdEtudiant());
        System.out.println("Retrieved Etudiant:");
        System.out.println("ID: " + retrievedEtudiant.getIdEtudiant());
        System.out.println("Nom: " + retrievedEtudiant.getNomE());
        System.out.println("Prenom: " + retrievedEtudiant.getPrenomE());
        System.out.println("Option: " + retrievedEtudiant.getOp());
        Assertions.assertNotNull(retrievedEtudiant);
    }
    @Test
    @Order(5)
    public void testRemoveEtudiant() {
        iEtudiantService.removeEtudiant(EtudiantServiceImplTest.etudiant.getIdEtudiant());
    }
    @Test
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
    }
}
