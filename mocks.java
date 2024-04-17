//pour la classe commandeimp
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementation.commandeimp;
import models.commande;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommandeImpTest {

    private commandeimp commandeService;
    private commanderep mockCommandeRepo;

    @BeforeEach
    public void setUp() {
        // Création d'un mock pour commanderep
        mockCommandeRepo = mock(commanderep.class);
        commandeService = new commandeimp();
        // Injection du mock dans la commandeimp
        ((commandeimp) commandeService).setCommanderepo(mockCommandeRepo);
    }

    @Test
    public void testAddCommande() {
        // Données de test
        int qnt = 10;
        Date date = Date.valueOf("2024-04-17");
        String statut = "En cours";

        // Appel de la méthode addCommande
        commandeService.addCommande(qnt, date, statut);

        // Vérification que la méthode save du mock a été appelée une fois avec le bon objet commande en argument
        verify(mockCommandeRepo, times(1)).save(any(commande.class));
    }

    @Test
    public void testEditCommande() {
        // Données de test
        long id = 1;
        int qnt = 15;
        Date date = Date.valueOf("2024-04-18");
        String statut = "Terminé";

        // Mock du retour de findById
        commande mockCommande = new commande(id, 10, Date.valueOf("2024-04-17"), "En cours");
        when(mockCommandeRepo.findById(id)).thenReturn(Optional.of(mockCommande));

        // Appel de la méthode editCommande
        commandeService.editCommande(id, qnt, date, statut);

        // Vérification que la méthode save du mock a été appelée une fois avec le bon objet commande en argument
        verify(mockCommandeRepo, times(1)).save(any(commande.class));
    }

    @Test
    public void testDeleteCommande() {
        // Données de test
        long id = 1;

        // Appel de la méthode deleteCommande
        commandeService.deleteCommande(id);

        // Vérification que la méthode deleteById du mock a été appelée une fois avec le bon ID en argument
        verify(mockCommandeRepo, times(1)).deleteById(id);
    }

    @Test
    public void testGetCommande() {
        // Données de test
        long id = 1;

        // Mock du retour de findById
        commande mockCommande = new commande(id, 10, Date.valueOf("2024-04-17"), "En cours");
        when(mockCommandeRepo.findById(id)).thenReturn(Optional.of(mockCommande));

        // Appel de la méthode getCommande
        commande resultCommande = commandeService.getCommande(id);

        // Vérification que la méthode findById du mock a été appelée une fois avec le bon ID en argument
        verify(mockCommandeRepo, times(1)).findById(id);
        // Vérification que le résultat retourné est le bon objet commande
        assertEquals(mockCommande, resultCommande);
    }

    @Test
    public void testGetAllCommande() {
        // Mock du retour de findAll
        List<commande> mockCommandes = new ArrayList<>();
        mockCommandes.add(new commande(1, 10, Date.valueOf("2024-04-17"), "En cours"));
        mockCommandes.add(new commande(2, 20, Date.valueOf("2024-04-18"), "Terminé"));
        when(mockCommandeRepo.findAll()).thenReturn(mockCommandes);

        // Appel de la méthode getAllCommande
        List<commande> resultCommandes = commandeService.getAllCommande();

        // Vérification que la méthode findAll du mock a été appelée une fois
        verify(mockCommandeRepo, times(1)).findAll();
        // Vérification que le résultat retourné est la bonne liste de commandes
        assertEquals(mockCommandes, resultCommandes);
    }
}

