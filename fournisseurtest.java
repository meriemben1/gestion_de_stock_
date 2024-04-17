import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import models.fournisseur;
import models.produit;

public class FournisseurTest {

    @Mock
    private List<produit> produitsMock;

    @InjectMocks
    private fournisseur fournisseurEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialiser les mocks avant chaque test
    }

    @Test
    public void testGettersAndSetters() {
        long id = 1L;
        String nom = "Fournisseur Test";
        String adresse = "Adresse test";
        int tel = 123456789;
        String email = "test@test.com";

        fournisseurEntity.setId(id);
        fournisseurEntity.setNom(nom);
        fournisseurEntity.setAdresse(adresse);
        fournisseurEntity.setTel(tel);
        fournisseurEntity.setEmail(email);

        assertEquals(id, fournisseurEntity.getId());
        assertEquals(nom, fournisseurEntity.getNom());
        assertEquals(adresse, fournisseurEntity.getAdresse());
        assertEquals(tel, fournisseurEntity.getTel());
        assertEquals(email, fournisseurEntity.getEmail());
    }

    @Test
    public void testProduitsList() {
        produit produit1 = new produit();
        produit produit2 = new produit();

        produitsMock = new ArrayList<>();
        produitsMock.add(produit1);
        produitsMock.add(produit2);

        fournisseurEntity.setProduits(produitsMock);

        assertEquals(2, fournisseurEntity.getProduits().size());
        assertTrue(fournisseurEntity.getProduits().contains(produit1));
        assertTrue(fournisseurEntity.getProduits().contains(produit2));
    }
}
