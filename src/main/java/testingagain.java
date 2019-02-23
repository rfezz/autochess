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

    StringBuilder sb = new StringBuilder();



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
    private final int beastBonus1 = 2;
    private final int beastBonus2 = 4;
    private final int beastBonus3 = 6;
    private int demonCount = 0;
    private final int demonBonus1 = 1;
    private final int demonBonus2 = 0;
    private final int demonBonus3 = 0;
    private int dwarfCount=0;
    private final int dwarfBonus1 = 1;
    private final int dwarfBonus2 = 0;
    private final int dwarfBonus3 = 0;
    private int dragonCount=0;
    private final int dragonBonus1 = 3;
    private final int dragonBonus2 = 0;
    private final int dragonBonus3 = 0;
    private int elementalsCount=0;
    private final int elementalsBonus1 = 2;
    private final int elementalsBonus2 = 4;
    private final int elementalsBonus3 = 0;
    private int elfCount=0;
    private final int elfBonus1 = 3;
    private final int elfBonus2 = 6;
    private final int elfBonus3 = 0;

    private int goblinCount=0;
    private final int goblinBonus1 = 3;
    private final int goblinBonus2 = 6;
    private final int goblinBonus3 = 0;
    private int humanCount=0;
    private final int humanBonus1 = 3;
    private final int humanBonus2 = 6;
    private final int humanBonus3 = 0;
    private int nagaCount=0;
    private final int nagaBonus1 = 2;
    private final int nagaBonus2 = 4;
    private final int nagaBonus3 = 0;
    private int ogreCount=0;
    private final int ogreBonus1 = 1;
    private final int ogreBonus2 = 0;
    private final int ogreBonus3 = 0;
    private int orcCount=0;
    private final int orcBonus1 = 2;
    private final int orcBonus2 = 4;
    private final int orcBonus3 = 0;
    private int trollCount=0;
    private final int trollBonus1 = 2;
    private final int trollBonus2 = 4;
    private final int trollBonus3 = 0;
    private int undeadCount=0;
    private final int undeadBonus1 = 2;
    private final int undeadBonus2 = 4;
    private final int undeadBonus3 = 0;

    private int assassinCount=0;
    private final int assassinBonus1 = 3;
    private final int assassinBonus2 = 6;
    private final int assassinBonus3 = 0;
    private int demonhunterCount=0;
    private final int demonhunterBonus1 = 1;
    private final int demonhunterBonus2 = 2;
    private final int demonhunterBonus3 = 0;
    private int druidCount=0;
    private final int druidBonus1 = 2;
    private final int druidBonus2 = 4;
    private final int druidBonus3 = 0;
    private int hunterCount=0;
    private final int hunterBonus1 = 3;
    private final int hunterBonus2 = 6;
    private final int hunterBonus3 = 0;
    private int knightCount=0;
    private final int knightBonus1 = 2;
    private final int knightBonus2 = 4;
    private final int knightBonus3 = 6;
    private int mageCount=0;
    private final int mageBonus1 = 3;
    private final int mageBonus2 = 6;
    private final int mageBonus3 = 0;
    private int mechCount=0;
    private final int mechBonus1 = 2;
    private final int mechBonus2 = 4;
    private final int mechBonus3 = 0;
    private int shamanCount=0;
    private final int shamanBonus1 = 2;
    private final int shamanBonus2 = 0;
    private final int shamanBonus3 = 0;
    private int warlockCount=0;
    private final int warlockBonus1 = 3;
    private final int warlockBonus2 = 6;
    private final int warlockBonus3 = 0;
    private int warriorCount=0;
    private final int warriorBonus1 = 3;
    private final int warriorBonus2 = 6;
    private final int warriorBonus3 = 9;

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


        resetCounters();

        getUnitCount(set);

        sbArea.append("BOARD COUNT:\n");

        sbArea.append(printStuff());

        if (sbArea.length()>0) sbArea.append("***************************\n");

        if (benchPieces.size()>0) {
            sbArea.append("BENCH COUNT:\n");
            set.addAll(benchPieces);
            set.removeAll(boardPieces);
            resetCounters();
            getUnitCount(set);
            //testing
            sbArea.append(printStuff());
        }


        sickArea.setText(sbArea.toString());


        return true;

    }

    private String textGenerator(int unitCount, int firstBonus, int secondBonus, int thirdBonus){

        boolean thirdB=false;
        boolean secondB=false;
        boolean firstB=false;
        if (unitCount>thirdBonus-1 && thirdBonus!=0){
            thirdB=true;
        }
        else if (unitCount>secondBonus-1 && secondBonus!=0){
            secondB=true;
        }
        else if (unitCount>firstBonus-1){
            firstB=true;
        }
        sb.setLength(0);

        sb.append(unitCount);

        if(thirdBonus>0){
            //HANDLES THIRD BONUS
            if (thirdB) {
                sb.append("/"+ thirdBonus + " **" + thirdBonus + " UNIT BONUS**\n");
                return sb.toString();
            }

        }

        //HANDLES SECOND BONUS
        if(thirdBonus>0 && secondBonus>0){
            if (secondB) {
                sb.append("/"+ thirdBonus + " **" + secondBonus + " UNIT BONUS**\n");
                return sb.toString();
            }
        }
        else if(secondB){
            sb.append("/"+ secondBonus + " **" + secondBonus + " UNIT BONUS**\n");
            return sb.toString();
        }

        //HANDLES FIRST BONUS
        if(secondBonus>0 && firstB){
            sb.append("/"+ secondBonus + " **" + firstBonus + " UNIT BONUS**\n");
            return sb.toString();
        }
        else if (firstB){
            sb.append("/"+ firstBonus + " **" + firstBonus + " UNIT BONUS**\n");
            return sb.toString();
        }

        sb.append("/" + firstBonus + "\n");

        return sb.toString();


    }

    private void resetCounters(){
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
    }

    public void getUnitCount(Set<ChessPiece> set){
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
    }

    public String printStuff(){
        StringBuilder sbArea = new StringBuilder();
        if (beastCount > 0) {sbArea.append("beastCount =");
            sbArea.append(textGenerator(beastCount, beastBonus1,beastBonus2,beastBonus3));
        }
        if (demonCount > 0) {sbArea.append("demonCount =");
            sbArea.append(textGenerator(demonCount, demonBonus1,demonBonus2,demonBonus3));
        }
        if (dwarfCount > 0) {sbArea.append("dwarfCount=");
            sbArea.append(textGenerator(dwarfCount, dwarfBonus1,dwarfBonus2,dwarfBonus3));
        }
        if (dragonCount > 0) {sbArea.append("dragonCount=");
            sbArea.append(textGenerator(dragonCount,dragonBonus1,dragonBonus2,dragonBonus3));
        }
        if (elementalsCount > 0) {sbArea.append("elementalsCount=");
            sbArea.append(textGenerator(elementalsCount,elementalsBonus1,elementalsBonus2,elementalsBonus3));
        }
        if (elfCount > 0) {sbArea.append("elfCount=");
            sbArea.append(textGenerator(elfCount,elfBonus1,elfBonus2,elfBonus3));
        }
        if (goblinCount > 0) {sbArea.append("goblinCount=");
            sbArea.append(textGenerator(goblinCount,goblinBonus1,goblinBonus2,goblinBonus3));
        }
        if (humanCount > 0) {sbArea.append("humanCount=");
            sbArea.append(textGenerator(humanCount,humanBonus1,humanBonus2,humanBonus3));
        }
        if (nagaCount > 0) {sbArea.append("nagaCount=");
            sbArea.append(textGenerator(nagaCount,nagaBonus1,nagaBonus2,nagaBonus3));
        }
        if (ogreCount > 0) {sbArea.append("ogreCount=");
            sbArea.append(textGenerator(ogreCount,ogreBonus1,ogreBonus2,ogreBonus3));
        }
        if (orcCount > 0) {sbArea.append("orcCount=");
            sbArea.append(textGenerator(orcCount,orcBonus1,orcBonus2,orcBonus3));
        }
        if (trollCount > 0) {sbArea.append("trollCount=");
            sbArea.append(textGenerator(trollCount,trollBonus1,trollBonus2,trollBonus3));
        }
        if (undeadCount > 0) {sbArea.append("undeadCount=");
            sbArea.append(textGenerator(undeadCount,undeadBonus1,undeadBonus2,undeadBonus3));
        }
//        if (sbArea.length()>0) sbArea.append("***************************\n");

        if (assassinCount > 0) {sbArea.append("assassinCount =");
            sbArea.append(textGenerator(assassinCount,assassinBonus1,assassinBonus2,assassinBonus3));
        }
        if (demonhunterCount > 0) {sbArea.append("demonhunterCount =");
            sbArea.append(textGenerator(demonhunterCount,demonhunterBonus1,demonhunterBonus2,demonhunterBonus3));
        }
        if (druidCount > 0) {sbArea.append("druidCount =");
            sbArea.append(textGenerator(druidCount,druidBonus1,druidBonus2,druidBonus3));
        }
        if (hunterCount > 0) {sbArea.append("hunterCount =");
            sbArea.append(textGenerator(hunterCount,hunterBonus1,hunterBonus2,hunterBonus3));
        }
        if (knightCount > 0) {sbArea.append("knightCount =");
            sbArea.append(textGenerator(knightCount,knightBonus1,knightBonus2,knightBonus3));
        }
        if (mageCount > 0) {sbArea.append("mageCount =");
            sbArea.append(textGenerator(mageCount,mageBonus1,mageBonus2,mageBonus3));
        }
        if (mechCount > 0) {sbArea.append("mechCount =");
            sbArea.append(textGenerator(mechCount,mechBonus1,mechBonus2,mechBonus3));
        }
        if (shamanCount > 0) {sbArea.append("shamanCount =");
            sbArea.append(textGenerator(shamanCount,shamanBonus1,shamanBonus2,shamanBonus3));
        }
        if (warlockCount > 0) {sbArea.append("warlockCount =");
            sbArea.append(textGenerator(warlockCount, warlockBonus1,warlockBonus2,warlockBonus3));
        }
        if (warriorCount > 0) { sbArea.append("warriorCount =");
            sbArea.append(textGenerator(warriorCount, warriorBonus1,warriorBonus2,warriorBonus3));
        }
        return sbArea.toString();
    }


}

