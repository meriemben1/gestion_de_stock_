import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import models.user;
import repository.userrep;
import service.userimp;

@DataJpaTest
public class userimpTest {

    @Autowired
    private userrep userRepo;

    private userimp userService;

    @Before
    public void setup() {
        userService = new userimp(userRepo);
    }

    @Test
    public void testAddUser() {
        String mdp = "password123";
        String role = "ROLE_USER";

        userService.addUser(mdp, role);

        // Récupération de l'utilisateur depuis la base de données
        List<user> users = userRepo.findAll();
        assertNotNull(users);
        assertEquals(1, users.size());
        user u = users.get(0);
        assertEquals(mdp, u.getMdp());
        assertEquals(role, u.getRole());
    }

    @Test
    public void testEditUser() {
        String mdp = "password123";
        String role = "ROLE_USER";

        userService.addUser(mdp, role);
        List<user> users = userRepo.findAll();
        user u = users.get(0);

        String newMdp = "newpassword456";
        String newRole = "ROLE_ADMIN";

        userService.editUser(u.getId(), newMdp, newRole);

        // Récupération de l'utilisateur modifié depuis la base de données
        user editedUser = userRepo.findById(u.getId()).orElse(null);
        assertNotNull(editedUser);
        assertEquals(newMdp, editedUser.getMdp());
        assertEquals(newRole, editedUser.getRole());
    }

    // Les autres tests (deleteUser, getUser, getAllUser) peuvent être écrits de manière similaire
}
