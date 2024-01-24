package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplMock {
    @Mock
    EtudiantRepository etudiantRepository;
    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    EtudiantServiceImpl etudiantService;
    Etudiant etudiant = new Etudiant(2,"Jaziri","aziz", Option.GAMIX);
    Etudiant etudiant1 = new Etudiant(3,"Jaziri1","aziz1", Option.GAMIX);
    Departement departement = new Departement(2,"Marketing");

    @Test
    public void testRetrieveEtudiant () {
        Mockito.when(etudiantRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(etudiant));
        Etudiant etudiant1 = etudiantService.retrieveEtudiant(2);
        Assertions.assertNotNull(etudiant1, "The retrieved etudiant should not be null.");
    }
    @Test
    public void testRetrieveAllEtudiants() {
        Mockito.when(etudiantRepository.findAll()).thenReturn(Arrays.asList(etudiant1,etudiant));
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();
        Assertions.assertNotNull(etudiants, "The list of etudiants should not be null.");
        Assertions.assertEquals(2, etudiants.size(), "The expected size of the list is 2.");
    }
    @Test
    public void testAddEtudiant() {
        Mockito.when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant1);
        Etudiant addedEtudiant = etudiantService.addEtudiant(etudiant1);
        Assertions.assertNotNull(addedEtudiant, "The added etudiant should not be null.");
        Assertions.assertEquals(etudiant1.getNomE(), addedEtudiant.getNomE(), "The expected name is '...'");
        Assertions.assertEquals(etudiant1.getPrenomE(), addedEtudiant.getPrenomE(), "The expected prenom is '...'");
    }

    @Test
    public void testUpdateEtudiant() {
        Mockito.when(etudiantRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(etudiant));

        Etudiant existingEtudiant = etudiantService.retrieveEtudiant(etudiant.getIdEtudiant());
        existingEtudiant.setNomE("azizz");
        existingEtudiant.setPrenomE("azizz");
        existingEtudiant.setOp(Option.NIDS);

        Mockito.when(etudiantService.updateEtudiant(existingEtudiant)).thenReturn(existingEtudiant);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(existingEtudiant);

        Assertions.assertNotNull(updatedEtudiant, "The updated etudiant should not be null.");
        Assertions.assertEquals("azizz", updatedEtudiant.getNomE(), "The expected name is 'azizz'.");
        Assertions.assertEquals("azizz", updatedEtudiant.getPrenomE(), "The expected prenom is 'azizz'.");
        Assertions.assertEquals(Option.NIDS, updatedEtudiant.getOp(), "The expected option is 'NIDS'.");
    }
    @Test
    public void testRemoveEtudiant() {
        Integer idToRemove = 2;
        Mockito.when(etudiantRepository.findById(idToRemove)).thenReturn(Optional.of(etudiant));
        etudiantService.removeEtudiant(idToRemove);
        Mockito.verify(etudiantRepository, Mockito.times(1)).delete(etudiant);
    }
    @Test
    public void testAssignEtudiantToDepartement() {
        Mockito.when(etudiantRepository.findById(etudiant.getIdEtudiant())).thenReturn(Optional.of(etudiant));
        Mockito.when(departementRepository.findById(departement.getIdDepart())).thenReturn(Optional.of(departement));

        etudiantService.assignEtudiantToDepartement(etudiant.getIdEtudiant(), departement.getIdDepart());

        Mockito.verify(etudiantRepository, Mockito.times(1)).findById(etudiant.getIdEtudiant());
        Mockito.verify(departementRepository, Mockito.times(1)).findById(departement.getIdDepart());
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(etudiant);
    }



}
