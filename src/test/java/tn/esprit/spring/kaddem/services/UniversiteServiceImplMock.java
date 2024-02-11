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
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplMock {
    @Mock
    UniversiteRepository universiteRepository;


    @InjectMocks
    UniversiteServiceImpl universiteService;
    Universite universite = new Universite(2,"Esprit");
    Universite universite1 = new Universite(3,"TBS");

    @Test
    public void testRetrieveUniversite () {
        Mockito.when(universiteRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(universite));
        Universite universite1 = universiteService.retrieveUniversite(2);
        Assertions.assertNotNull(universite1, "The retrieved universite should not be null.");
    }
    @Test
    public void testRetrieveAllUniversite() {
        Mockito.when(universiteRepository.findAll()).thenReturn(Arrays.asList(universite1,universite));
        List<Universite> universites = universiteService.retrieveAllUniversites();
        Assertions.assertNotNull(universites, "The list of universites should not be null.");
        Assertions.assertEquals(2, universites.size(), "The expected size of the list is 2.");
    }
    @Test
    public void testAddUniversite() {
        Mockito.when(universiteRepository.save(Mockito.any(Universite.class))).thenReturn(universite1);
        Universite addedUniversite = universiteService.addUniversite(universite1);
        Assertions.assertNotNull(addedUniversite, "The added Universite should not be null.");
        Assertions.assertEquals(universite1.getNomUniv(), addedUniversite.getNomUniv(), "The expected name is '...'");
    }

    @Test
    public void testUpdateUniversite() {
        Mockito.when(universiteRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(universite));

        Universite existingUniversite = universiteService.retrieveUniversite(universite.getIdUniv());
        existingUniversite.setNomUniv("ESB");

        Mockito.when(universiteService.updateUniversite(existingUniversite)).thenReturn(existingUniversite);
        Universite updatedUniversite = universiteService.updateUniversite(existingUniversite);

        Assertions.assertNotNull(updatedUniversite, "The updated Universite should not be null.");
        Assertions.assertEquals("ESB", updatedUniversite.getNomUniv(), "The expected name is ''.");
    }
    @Test
    public void testRemoveUniversite() {
        Integer idToRemove = 2;
        Mockito.when(universiteRepository.findById(idToRemove)).thenReturn(Optional.of(universite));
        universiteService.deleteUniversite(idToRemove);
        Mockito.verify(universiteRepository, Mockito.times(1)).delete(universite);
    }



}
