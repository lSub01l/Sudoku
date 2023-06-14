package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.buildlogic.SudokuBuildLogic;
import com.example.userinterface.IUserInterfaceContract;
import com.example.userinterface.UserInterfaceImpl;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Get SudokuGame object for a new game
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}