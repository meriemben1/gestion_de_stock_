import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import models.produit;
import repository.produitrep;
import service.produitimp;

@DataJpaTest
public class produitimpTest {

    @Autowired
    private produitrep produitRepo;

    private produitimp produitService;

    @Before
    public void setup() {
        produitService = new produitimp(produitRepo);
    }

    @Test
    public void testAddProduit() {
        String name = "ProduitTest";
        String desc = "Description du produit test";
        double prix = 99.99;
        long commandeId = 1; // ID factice de la commande associée
        long fournisseurId = 1; // ID factice du fournisseur associé

        produitService.addProduit(name, desc, prix, commandeId, fournisseurId);

        // Récupération du produit depuis la base de données
        produit p = produitRepo.findByName(name);
        assertNotNull(p);
        assertEquals(name, p.getName());
        assertEquals(desc, p.getDesc());
        assertEquals(prix, p.getPrix(), 0.001); // Comparaison avec une précision de 0.001
        assertEquals(commandeId, p.getCommande().getId());
        assertEquals(fournisseurId, p.getFournisseur().getId());
    }

    @Test
    public void testEditProduit() {
        String name = "ProduitTest";
        String desc = "Description du produit test";
        double prix = 99.99;
        long commandeId = 1; // ID factice de la commande associée
        long fournisseurId = 1; // ID factice du fournisseur associé

        produitService.addProduit(name, desc, prix, commandeId, fournisseurId);
        produit p = produitRepo.findByName(name);

        String newName = "NouveauProduit";
        String newDesc = "Nouvelle description";
        double newPrix = 149.99;
        long newCommandeId = 2; // Nouvel ID factice de commande
        long newFournisseurId = 2; // Nouvel ID factice de fournisseur

        produitService.editProduit(p.getId(), newName, newDesc, newPrix, newCommandeId, newFournisseurId);

        // Récupération du produit modifié depuis la base de données
        produit editedProduit = produitRepo.findById(p.getId()).orElse(null);
        assertNotNull(editedProduit);
        assertEquals(newName, editedProduit.getName());
        assertEquals(newDesc, editedProduit.getDesc());
        assertEquals(newPrix, editedProduit.getPrix(), 0.001);
        assertEquals(newCommandeId, editedProduit.getCommande().getId());
        assertEquals(newFournisseurId, editedProduit.getFournisseur().getId());
    }

    // Les autres tests (deleteProduit, getProduit, getAllProduit) peuvent être écrits de manière similaire
}
