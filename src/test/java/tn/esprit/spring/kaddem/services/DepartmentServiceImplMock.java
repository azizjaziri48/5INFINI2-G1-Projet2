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
public class DepartmentServiceImplMock {
    @Mock
    DepartementRepository departementRepository;


    @InjectMocks
    DepartementServiceImpl departementService;
    Departement dep1 = new Departement(3,"RH");
    Departement dep2 = new Departement(4,"Finance");
    @Test
    public void testRetrieveDepartment () {
        Mockito.when(departementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(dep1));
        Departement departement1 = departementService.retrieveDepartement(2);
        Assertions.assertNotNull(departement1, "The retrieved dep should not be null.");
    }
    @Test
    public void testRetrieveAllDepartment() {
        Mockito.when(departementRepository.findAll()).thenReturn(Arrays.asList(dep1,dep2));
        List<Departement> Departements = departementService.retrieveAllDepartements();
        Assertions.assertNotNull(Departements, "The list of dep should not be null.");
        Assertions.assertEquals(2, Departements.size(), "The expected size of the list is 2.");
    }
    @Test
    public void testAddDepartement() {
        Mockito.when(departementRepository.save(Mockito.any(Departement.class))).thenReturn(dep1);
        Departement addedDepart = departementService.addDepartement(dep1);
        Assertions.assertNotNull(addedDepart, "The added dep should not be null.");
        Assertions.assertEquals(dep1.getNomDepart(), addedDepart.getNomDepart(), "The expected name is '...'");
    }


}
