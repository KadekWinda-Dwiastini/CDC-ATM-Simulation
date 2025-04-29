
import model.screen.Screen;
import model.screen.WelcomeScreen;


public class Main {
    public static void main(String[] args) {
        Screen displayedScreen = new WelcomeScreen(null);
        while (displayedScreen != null) {
            displayedScreen = displayedScreen.display();
        }
    }
}