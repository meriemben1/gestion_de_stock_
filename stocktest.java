import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import models.stock;
import repository.stockrep;
import service.stockimp;

@DataJpaTest
public class stockimpTest {

    @Autowired
    private stockrep stockRepo;

    private stockimp stockService;

    @Before
    public void setup() {
        stockService = new stockimp(stockRepo);
    }

    @Test
    public void testAddStock() {
        int qnt = 100;
        int s_min = 50;
        int s_max = 200;
        long produitId = 1; // ID factice du produit associé

        stockService.addstock(qnt, s_min, s_max, produitId);

        // Récupération du stock depuis la base de données
        stock s = stockRepo.findByQnt(qnt);
        assertNotNull(s);
        assertEquals(qnt, s.getQnt());
        assertEquals(s_min, s.getS_min());
        assertEquals(s_max, s.getS_max());
        assertEquals(produitId, s.getProduit().getId());
    }

    @Test
    public void testEditStock() {
        int qnt = 100;
        int s_min = 50;
        int s_max = 200;
        long produitId = 1; // ID factice du produit associé

        stockService.addstock(qnt, s_min, s_max, produitId);
        stock s = stockRepo.findByQnt(qnt);

        int newQnt = 150;
        int newS_min = 75;
        int newS_max = 300;
        long newProduitId = 2; // Nouvel ID factice du produit associé

        stockService.editstock(s.getId(), newQnt, newS_min, newS_max, newProduitId);

        // Récupération du stock modifié depuis la base de données
        stock editedStock = stockRepo.findById(s.getId()).orElse(null);
        assertNotNull(editedStock);
        assertEquals(newQnt, editedStock.getQnt());
        assertEquals(newS_min, editedStock.getS_min());
        assertEquals(newS_max, editedStock.getS_max());
        assertEquals(newProduitId, editedStock.getProduit().getId());
    }

    // Les autres tests (deleteStock, getStock, getAllStock) peuvent être écrits de manière similaire
}
