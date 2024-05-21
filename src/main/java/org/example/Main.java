package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Player> playerList = new ArrayList<>();

        MarioGame m1 = new MarioGame();
        Player lucas = new Player("Lucas",m1);
        MarioGame m2 = new MarioGame();
        Player john = new Player("John",m2);

        playerList.add(lucas);
        playerList.add(john);
        Scanner keyboard = new Scanner(System.in);
        int option;
        do{
            System.out.println("MARIO GAME SIMULATOR");
            System.out.println("1- Play a game");
            System.out.println("2- Show players record");
            System.out.println("3- Exit");
            System.out.print("\n");
            System.out.print("Enter the desired option: ");
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch (option){
                case 1:
                    System.out.print("Choose a player:");
                    for (Player p:playerList){
                        System.out.print(" | " + p.getUserName());
                    }
                    System.out.println("\n");
                    String name = keyboard.nextLine();
                    for (Player p:playerList){
                        if (p.getUserName().equals(name)) p.playGame();
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    Collections.sort(playerList);
                    for (Player p:playerList){
                        String show = p.getUserName() + " | " + p.record();
                        System.out.println(show);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Leaving...");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Unexpected value: " + option);
                    break;
            }
        }while(option!=3);
    }
}