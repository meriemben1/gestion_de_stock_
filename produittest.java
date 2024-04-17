import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.produitimp;
import repository.produitrep;
import models.produit;

public class produitimpTest {

    @Mock
    private produitrep produitRepositoryMock;

    @InjectMocks
    private produitimp produitService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialiser les mocks avant chaque test
    }

    @Test
    public void testAddProduit() {
        produit p = new produit();
        p.setName("Produit test");
        p.setDesc("Description test");
        p.setPrix(10.0);

        produitService.addProduit("Produit test", "Description test", 10.0, 1L, 1L);

        verify(produitRepositoryMock).save(p);
    }

    @Test
    public void testEditProduit() {
        produit p = new produit();
        p.setId(1L);
        p.setName("Produit modifié");
        p.setDesc("Description modifiée");
        p.setPrix(20.0);

        when(produitRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(p));

        produitService.editProduit(1L, "Produit modifié", "Description modifiée", 20.0, 1L, 1L);

        verify(produitRepositoryMock).save(p);
    }

    @Test
    public void testDeleteProduit() {
        produitService.deleteProduit(1L);

        verify(produitRepositoryMock).deleteById(1L);
    }

    @Test
    public void testGetProduit() {
        produit p = new produit();
        p.setId(1L);
        p.setName("Produit test");
        p.setDesc("Description test");
        p.setPrix(10.0);

        when(produitRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(p));

        produit result = produitService.getProduit(1L);

        assertEquals(p, result);
    }

    @Test
    public void testGetAllProduit() {
        produit p1 = new produit();
        p1.setId(1L);
        p1.setName("Produit 1");
        p1.setDesc("Description produit 1");
        p1.setPrix(10.0);

        produit p2 = new produit();
        p2.setId(2L);
        p2.setName("Produit 2");
        p2.setDesc("Description produit 2");
        p2.setPrix(20.0);

        List<produit> produits = new ArrayList<>();
        produits.add(p1);
        produits.add(p2);

        when(produitRepositoryMock.findAll()).thenReturn(produits);

        List<produit> result = produitService.getAllProduit();

        assertEquals(2, result.size());
        assertEquals(p1, result.get(0));
        assertEquals(p2, result.get(1));
    }
}
