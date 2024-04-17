import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import models.stock;
import models.produit;

public class StockTest {

    @Mock
    private produit produitMock;

    @InjectMocks
    private stock stockEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialiser les mocks avant chaque test
    }

    @Test
    public void testGettersAndSetters() {
        long id = 1L;
        int qnt = 100;
        int s_min = 50;
        int s_max = 200;

        stockEntity.setId(id);
        stockEntity.setQnt(qnt);
        stockEntity.setS_min(s_min);
        stockEntity.setS_max(s_max);

        assertEquals(id, stockEntity.getId());
        assertEquals(qnt, stockEntity.getQnt());
        assertEquals(s_min, stockEntity.getS_min());
        assertEquals(s_max, stockEntity.getS_max());
    }

    @Test
    public void testProduitAssociation() {
        stockEntity.setProduit(produitMock);

        assertEquals(produitMock, stockEntity.getProduit());
    }
}
