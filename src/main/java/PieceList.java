
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PieceList {

    private ArrayList<ChessPiece> piecelist;

    //constructor loads from file
    public PieceList()throws IOException {
        PieceLoader loader = new PieceLoader();
        piecelist = loader.loadPieces();
    }


    public ArrayList<ChessPiece> getPiecelist() {
        return piecelist;
    }

    public ChessPiece getPiece(int x){
        return piecelist.get(x);
    }

    public ChessPiece getPiece(String name){
        for (ChessPiece x : piecelist){
            if (x.getName().equals(name)) {
                return x;
            }
        }
        System.out.println("we aint got that");
        return null;
    }

    public ArrayList<String> getPiecesByCost(int cost){
        ArrayList<String> biglist = new ArrayList<>();
        for (ChessPiece piece : piecelist){
            if (piece.getCost() == cost){
                biglist.add(piece.getName());
            }
        }
        //sorts alphabetically?
        Collections.sort(biglist);
        return biglist;
    }


}
