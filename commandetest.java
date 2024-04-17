import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import models.commande;
import models.produit;

public class CommandeTest {

    @Mock
    private List<produit> produitsMock;

    @InjectMocks
    private commande commandeEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialiser les mocks avant chaque test
    }

    @Test
    public void testGettersAndSetters() {
        long id = 1L;
        int qnt = 5;
        Date date = new Date(System.currentTimeMillis());
        String statut = "En cours";

        commandeEntity.setId(id);
        commandeEntity.setQnt(qnt);
        commandeEntity.setDate(date);
        commandeEntity.setStatut(statut);

        assertEquals(id, commandeEntity.getId());
        assertEquals(qnt, commandeEntity.getQnt());
        assertEquals(date, commandeEntity.getDate());
        assertEquals(statut, commandeEntity.getStatut());
    }

    @Test
    public void testProduitsList() {
        produit produit1 = new produit();
        produit produit2 = new produit();

        produitsMock = new ArrayList<>();
        produitsMock.add(produit1);
        produitsMock.add(produit2);

        commandeEntity.setProduits(produitsMock);

        assertEquals(2, commandeEntity.getProduits().size());
        assertTrue(commandeEntity.getProduits().contains(produit1));
        assertTrue(commandeEntity.getProduits().contains(produit2));
    }
}
