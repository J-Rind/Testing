package com.company;

import java.util.Scanner;

public class Game {
    // Top level variables
    private GameState state;
    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    private Scanner scanner = new Scanner(System.in);

    public Game() {
        this.state = GameState.STARTING;
    }

    public void start() {
        startGameLoop();
    }

    private void startGameLoop() {
        do {
            startGame();
        } while (state != GameState.STOPPED);
    }

    private void startGame() {
        switch (state) {
            case STARTING:
                initializeGame();
                break;
            case MENU:
                handleMenuState();
                break;
            case PLAYING:
                // 1. Print board
                board.showBoard();                          //TYANG placeholder
                state = GameState.STOPPED;
                // 2. Accept input
                // 3. Handle input

                break;
            case STOPPED:
                stopGame();
                break;
            default:
                break;
        }
    }

    // Startup functions
    private void initializeGame() {
        printStartupMessages();
        state = GameState.MENU;
        this.board = new Board();
    }

    private void printStartupMessages() {
        System.out.println("--- Welcome to Chess! ---");
    }

    // Menu functions
    private void handleMenuState() {
        printMenuOptions();
        int choice = getMenuChoice();
        handleChoice(choice);
    }

    private void printMenuOptions() {
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    private int getMenuChoice() {
        System.out.print("Please select a menu option (1-2): ");
        String input = scanner.nextLine();
        return parseInputMenuChoice(input);
    }

    private int parseInputMenuChoice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                startPlayingGame();
                break;
            case 2:
                stopGame();
                break;
            default:
                handleInvalidMenuChoice();
                break;
        }
    }

    private void handleInvalidMenuChoice() {
        System.out.println("Invalid menu option entered!");
    }

    // Playing functions
    private void startPlayingGame() {
        initializePlayers();
        welcomePlayers();
        state = GameState.PLAYING;

        System.out.println("Beginning play state (control+c to stop)");
    }

    private void initializePlayers() {
        System.out.println("Player 1, please enter your name:");
        String playerWhiteName = getPlayerName();
        this.playerWhite = new Player(true, playerWhiteName);
        
        System.out.println("Player 2, please enter your name:");
        String playerBlackName = getPlayerName();
        this.playerBlack = new Player(false, playerBlackName);
    }

    private void welcomePlayers() {
        System.out.println("Welcome " + playerWhite.getName() + " and " + playerBlack.getName() + "!");
    }

    private String getPlayerName() {
        return scanner.nextLine();
    }

    // Stop functions
    private void stopGame() {
        printStopMessages();
        scanner.close();
        state = GameState.STOPPED;
    }

    private void printStopMessages() {
        System.out.println("--- Thank you for playing! ---");
    }
}
