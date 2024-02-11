package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;


import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentServiceImplTest {
    @Autowired
    IDepartementService iDepartementService;
    private static Departement departement = new Departement(1,"Marketing");

    @Test
    @Order(1)
    public void testRetrieveAllDepartments() {
        List<Departement> ListDepartment  = iDepartementService.retrieveAllDepartements();
        Assertions.assertNotNull(ListDepartment);
    }
    @Test
    @Order(2)
    void testAddDepartment() {
        Departement et = iDepartementService.addDepartement(DepartmentServiceImplTest.departement);
        Assertions.assertNotNull(et);
        DepartmentServiceImplTest.departement.setIdDepart(et.getIdDepart());
    }
    @Test
    @Order(3)
    public void testRemoveDepartment() {
        iDepartementService.deleteDepartement(DepartmentServiceImplTest.departement.getIdDepart());
    }

}
