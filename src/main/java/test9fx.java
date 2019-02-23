import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class test9fx extends Application {

    public static final String XLSX_FILE_PATH = "C:\\Java Data\\AutoChess.xlsx";
    public static PieceList autochess;


    private final boolean needToSave = false;

    //this is is where all pieces come from
    static {
        try {
            autochess = new PieceList();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
//            System.out.println("first");
        }
    }

    private Button btnHello;  // Declare a "Button" control

    @Override
    public void start(Stage primaryStage) throws IOException {

//        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        DataFormatter dataFormatter = new DataFormatter();
        if (needToSave){
            saveToFile.saveFile();
        }

        Parent root = FXMLLoader.load(getClass().getResource("test9fxstyle.fxml"));

        primaryStage.setTitle("Hello");
        primaryStage.setScene(new Scene(root, 900, 500));

//        System.out.println(autochess.getPiece("Chaos Knight").toString());

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
