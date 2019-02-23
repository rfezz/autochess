import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithmState;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class testingagain {



    private static int selectedCost = 1;

    //displayed in gui under board
    @FXML
    private ListView boardView = new ListView();

    //chess pieces currently on the board

    public static List<ChessPiece> boardPieces = new ArrayList<>();

    //list of names of chess pieces on board (should make this a method)

    private List<String> boardViewStrings = new ArrayList<>();

    //turning this list into an observable list

    private ObservableList<String> boardViewList;

    //***********************************************************

    @FXML
    private ListView benchView = new ListView();

    //chess pieces currently on the bench

    public static List<ChessPiece> benchPieces = new ArrayList<>();

    //list of names of chess pieces on board (should make this a method)

    private List<String> benchViewStrings = new ArrayList<>();

    //turning this list into an observable list

    private ObservableList<String> benchViewList;


    @FXML
    private TextArea sickArea = new TextArea();
    //for printing stuff
    StringBuilder sbArea = new StringBuilder();



    @FXML
    private Button oneCost = new Button();
    @FXML
    private Button twoCost = new Button();
    @FXML
    private Button threeCost = new Button();
    @FXML
    private Button fourCost = new Button();
    @FXML
    private Button fiveCost = new Button();

    @FXML
    private BorderPane mainBorderPane;

    private int beastCount = 0;
    private int demonCount = 0;
    private int dwarfCount=0;
    private int dragonCount=0;
    private int elementalsCount=0;
    private int elfCount=0;
    private int goblinCount=0;
    private int humanCount=0;
    private int nagaCount=0;
    private int ogreCount=0;
    private int orcCount=0;
    private int trollCount=0;
    private int undeadCount=0;

    private int assassinCount=0;
    private int demonhunterCount=0;
    private int druidCount=0;
    private int hunterCount=0;
    private int knightCount=0;
    private int mageCount=0;
    private int mechCount=0;
    private int shamanCount=0;
    private int warlockCount=0;
    private int warriorCount=0;

    public testingagain() throws IOException {
    }


    @FXML
    public void initialize(){

//        boardViewStrings.add(autochess.getPiece(4).getName());
//        boardViewStrings.add(autochess.getPiece(3).getName());
//        boardViewStrings.add(autochess.getPiece(2).getName());
//        boardViewStrings.add(autochess.getPiece(1).getName());
//        boardViewList = FXCollections.observableList(boardViewStrings);
//        try {
//            autochess = new PieceList();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        sickArea.setEditable(false);

        oneCost.setOnAction(event -> showNewItemDialog(1));
        twoCost.setOnAction(event -> showNewItemDialog(2));
        threeCost.setOnAction(event -> showNewItemDialog(3));
        fourCost.setOnAction(event -> showNewItemDialog(4));
        fiveCost.setOnAction(event -> showNewItemDialog(5));


        updateView();
    }

    @FXML
    public void showNewItemDialog(int cost){
        selectedCost = cost;
        Dialog<ButtonType>  dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("test9dialogbox.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());

        }catch(IOException e){
            System.out.println("Couldnt Load Dialog " + e);
        }
        //add units to list by cost

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();

        //if ok is pressed, update
        if(((Optional) result).isPresent() && result.get() == ButtonType.OK){
            //adds selected unit to static list of chess pieces
            dialogController controller = fxmlLoader.getController();
            controller.processResults();
            updateView();

        }
        else {
            System.out.println("cancel pressed");
        }


    }

    public Boolean updateView(){
        new Thread(task).start();
        return true;
    }

    Runnable task = () -> Platform.runLater(() -> {
        Boolean asdf = setBoardView(boardView);
        Boolean qwer = setBoardView(benchView);
        Boolean zxcv = updateTextArea();
    });

    public Boolean setBoardView(ListView selectedView) {
        //clears, adds, updates

        if (selectedView.getId().equals("boardView")) {

            boardViewStrings.clear();
            for (ChessPiece unit : boardPieces) {
                boardViewStrings.add(unit.getName());
            }
            boardViewList = FXCollections.observableList(boardViewStrings);
            boardView.getItems().setAll(boardViewList);
            //boardView.getSelectionModel().selectFirst();
            return true;
        } else {

            benchViewStrings.clear();
            for (ChessPiece unit : benchPieces) {
                benchViewStrings.add(unit.getName());
            }
            benchViewList = FXCollections.observableList(benchViewStrings);
            benchView.getItems().setAll(benchViewList);
            //benchView.getSelectionModel().selectFirst();

            return true;
        }
    }

    @FXML
    private void removeFromList(){

        if (boardView.getSelectionModel().getSelectedItems().size() > 0){
            System.out.println("something in boardview selected");
            String selected = (String) boardView.getSelectionModel().getSelectedItem();
            System.out.println(selected + " selected");
            for (ChessPiece unit : boardPieces){
                if (selected.equals(unit.getName())) {
//                    System.out.println("removing " + selected);
//                    System.out.println("removing " + unit.getName());
                    boardPieces.remove(unit);
                    break;
                }
            }
            updateView();
        }
        else if (benchView.getSelectionModel().getSelectedItems().size() > 0){
            System.out.println("something in benchview selected");
            String selected = (String) benchView.getSelectionModel().getSelectedItem();
            System.out.println(selected + " selected");
            for (ChessPiece unit : benchPieces){
                if (selected.equals(unit.getName())) {
//                    System.out.println("removing " + selected);
//                    System.out.println("removing " + unit.getName());
                    benchPieces.remove(unit);
                    break;
                }

            }
            updateView();
        }



    }

    @FXML
    private void swapFromLists(){

        if (boardView.getSelectionModel().getSelectedItems().size() > 0) {
            if (benchPieces.size() < 8) {
                String selected = (String) boardView.getSelectionModel().getSelectedItem();
                for (ChessPiece unit : boardPieces) {
                    if (selected.equals(unit.getName())) {
                        boardPieces.remove(unit);
                        benchPieces.add(unit);
                        break;
                    }
                }

            }
        }
        if (benchView.getSelectionModel().getSelectedItems().size() > 0) {
            if (boardPieces.size() < 10) {
                String selected = (String) benchView.getSelectionModel().getSelectedItem();
                for (ChessPiece unit : benchPieces) {
                    if (selected.equals(unit.getName())) {
                        benchPieces.remove(unit);
                        boardPieces.add(unit);
                        break;
                    }
                }
            }
        }
        updateView();

    }

    //so the dialog can load the correct list from the button
    public static int getSelectedCost(){
        return selectedCost;
    }
    //static list that dialogbox can update

    public static boolean updateBoardPieces(ChessPiece unit){
        if (boardPieces.size()>9){
            if (benchPieces.size()>7){
                System.err.println("Board is full");
                return false;
            }
            benchPieces.add(unit);
        }

        else {
            boardPieces.add(unit);
        }

        return true;
    }

    @FXML
    private void test344() {
        if (boardView.getSelectionModel().getSelectedItems().size() > 0) {

            benchView.getSelectionModel().clearSelection();
        }
//        else{
//            System.out.println("nothing selected");
//        }
    }
    @FXML
    private void test444() {
        if (benchView.getSelectionModel().getSelectedItems().size() > 0) {

            boardView.getSelectionModel().clearSelection();
        }
//        else{
//            System.out.println("nothing selected");
//        }
    }

    private boolean updateTextArea(){

        //clear the string
        sbArea.setLength(0);

        //remove duplicates
        Set<ChessPiece> set = new LinkedHashSet<>();
        set.addAll(boardPieces);


        beastCount = 0;
        demonCount = 0;
        dwarfCount=0;
        dragonCount=0;
        elementalsCount=0;
        elfCount=0;
        goblinCount=0;
        humanCount=0;
        nagaCount=0;
        ogreCount=0;
        orcCount=0;
        trollCount=0;
        undeadCount=0;

        assassinCount=0;
        demonhunterCount=0;
        druidCount=0;
        hunterCount=0;
        knightCount=0;
        mageCount=0;
        mechCount=0;
        shamanCount=0;
        warlockCount=0;
        warriorCount=0;

        for(ChessPiece unit: set){
//            sbArea.append(unit.getSpecies1());
//            sbArea.append(unit.getSpecies2());
            switch(unit.getSpecies1()){
                case "Beast":
                    beastCount++;
                    break;
                case "Demon":
                    demonCount++;
                    break;
                case "Dwarf":
                    dwarfCount++;
                    break;
                case "Dragon":
                    dragonCount++;
                    break;
                case "Elementals":
                    elementalsCount++;
                    break;
                case "Elf":
                    elfCount++;
                    break;
                case "Goblin":
                    goblinCount++;
                    break;
                case "Human":
                    humanCount++;
                    break;
                case "Naga":
                    nagaCount++;
                    break;
                case "Ogre":
                    ogreCount++;
                    break;
                case "Orc":
                    orcCount++;
                    break;
                case "Troll":
                    trollCount++;
                    break;
                case "Undead":
                    undeadCount++;
                    break;
            }
            switch(unit.getSpecies2()){
                case "Dragon":
                    dragonCount++;
                    break;
                case "Beast":
                    beastCount++;
                    break;
            }
            switch(unit.getJob()){
                case "Assassin":
                    assassinCount++;
                    break;
                case "Demon Hunter":
                    demonhunterCount++;
                    break;
                case "Druid":
                    druidCount++;
                    break;
                case "Hunter":
                    hunterCount++;
                    break;
                case "Knight":
                       knightCount++;
                    break;
                case "Mage":
                    mageCount++;
                    break;
                case "Mech":
                    mechCount++;
                    break;
                case "Shaman":
                    shamanCount++;
                    break;
                case "Warlock":
                    warlockCount++;
                    break;
                case "Warrior":
                    warriorCount++;
                    break;


            }








        }
        if (beastCount > 0) {sbArea.append("beastCount =" + beastCount);
            if (beastCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (beastCount>3) sbArea.append("/6  **4 UNIT BONUS**\n");
            else if (beastCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (demonCount > 0) {sbArea.append("demonCount =" + demonCount);
            if (demonCount>1 && demonhunterCount<2) sbArea.append("/1  **TOO MANY DEMONS**\n");
            else {sbArea.append("/1 **1 UNIT BONUS**\n");}
        }
        if (dwarfCount > 0) {sbArea.append("dwarfCount=" + dwarfCount);
            sbArea.append("/1  **1 UNIT BONUS**\n");
        }
        if (dragonCount > 0) {sbArea.append("dragonCount=" + dragonCount);
            if (dragonCount>2) sbArea.append("/3  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}
        }
        if (elementalsCount > 0) {sbArea.append("elementalsCount=" + elementalsCount);
            if (elementalsCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (elementalsCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (elfCount > 0) {sbArea.append("elfCount=" + elfCount);
            if (elfCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (elfCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}
        }
        if (goblinCount > 0) {sbArea.append("goblinCount=" + goblinCount);
            if (goblinCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (goblinCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}
        }
        if (humanCount > 0) {sbArea.append("humanCount=" + humanCount);
            if (humanCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (humanCount>3) sbArea.append("/6  **4 UNIT BONUS**\n");
            else if (humanCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (nagaCount > 0) {sbArea.append("nagaCount=" + nagaCount);
            if (nagaCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (nagaCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (ogreCount > 0) {sbArea.append("ogreCount=" + ogreCount);
            sbArea.append("/1  **1 UNIT BONUS**\n");
        }
        if (orcCount > 0) {sbArea.append("orcCount=" + orcCount);
             if (orcCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (orcCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (trollCount > 0) {sbArea.append("trollCount=" + trollCount);
            if (trollCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (trollCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (undeadCount > 0) {sbArea.append("undeadCount=" + undeadCount);
            if (undeadCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (undeadCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (sbArea.length()>0) sbArea.append("***************************\n");

        if (assassinCount > 0) {sbArea.append("assassinCount= "+ assassinCount);
            if (assassinCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (assassinCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}
        }
        if (demonhunterCount > 0) {sbArea.append("demonhunterCount =" + demonhunterCount);
            if (demonhunterCount>1) sbArea.append("/2  **2 UNIT BONUS**\n");
            else {sbArea.append("/2 **1 UNIT BONUS**\n");}
        }
        if (druidCount > 0) {sbArea.append("druidCount =" + druidCount);
            if (druidCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (druidCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (hunterCount > 0) {sbArea.append("hunterCount =" + hunterCount);
            if (hunterCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (hunterCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}
        }
        if (knightCount > 0) {sbArea.append("knightCount =" + knightCount);
            if (knightCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (knightCount>3) sbArea.append("/6  **4 UNIT BONUS**\n");
            else if (knightCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}
        }
        if (mageCount > 0) {sbArea.append("mageCount =" + mageCount);
            if (mageCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (mageCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}}
        if (mechCount > 0) {sbArea.append("mechCount =" + mechCount);
            if (mechCount>3) sbArea.append("/4  **4 UNIT BONUS**\n");
            else if (mechCount>1) sbArea.append("/4  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}}
        if (shamanCount > 0) {sbArea.append("shamanCount =" + shamanCount);
            if (shamanCount>1) sbArea.append("/2  **2 UNIT BONUS**\n");
            else {sbArea.append("/2\n");}}
        if (warlockCount > 0) {sbArea.append("warlockCount =" + warlockCount);
            if (warlockCount>5) sbArea.append("/6  **6 UNIT BONUS**\n");
            else if (warlockCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}}
        if (warriorCount > 0) {sbArea.append("warriorCount =" + warriorCount);
            if (warriorCount>8) sbArea.append("/9  **9 UNIT BONUS**\n");
            else if (warriorCount>5) sbArea.append("/9  **6 UNIT BONUS**\n");
            else if (warriorCount>2) sbArea.append("/6  **3 UNIT BONUS**\n");
            else {sbArea.append("/3\n");}}



        sickArea.setText(sbArea.toString());


        return true;

    }


}

