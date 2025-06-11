package main;

import main.model.Customer;
import main.model.Displayable;
import main.model.WelcomeScreen;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Displayable displayedScreen = WelcomeScreen.getInstance(sc);
        while (displayedScreen != null) {
            displayedScreen = displayedScreen.display();
        }
    }
}