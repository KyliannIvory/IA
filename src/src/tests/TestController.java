package tests;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestController {

    @Test
    void testAbleToFill(){
        Controller controller = new Controller();
        boolean resultat = controller.ableToFill(0,0);
        assertFalse(resultat,"il devrait etre impossible de remplir donc faux...");

        resultat = controller.ableToFill(1,0);
        assertTrue(resultat,"il devrait etre possible de remplir donc vrai...");

        resultat = controller.ableToFill(0,1);
        assertTrue(resultat,"il devrait etre possible de remplir donc vrai...");

        resultat = controller.ableToFill(1,1);
        assertTrue(resultat,"il devrait etre possible de remplir donc vrai...");
    }

    @Test
    void testAbleToEmpty(){
        Controller controller = new Controller();
        boolean resultat = controller.ableToEmpty(0,0);
        assertFalse(resultat,"il devrait etre impossible de vider donc faux...");

        resultat = controller.ableToEmpty(1,0);
        assertTrue(resultat,"il devrait etre possible de vider donc vrai...");

        resultat = controller.ableToEmpty(0,1);
        assertTrue(resultat,"il devrait etre possible de remplir donc vrai...");

        resultat = controller.ableToEmpty(1,1);
        assertTrue(resultat,"il devrait etre possible de remplir donc vrai...");
    }

    @Test
    void testAbleToTranfert(){
        Controller controller = new Controller();
        boolean resultat = controller.ableToTransfer(0,0,2);
        assertTrue(resultat,"il devrait etre possible de transferer donc vrai...");

        resultat = controller.ableToTransfer(2,0,2);
        assertFalse(resultat,"il devrait etre impossible de transferer donc faux...");

        resultat = controller.ableToTransfer(0,2,2);
        assertFalse(resultat,"il devrait etre impossible de transferer donc faux...");

        resultat = controller.ableToTransfer(1,1,2);
        assertTrue(resultat,"il devrait etre possible de transferer donc vrai...");
    }
}
