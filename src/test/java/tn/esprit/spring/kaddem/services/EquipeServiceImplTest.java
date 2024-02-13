package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EquipeServiceImplTest {
   /* @Autowired
    IEquipeService iEquipeService;
    private static Equipe equipe = new Equipe(2,"samar", Niveau.EXPERT);
    @Test
    @Order(1)
    public void testRetrieveAllEquipes() {
        List<Equipe> listEquipe  = iEquipeService.retrieveAllEquipes();
        Assertions.assertNotNull(listEquipe);
    }
    @Test
    @Order(2)
    void testAddEquipe() {
        Equipe et = iEquipeService.addEquipe(EquipeServiceImplTest.equipe);
        Assertions.assertNotNull(et);
        EquipeServiceImplTest.equipe.setIdEquipe(et.getIdEquipe());
    }
    @Test
    @Order(3)
    public void testUpdateEquipe() {
        Equipe existingEquipe = iEquipeService.retrieveEquipe(EquipeServiceImplTest.equipe.getIdEquipe());
        System.out.println("Before Update - Existing Equipe: " + existingEquipe);
        existingEquipe.setNomEquipe("new equipe");
        Equipe updatedEquipe = iEquipeService.updateEquipe(existingEquipe);
        System.out.println("After Update - Updated Equipe: " + updatedEquipe.getNomEquipe());
    }

    @Test
    @Order(4)
    public void testRetrieveEquipe() {
        Equipe retrievedEquipe = iEquipeService.retrieveEquipe(EquipeServiceImplTest.equipe.getIdEquipe());
        System.out.println("Retrieved Equipe:");
        System.out.println("ID: " + retrievedEquipe.getIdEquipe());
        System.out.println("Nom: " + retrievedEquipe.getNomEquipe());
        System.out.println("Niveau: " + retrievedEquipe.getNiveau());
        Assertions.assertNotNull(retrievedEquipe);
    }
    @Test
    @Order(5)
    public void testRemoveEquipe() {
        iEquipeService.deleteEquipe(EquipeServiceImplTest.equipe.getIdEquipe());
    }*/
}
