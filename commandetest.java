// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import models.commande;
import repository.commanderep;
import service.commandeimp;
//La classe commandeimpTest est déclarée et annotée avec @DataJpaTest pour indiquer à Spring Boot de configurer un environnement de test de base de données en mémoire pour cette classe.
@DataJpaTest
public class commandeimpTest {

    @Autowired
    private commanderep commandeRepo;

    private commandeimp commandeService;
//@Before : Cette annotation indique que la méthode setup doit être exécutée avant chaque test.
    @Before
    public void setup() {
        commandeService = new commandeimp(commandeRepo);
    }

    @Test
    public void testAddCommande() {
       
        int qnt = 5;
        Date date = new Date(System.currentTimeMillis());
        String statut = "En cours";

       
        commandeService.addCommande(qnt, date, statut);


        List<commande> commandes = commandeRepo.findAll();
        assertEquals(1, commandes.size());
        commande c = commandes.get(0);
        assertEquals(qnt, c.getQnt());
        assertEquals(date, c.getDate());
        assertEquals(statut, c.getStatut());
    }

    @Test
    public void testEditCommande() {
        
        int qnt = 10;
        Date date = new Date(System.currentTimeMillis());
        String statut = "Termine";
        commande c = new commande();
        c.setQnt(5);
        c.setDate(new Date(System.currentTimeMillis()));
        c.setStatut("En cours");
        commandeRepo.save(c);

        
        commandeService.editCommande(c.getId(), qnt, date, statut);

        
        commande editedCommande = commandeRepo.findById(c.getId()).orElse(null);
        assertNotNull(editedCommande);
        assertEquals(qnt, editedCommande.getQnt());
        assertEquals(date, editedCommande.getDate());
        assertEquals(statut, editedCommande.getStatut());
    }

    
}
