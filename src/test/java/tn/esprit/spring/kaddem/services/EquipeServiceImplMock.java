package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EquipeServiceImplMock {
    @Mock
    EquipeRepository equipeRepository;
    Equipe equipe = new Equipe(1,"samar", Niveau.EXPERT);
    Equipe equipe1 = new Equipe(2,"saidana", Niveau.EXPERT);

    @InjectMocks
    EquipeServiceImpl equipeService;
    @Test
    public void testRetrieveEquipe () {
        Mockito.when(equipeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(equipe));
        Equipe equipe1 = equipeService.retrieveEquipe(1);
        Assertions.assertNotNull(equipe1, "The retrieved equipe should not be null.");
    }
    @Test
    public void testRetrieveAllEquipes() {
        Mockito.when(equipeRepository.findAll()).thenReturn(Arrays.asList(equipe1,equipe));
        List<Equipe> equipes = equipeService.retrieveAllEquipes();
        Assertions.assertNotNull(equipes, "The list of equipes should not be null.");
        Assertions.assertEquals(2, equipes.size(), "The expected size of the list is 2.");
    }
    @Test
    public void testAddEquipe() {
        Mockito.when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(equipe1);
        Equipe addedEquipe = equipeService.addEquipe(equipe1);
        Assertions.assertNotNull(addedEquipe, "The added equipe should not be null.");
        Assertions.assertEquals(equipe1.getNomEquipe(), addedEquipe.getNomEquipe(), "The expected name is '...'");
        Assertions.assertEquals(addedEquipe.getNomEquipe(), addedEquipe.getNomEquipe(), "The expected prenom is '...'");
    }
}
