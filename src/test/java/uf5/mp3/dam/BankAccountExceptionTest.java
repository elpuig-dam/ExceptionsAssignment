package uf5.mp3.dam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountExceptionTest {
    CompteEstalvi c;

    @Before
    public void setUp() {
        c = new CompteEstalvi("00001");
        Client client = null;
        client = new Client("Jordi", "Hdez", "123456789");
        c.addUser(client);
    }

    @Test
    public void removeLastUserOfBankAccountTest() {
        try {
            c.removeUser(c.getLlista_usuaris().get(0).getDNI());
        } catch (BankAccountException e) {
            assertEquals(e.getMessage(),ExceptionMessage.ACCOUNT_ZERO_USER);
        }
        assertEquals(c.getLlista_usuaris().size(),1);
    }

    @Test
    public void removeNoLastUserOfBankAccountTest() {
        Client client = null;
        client = new Client("Joan","Prez","987654321");
        c.addUser(client);
        try {
            c.removeUser("987654321");
        } catch (BankAccountException e) {
            assertEquals(e.getMessage(),null);
        }
        assertEquals(c.getLlista_usuaris().size(),1);
    }



}
