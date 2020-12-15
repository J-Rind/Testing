package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    // Top level variables
    private GameState state;
    private Player playerWhite;
    private Player playerBlack;
    private SavedGame savedGame;


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
                gameLoop();
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
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
    }

    private int getMenuChoice() {
        System.out.print("Please select a menu option (1-3): ");
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
                newGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
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

    // New game
    private void newGame() {
        initializePlayers();
        welcomePlayers();
        this.savedGame = new SavedGame(
            new Board(),
            0,
            this.playerWhite,
            this.playerBlack,
                new King(0, 0, "King", true),
                new King(0, 0, "King", true),
            new ArrayList<Piece>()
        );
        startPlayingGame();
    }

    // Load game
    private void loadGame() {
        System.out.println("Please enter the game of the saved game:");
        String fileName = scanner.nextLine();
        System.out.println("Loading game...");
        this.savedGame = GameLoader.loadGameFromFile(fileName);
        this.playerWhite = this.savedGame.getWhitePlayer();
        this.playerBlack = this.savedGame.getBlackPlayer();
        System.out.println("Welcome back, " + this.playerWhite.getName() + " and " + this.playerBlack.getName() + "!" );

        if (this.savedGame.getTurn() % 2 == 0) {
            System.out.println("It is currently " + this.playerWhite.getName() + "'s turn!");
        } else {
            System.out.println("It is currently " + this.playerBlack.getName() + "'s turn!");
        }
        startPlayingGame();
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

    private void gameLoop(){
        int turn = 0;
        ArrayList<Piece> currentPieces = new ArrayList<Piece>();
        ArrayList<Piece> playerPieces = this.savedGame.getPieces();
        Board mBoard = this.savedGame.getBoard();
        Input whitePlayerInput = new Input(this.playerWhite);
        Input blackPlayerInput = new Input(this.playerBlack);

        King whitePlayerKing = this.savedGame.getWhiteKing();
        King blackPlayerKing = this.savedGame.getBlackKing();

        // Loop to get current position of kings s
        for(Square[] p : mBoard.squares) {
            for(int i = 0; i < 8; i++){
                try {
                    if(p[i].getPiece().getName().contains("kg") && p[i].getPiece().getColor())       // TYANG naming convention
                        whitePlayerKing = (King) p[i].getPiece();                                    // Causes all moves invalid due to check
                    else if(p[i].getPiece().getName().contains("kg") && !(p[i].getPiece().getColor()))
                        blackPlayerKing = (King) p[i].getPiece();

                
                } catch (Exception e) {
                    //System.out.println("test");
                }
                
            }

        }
        playerPieces.addAll(mBoard.blackPiece);
        playerPieces.addAll(mBoard.whitePiece);

        playGame(currentPieces, playerPieces, turn, mBoard, whitePlayerInput, blackPlayerInput, whitePlayerKing, blackPlayerKing);
    }

    private void playGame(ArrayList<Piece> currentPieces, ArrayList<Piece> playerPieces, int turn, Board mBoard, Input whitePlayerInput, Input blackPlayerInput, King whitePlayerKing, King blackPlayerKing) {
        while(!playerWhite.isWon() && !playerBlack.isWon()){
            // Prints the board
            currentPieces = mBoard.showBoard();
            // If turn is even, white's turn.
            if(turn % 2 == 0){
                takeTurn(whitePlayerInput, turn, this.playerWhite, playerPieces, mBoard, whitePlayerKing, whitePlayerKing, blackPlayerKing);
            }
            else{
                takeTurn(blackPlayerInput, turn, this.playerBlack, playerPieces, mBoard, blackPlayerKing, whitePlayerKing, blackPlayerKing);
            }

            GameWinCondition winCondition = isCheckMate(whitePlayerKing, blackPlayerKing, playerPieces);

            if (winCondition == GameWinCondition.WHITE)
                playerWhite.setWon(true);
            else if (winCondition == GameWinCondition.BLACK)
                playerBlack.setWon(true);
        }
        state = GameState.STOPPED;
    }

    private void takeTurn(Input playerInput, int turn, Player player, ArrayList<Piece> playerPieces, Board mBoard, King king, King whiteplayerking, King blackplayerking) {
        String input  = playerInput.getInput(playerPieces,mBoard,king);
        if (input.equals("save")) {
            SavedGame savedGame = new SavedGame(mBoard, turn, this.playerWhite, this.playerBlack, whiteplayerking, blackplayerking, playerPieces);
            GameSaver.saveGame(savedGame, player);
        } else {
            playerInput.updateBoard(playerPieces, mBoard, king);
        }
    }

    private GameWinCondition isCheckMate(King white, King black, ArrayList<Piece> pieces) {
        if(white.kingCheck(pieces))
            return GameWinCondition.WHITE;
        else if(black.kingCheck(pieces))
            return GameWinCondition.BLACK;
        else  
            return GameWinCondition.NONE;
    }
}
