import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import models.user;

public class UserTest {

    @InjectMocks
    private user userEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialiser les mocks avant chaque test
    }

    @Test
    public void testGettersAndSetters() {
        long id = 1L;
        String mdp = "password";
        String role = "admin";

        userEntity.setId(id);
        userEntity.setMdp(mdp);
        userEntity.setRole(role);

        assertEquals(id, userEntity.getId());
        assertEquals(mdp, userEntity.getMdp());
        assertEquals(role, userEntity.getRole());
    }
}
