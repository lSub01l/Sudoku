package com.example.persistence;

import com.example.problemdomain.SudokuGame;
import com.example.problemdomain.IStorage;

import java.io.*;

public class LocalStorageImpl implements IStorage {

    private static File GAME_DATA = new File(
            System.getProperty("user.home"),
            "gamedata.txt"
    );

    @Override
    public void updateGameData(SudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new IOException("Unable to access Game Data");
        }
    }

    @Override
    public SudokuGame getGameData() throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(GAME_DATA);
            objectInputStream = new ObjectInputStream(fileInputStream);
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            return gameState;
        } catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    // Handle the exception if needed
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    // Handle the exception if needed
                }
            }
        }
    }
}
