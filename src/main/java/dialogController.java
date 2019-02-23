import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.IOException;

public class dialogController {

//    PieceList autoChess;
    @FXML
    private ListView<String> optionList;

//    @FXML
//    private DialogPane asdf;

    private ObservableList<String> optionObsList;

//   gets item by name and adds to chesspiece list

    public boolean processResults(){

            //so it doesnt crash when ok is pressed without anything selected
            if(optionList.getSelectionModel().getSelectedItems().size()>0) {
//                System.out.println("YYYYY");
                String unitName = optionList.getSelectionModel().getSelectedItem();
                testingagain.updateBoardPieces(test9fx.autochess.getPiece(unitName));
            }

        return true;
    }

    @FXML
    public void initialize() throws IOException {

        optionList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //optionList.getSelectionModel().selectFirst();
//        autoChess = new PieceList();
        optionObsList = FXCollections.observableList(test9fx.autochess.getPiecesByCost(testingagain.getSelectedCost()));



        Runnable task = () -> Platform.runLater(() -> {
            optionList.getItems().setAll(optionObsList);
            //asdf.setHeaderText(testingagain.getSelectedCost() + " Cost Pieces");
        });
        new Thread(task).start();

    }


}