//pour la classe fournisseurimp
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FournisseurImpTest {

    private fournisseurimp fournisseurService;
    private fournisseurRep mockFournisseurRep;

    @BeforeEach
    public void setUp() {
        mockFournisseurRep = mock(fournisseurRep.class);
        fournisseurService = new fournisseurimp();
        ((fournisseurimp) fournisseurService).setFourni(mockFournisseurRep);
    }

    @Test
    public void testAddFournisseur() {
        String nom = "Fournisseur 1";
        String adresse = "Adresse fournisseur 1";
        int tel = 123456789;
        String email = "fournisseur1@example.com";

        fournisseurService.addFournisseur(nom, adresse, tel, email);

        verify(mockFournisseurRep, times(1)).save(any(fournisseur.class));
    }

    @Test
    public void testEditFournisseur() {
        long id = 1;
        String nom = "Nouveau nom";
        String adresse = "Nouvelle adresse";
        int tel = 987654321;
        String email = "nouveauemail@example.com";

        fournisseur mockFournisseur = new fournisseur(id, "Ancien nom", "Ancienne adresse", 123456789, "ancienemail@example.com");
        when(mockFournisseurRep.findById(id)).thenReturn(Optional.of(mockFournisseur));

        fournisseurService.editFournisseur(id, nom, adresse, tel, email);

        verify(mockFournisseurRep, times(1)).save(any(fournisseur.class));
    }

    @Test
    public void testDeleteFournisseur() {
        long id = 1;

        fournisseurService.deleteFournisseur(id);

        verify(mockFournisseurRep, times(1)).deleteById(id);
    }

    @Test
    public void testGetFournisseur() {
        long id = 1;
        fournisseur mockFournisseur = new fournisseur(id, "Fournisseur test", "Adresse test", 123456789, "test@example.com");
        when(mockFournisseurRep.findById(id)).thenReturn(Optional.of(mockFournisseur));

        fournisseur resultFournisseur = fournisseurService.getFournisseur(id);

        assertNotNull(resultFournisseur);
        assertEquals("Fournisseur test", resultFournisseur.getNom());
        assertEquals("Adresse test", resultFournisseur.getAdresse());
        assertEquals(123456789, resultFournisseur.getTel());
        assertEquals("test@example.com", resultFournisseur.getEmail());
    }

    @Test
    public void testGetAllFournisseur() {
        List<fournisseur> mockFournisseurs = new ArrayList<>();
        mockFournisseurs.add(new fournisseur(1, "Fournisseur 1", "Adresse 1", 111111111, "email1@example.com"));
        mockFournisseurs.add(new fournisseur(2, "Fournisseur 2", "Adresse 2", 222222222, "email2@example.com"));
        when(mockFournisseurRep.findAll()).thenReturn(mockFournisseurs);

        List<fournisseur> resultFournisseurs = fournisseurService.getAllFournisseur();

        assertNotNull(resultFournisseurs);
        assertEquals(2, resultFournisseurs.size());
        assertEquals("Fournisseur 1", resultFournisseurs.get(0).getNom());
        assertEquals("Fournisseur 2", resultFournisseurs.get(1).getNom());
    }
}
//pour la classe produitimp
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProduitImpTest {

    private produitimp produitService;
    private produitrep mockProduitRep;

    @BeforeEach
    public void setUp() {
        mockProduitRep = mock(produitrep.class);
        produitService = new produitimp();
        ((produitimp) produitService).setProd(mockProduitRep);
    }

    @Test
    public void testAddProduit() {
        String name = "Produit 1";
        String desc = "Description produit 1";
        double prix = 100.0;

        produitService.addProduit(name, desc, prix);

        verify(mockProduitRep, times(1)).save(any(produit.class));
    }

    @Test
    public void testEditProduit() {
        long id = 1;
        String name = "Nouveau produit";
        String desc = "Nouvelle description";
        double prix = 150.0;

        produit mockProduit = new produit(id, "Ancien produit", "Ancienne description", 100.0);
        when(mockProduitRep.findById(id)).thenReturn(Optional.of(mockProduit));

        produitService.editProduit(id, name, desc, prix);

        verify(mockProduitRep, times(1)).save(any(produit.class));
    }

    @Test
    public void testDeleteProduit() {
        long id = 1;

        produitService.deleteProduit(id);

        verify(mockProduitRep, times(1)).deleteById(id);
    }

    @Test
    public void testGetProduit() {
        long id = 1;
        produit mockProduit = new produit(id, "Produit test", "Description test", 100.0);
        when(mockProduitRep.findById(id)).thenReturn(Optional.of(mockProduit));

        produit resultProduit = produitService.getProduit(id);

        assertNotNull(resultProduit);
        assertEquals("Produit test", resultProduit.getName());
        assertEquals("Description test", resultProduit.getDesc());
        assertEquals(100.0, resultProduit.getPrix());
    }

    @Test
    public void testGetAllProduit() {
        List<produit> mockProduits = new ArrayList<>();
        mockProduits.add(new produit(1, "Produit 1", "Description 1", 100.0));
        mockProduits.add(new produit(2, "Produit 2", "Description 2", 150.0));
        when(mockProduitRep.findAll()).thenReturn(mockProduits);

        List<produit> resultProduits = produitService.getAllProduit();

        assertNotNull(resultProduits);
        assertEquals(2, resultProduits.size());
        assertEquals("Produit 1", resultProduits.get(0).getName());
        assertEquals("Produit 2", resultProduits.get(1).getName());
    }
}
//pour la classe stockimp
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockImpTest {

    private stockimp stockService;
    private stockrep mockStockRep;

    @BeforeEach
    public void setUp() {
        mockStockRep = mock(stockrep.class);
        stockService = new stockimp();
        ((stockimp) stockService).setStockrepo(mockStockRep);
    }

    @Test
    public void testAddStock() {
        int qnt = 50;
        int s_min = 10;
        int s_max = 100;
        long produitId = 1;

        stockService.addstock(qnt, s_min, s_max, produitId);

        verify(mockStockRep, times(1)).save(any(stock.class));
    }

    @Test
    public void testEditStock() {
        long id = 1;
        int qnt = 100;
        int s_min = 20;
        int s_max = 150;
        long produitId = 2;

        stock mockStock = new stock(id, 50, 10, 100);
        when(mockStockRep.findById(id)).thenReturn(Optional.of(mockStock));

        stockService.editstock(id, qnt, s_min, s_max, produitId);

        verify(mockStockRep, times(1)).save(any(stock.class));
    }

    @Test
    public void testDeleteStock() {
        long id = 1;

        stockService.deleteStock(id);

        verify(mockStockRep, times(1)).deleteById(id);
    }

    @Test
    public void testGetStock() {
        long id = 1;
        stock mockStock = new stock(id, 50, 10, 100);
        when(mockStockRep.findById(id)).thenReturn(Optional.of(mockStock));

        stock resultStock = stockService.getStock(id);

        assertNotNull(resultStock);
        assertEquals(50, resultStock.getQnt());
        assertEquals(10, resultStock.getS_min());
        assertEquals(100, resultStock.getS_max());
    }

    @Test
    public void testGetAllStock() {
        List<stock> mockStocks = new ArrayList<>();
        mockStocks.add(new stock(1, 50, 10, 100));
        mockStocks.add(new stock(2, 100, 20, 150));
        when(mockStockRep.findAll()).thenReturn(mockStocks);

        List<stock> resultStocks = stockService.getAllStock();

        assertNotNull(resultStocks);
        assertEquals(2, resultStocks.size());
        assertEquals(50, resultStocks.get(0).getQnt());
        assertEquals(100, resultStocks.get(1).getQnt());
    }
}
//pour la classe userimp
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserImpTest {

    private userimp userService;
    private userrep mockUserRep;

    @BeforeEach
    public void setUp() {
        mockUserRep = mock(userrep.class);
        userService = new userimp();
        ((userimp) userService).setUserrepo(mockUserRep);
    }

    @Test
    public void testAddUser() {
        String mdp = "password";
        String role = "admin";

        userService.addUser(mdp, role);

        verify(mockUserRep, times(1)).save(any(user.class));
    }

    @Test
    public void testEditUser() {
        long id = 1;
        String mdp = "newpassword";
        String role = "user";

        user mockUser = new user(id, "password", "admin");
        when(mockUserRep.findById(id)).thenReturn(Optional.of(mockUser));

        userService.editUser(id, mdp, role);

        verify(mockUserRep, times(1)).save(any(user.class));
    }

    @Test
    public void testDeleteUser() {
        long id = 1;

        userService.deleteUser(id);

        verify(mockUserRep, times(1)).deleteById(id);
    }

    @Test
    public void testGetUser() {
        long id = 1;
        user mockUser = new user(id, "password", "admin");
        when(mockUserRep.findById(id)).thenReturn(Optional.of(mockUser));

        user resultUser = userService.getUser(id);

        assertNotNull(resultUser);
        assertEquals("password", resultUser.getMdp());
        assertEquals("admin", resultUser.getRole());
    }

    @Test
    public void testGetAllUser() {
        List<user> mockUsers = new ArrayList<>();
        mockUsers.add(new user(1, "password1", "admin"));
        mockUsers.add(new user(2, "password2", "user"));
        when(mockUserRep.findAll()).thenReturn(mockUsers);

        List<user> resultUsers = userService.getAllUser();

        assertNotNull(resultUsers);
        assertEquals(2, resultUsers.size());
        assertEquals("password1", resultUsers.get(0).getMdp());
        assertEquals("password2", resultUsers.get(1).getMdp());
    }
}

