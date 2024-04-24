import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import models.fournisseur;
import repository.fournissuerrep;
import service.fournisseurimp;

@DataJpaTest
public class fournisseurimpTest {

    @Autowired
    private fournissuerrep fournisseurRepo;

    private fournisseurimp fournisseurService;

    @Before
    public void setup() {
        fournisseurService = new fournisseurimp(fournisseurRepo);
    }

    @Test
    public void testAddFournisseur() {
        String nom = "FournisseurTest";
        String adresse = "123 Rue du Test";
        int tel = 123456789;
        String email = "test@example.com";

        fournisseurService.addFournisseur(nom, adresse, tel, email);

        // Récupération du fournisseur depuis la base de données
        fournisseur f = fournisseurRepo.findByNom(nom);
        assertNotNull(f);
        assertEquals(nom, f.getNom());
        assertEquals(adresse, f.getAdresse());
        assertEquals(tel, f.getTel());
        assertEquals(email, f.getEmail());
    }

    @Test
    public void testEditFournisseur() {
        String nom = "FournisseurTest";
        String adresse = "123 Rue du Test";
        int tel = 123456789;
        String email = "test@example.com";

        fournisseurService.addFournisseur(nom, adresse, tel, email);
        fournisseur f = fournisseurRepo.findByNom(nom);

        String newNom = "NouveauFournisseur";
        String newAdresse = "456 Rue du Nouveau";
        int newTel = 987654321;
        String newEmail = "nouveau@test.com";

        fournisseurService.editFournisseur(f.getId(), newNom, newAdresse, newTel, newEmail);

        // Récupération du fournisseur modifié depuis la base de données
        fournisseur editedFournisseur = fournisseurRepo.findById(f.getId()).orElse(null);
        assertNotNull(editedFournisseur);
        assertEquals(newNom, editedFournisseur.getNom());
        assertEquals(newAdresse, editedFournisseur.getAdresse());
        assertEquals(newTel, editedFournisseur.getTel());
        assertEquals(newEmail, editedFournisseur.getEmail());
    }

    // Les autres tests (deleteFournisseur, getFournisseur, getAllFournisseur) peuvent être écrits de manière similaire
}
