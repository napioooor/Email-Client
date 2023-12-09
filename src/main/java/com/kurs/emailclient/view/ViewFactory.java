package com.kurs.emailclient.view;

import com.kurs.emailclient.EmailManager;
import com.kurs.emailclient.Launcher;
import com.kurs.emailclient.controller.BaseController;
import com.kurs.emailclient.controller.LoginWindowController;
import com.kurs.emailclient.controller.MainWindowController;
import com.kurs.emailclient.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }

    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        BaseController controller = new LoginWindowController(emailManager, this, "fxml/LoginWindow.fxml");

        initializeStage(controller);
    }

    public void showMainWindow(){
        BaseController controller = new MainWindowController(emailManager, this, "fxml/MainWindow.fxml");

        initializeStage(controller);
        mainViewInitialized = true;
    }

    public void showOptionsWindow(){
        BaseController controller = new OptionsWindowController(emailManager, this, "fxml/OptionsWindow.fxml");

        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for (Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Launcher.class.getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(Launcher.class.getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}
