package uicomponents;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import resources.ResUtils;

public class UiComponents extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(10);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);

        initView(vBox);

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("UI Components");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initView(VBox vBox) {
        label(vBox);
    }

    private void label(VBox vBox) {
        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 10, 10);
        vBox.getChildren().add(flowPane);

        Label label1 = new Label();
        Label label2 = new Label("Search");
        Image image = new Image(ResUtils.getImageAsStream("smile.png"));
        final Label label3 = new Label("Search", new ImageView(image));
        label3.setContentDisplay(ContentDisplay.RIGHT);
        label3.setGraphicTextGap(20);
        label3.setFont(new Font("Consolas", 30));
        label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label3.setScaleX(1.5);
                label3.setScaleY(1.5);
            }
        });

        label3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label3.setScaleX(1);
                label3.setScaleY(1);
            }
        });
        flowPane.getChildren().addAll(label1, label2, label3);
    }
}
