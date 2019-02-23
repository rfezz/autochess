import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.IOException;

public class dialogController {

//    PieceList autoChess;
    @FXML
    private ListView<String> optionList;

    private ObservableList<String> optionObsList;


    public void processResults(){
        try {
            String unitName = optionList.getSelectionModel().getSelectedItem();
            testingagain.updateBoardPieces(test9fx.autochess.getPiece(unitName));
        } catch (NullPointerException e){
            //i could disable the ok button if nothing pressed.. somehow
            System.err.println("need to choose something before pressing ok");
        }
    }

    @FXML
    public void initialize() throws IOException {

        optionList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //optionList.getSelectionModel().selectFirst();

//        autoChess = new PieceList();

        optionObsList = FXCollections.observableList(test9fx.autochess.getPiecesByCost(testingagain.getSelectedCost()));

        Runnable task = () -> Platform.runLater(() -> {
            optionList.getItems().setAll(optionObsList);
        });
        new Thread(task).start();

    }


}
