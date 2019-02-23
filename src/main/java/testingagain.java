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

import static java.lang.Integer.getInteger;


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

    //memes
    private ArrayList<Integer> bonusList = new ArrayList<>();
    private ArrayList<Integer> intlBonusList = new ArrayList<>();
    private ArrayList<String>  bonusClassList = new ArrayList<>();
    private ArrayList<String> intlBonusClassList = new ArrayList<>();
    private ArrayList<String> bonusClasses = new ArrayList<>();


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

    //initializes the dialog pane
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
            if (controller.processResults()) {
//                System.out.println("XXXXXX");
                updateView();
            }

        }
        else {
            System.out.println("cancel pressed");
        }


    }

    //starts the ui update thread
    public Boolean updateView(){
        new Thread(task).start();
        return true;
    }
    //all of the methods that are updated each time something changes
    Runnable task = () -> Platform.runLater(() -> {
        Boolean asdf = setBoardView(boardView);
        Boolean qwer = setBoardView(benchView);
        Boolean zxcv = updateTextArea();
    });

    //updates the lists
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

    //removes selected item from list and updates, works for both lists
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

    //swaps from board<->bench
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

    //static int of button pressed so dialog can load the correct list
    public static int getSelectedCost(){
        return selectedCost;
    }

    //static list of chess pieces that dialogbox can update

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

    //&444 makes it so only one item is able to be selected between both list views
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

    //handles the info thats posted
    private boolean updateTextArea(){

        //clear the string
        sbArea.setLength(0);

        //remove duplicates
        Set<ChessPiece> set = new LinkedHashSet<>();
        set.addAll(boardPieces);

        resetCounters();

        getUnitCount(set);

        sbArea.append("***************************\n");
        sbArea.append("BOARD COUNT:\n\n");

        sbArea.append(printStuff());

//        if (benchPieces.size()>0)
            sbArea.append("***************************\n");

        if (benchPieces.size()>0) {

            sbArea.append("BENCH UNITS:\n");

            //memes
            intlBonusList.clear();
            intlBonusList.addAll(bonusList);
            intlBonusClassList.clear();
            intlBonusClassList.addAll(bonusClassList);

            bonusList.clear();
            bonusClassList.clear();
            //all pieces
            set.addAll(benchPieces);
            //all pieces no dupes
            Set<ChessPiece> set2 = new LinkedHashSet<>(set);
            resetCounters();
            getUnitCount(set);
            //need to run this method to populate bonus list
            printStuff();

            //compare lists
            boolean availableBonus = false;

//            System.out.println("\nintl list size = " + intlBonusList.size());
//            System.out.println("bonus list size =" + bonusList.size());
//            System.out.println("intl list size = " + intlBonusClassList.size());
//            System.out.println("bonus list size =" + bonusClassList.size());

            //equalizes list
            while(! (intlBonusClassList.size() == bonusClassList.size())){
            for (int x = 0; x < intlBonusClassList.size(); x++) {
                if (!intlBonusClassList.get(x).equals(bonusClassList.get(x))) {
                    intlBonusClassList.add(x, bonusClassList.get(x));
                    intlBonusList.add(x,0);
                }
            }
            }

//            System.out.println("\nintl list size = " + intlBonusList.size());
//            System.out.println("bonus list size =" + bonusList.size());
//            System.out.println("intl list size = " + intlBonusClassList.size());
//            System.out.println("bonus list size =" + bonusClassList.size());
//
//            for(int x = 0; x<intlBonusClassList.size(); x++){
//
//                System.out.print(intlBonusClassList.get(x));
//                System.out.println(bonusClassList.get(x));
//            }
            bonusClasses.clear();

            for (int x =0; x<intlBonusList.size(); x++){
                if (intlBonusList.get(x) < bonusList.get(x)){
                    if(intlBonusClassList.get(x).equals(bonusClassList.get(x))) {
                        bonusClasses.add(intlBonusClassList.get(x));
                        availableBonus = true;
                    }
                }
            }

            //memes
            //intlBonusList = bonusList;
            bonusList.clear();
            bonusClassList.clear();

            set2.removeAll(boardPieces);
            resetCounters();
            getUnitCount(set2);
            //testing

            for(ChessPiece unit : set2){
                sbArea.append(unit.getName() + ": " + unit.getSpecies1());
                if (unit.getSpecies2().length() > 0 ){
                    sbArea.append(", " + unit.getSpecies2());
                }
                sbArea.append(", " + unit.getJob() + "\n");

            }
            if (availableBonus){
                sbArea.append("***************************\n");
                sbArea.append("BONUS FROM BENCH AVAILABLE: \n");
                for (String y : bonusClasses){
                    sbArea.append(y);
                    sbArea.append("\n");
                }
            }
            sbArea.append("***************************\n");
//            sbArea.append(printStuff());
        }


        sickArea.setText(sbArea.toString());


        return true;

    }

    //putting each type of input into a mold
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
                bonusList.add(3);
                return sb.toString();
            }

        }

        //HANDLES SECOND BONUS
        if(thirdBonus>0 && secondBonus>0){
            if (secondB) {
                sb.append("/"+ thirdBonus + " **" + secondBonus + " UNIT BONUS**\n");
                bonusList.add(2);
                return sb.toString();
            }
        }
        else if(secondB){
            sb.append("/"+ secondBonus + " **" + secondBonus + " UNIT BONUS**\n");
            bonusList.add(2);
            return sb.toString();
        }

        //HANDLES FIRST BONUS
        if(secondBonus>0 && firstB){
            sb.append("/"+ secondBonus + " **" + firstBonus + " UNIT BONUS**\n");
            bonusList.add(1);
            return sb.toString();
        }
        else if (firstB){
            sb.append("/"+ firstBonus + " **" + firstBonus + " UNIT BONUS**\n");
            bonusList.add(1);
            return sb.toString();
        }

        sb.append("/" + firstBonus + "\n");
        bonusList.add(0);

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
    //where the stuff that actually goes on the screen is made
    public String printStuff(){
        //meme?
        bonusList.clear();
        bonusClassList.clear();

        StringBuilder sbArea = new StringBuilder();
        if (beastCount > 0) {sbArea.append("beasts=");
            sbArea.append(textGenerator(beastCount, beastBonus1,beastBonus2,beastBonus3));
            bonusClassList.add("Beasts");
        }
        if (demonCount > 0) {sbArea.append("demons=");
            sbArea.append(textGenerator(demonCount, demonBonus1,demonBonus2,demonBonus3));
            bonusClassList.add("Demons");
        }
        if (dwarfCount > 0) {sbArea.append("dwarfs=");
            sbArea.append(textGenerator(dwarfCount, dwarfBonus1,dwarfBonus2,dwarfBonus3));
            bonusClassList.add("Dwarfs");
        }
        if (dragonCount > 0) {sbArea.append("dragons=");
            sbArea.append(textGenerator(dragonCount,dragonBonus1,dragonBonus2,dragonBonus3));
            bonusClassList.add("Dragons");
        }
        if (elementalsCount > 0) {sbArea.append("elementals=");
            sbArea.append(textGenerator(elementalsCount,elementalsBonus1,elementalsBonus2,elementalsBonus3));
            bonusClassList.add("Elementals");
        }
        if (elfCount > 0) {sbArea.append("elves=");
            sbArea.append(textGenerator(elfCount,elfBonus1,elfBonus2,elfBonus3));
            bonusClassList.add("Elves");
        }
        if (goblinCount > 0) {sbArea.append("goblins=");
            sbArea.append(textGenerator(goblinCount,goblinBonus1,goblinBonus2,goblinBonus3));
            bonusClassList.add("Goblins");
        }
        if (humanCount > 0) {sbArea.append("humans=");
            sbArea.append(textGenerator(humanCount,humanBonus1,humanBonus2,humanBonus3));
            bonusClassList.add("Humans");
        }
        if (nagaCount > 0) {sbArea.append("nagas=");
            sbArea.append(textGenerator(nagaCount,nagaBonus1,nagaBonus2,nagaBonus3));
            bonusClassList.add("Nagas");
        }
        if (ogreCount > 0) {sbArea.append("ogres=");
            sbArea.append(textGenerator(ogreCount,ogreBonus1,ogreBonus2,ogreBonus3));
            bonusClassList.add("Ogres");
        }
        if (orcCount > 0) {sbArea.append("orcs=");
            sbArea.append(textGenerator(orcCount,orcBonus1,orcBonus2,orcBonus3));
            bonusClassList.add("Orcs");
        }
        if (trollCount > 0) {sbArea.append("trolls=");
            sbArea.append(textGenerator(trollCount,trollBonus1,trollBonus2,trollBonus3));
            bonusClassList.add("Trolls");
        }
        if (undeadCount > 0) {sbArea.append("undeads=");
            sbArea.append(textGenerator(undeadCount,undeadBonus1,undeadBonus2,undeadBonus3));
            bonusClassList.add("Undead");
        }
//        if (sbArea.length()>0) sbArea.append("***************************\n");

        if (assassinCount > 0) {sbArea.append("assassins=");
            sbArea.append(textGenerator(assassinCount,assassinBonus1,assassinBonus2,assassinBonus3));
            bonusClassList.add("Assassins");
        }
        if (demonhunterCount > 0) {sbArea.append("demonhunters=");
            sbArea.append(textGenerator(demonhunterCount,demonhunterBonus1,demonhunterBonus2,demonhunterBonus3));
            bonusClassList.add("Demon Hunters");
        }
        if (druidCount > 0) {sbArea.append("druids=");
            sbArea.append(textGenerator(druidCount,druidBonus1,druidBonus2,druidBonus3));
            bonusClassList.add("Druids");
        }
        if (hunterCount > 0) {sbArea.append("hunters=");
            sbArea.append(textGenerator(hunterCount,hunterBonus1,hunterBonus2,hunterBonus3));
            bonusClassList.add("Hunters");
        }
        if (knightCount > 0) {sbArea.append("knights=");
            sbArea.append(textGenerator(knightCount,knightBonus1,knightBonus2,knightBonus3));
            bonusClassList.add("Knights");
        }
        if (mageCount > 0) {sbArea.append("mages=");
            sbArea.append(textGenerator(mageCount,mageBonus1,mageBonus2,mageBonus3));
            bonusClassList.add("Mages");
        }
        if (mechCount > 0) {sbArea.append("mechs=");
            sbArea.append(textGenerator(mechCount,mechBonus1,mechBonus2,mechBonus3));
            bonusClassList.add("Mechs");
        }
        if (shamanCount > 0) {sbArea.append("shamans=");
            sbArea.append(textGenerator(shamanCount,shamanBonus1,shamanBonus2,shamanBonus3));
            bonusClassList.add("Shamans");
        }
        if (warlockCount > 0) {sbArea.append("warlocks=");
            sbArea.append(textGenerator(warlockCount, warlockBonus1,warlockBonus2,warlockBonus3));
            bonusClassList.add("Warlocks");
        }
        if (warriorCount > 0) { sbArea.append("warriors=");
            sbArea.append(textGenerator(warriorCount, warriorBonus1,warriorBonus2,warriorBonus3));
            bonusClassList.add("Warriors");
        }
        return sbArea.toString();
    }


}

