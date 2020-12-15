package com.company;

import java.beans.XMLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.*;
import java.util.Date;

public class GameSaver{
    public static void saveGame(SavedGame saveGame, Player player) {
        String date = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        String fileName = player.getName() + "-" + date + ".xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            encoder.writeObject(saveGame);
            encoder.close();
        } catch (Exception ex) {
            System.out.println("An error occurred while writing to the file");
        }
    }
}
