import java.io.*;
import java.util.ArrayList;

public class loadFromFile {




    public static ArrayList<ChessPiece> loadFile() throws IOException, ClassNotFoundException {

        ArrayList<ChessPiece> piecelist = new ArrayList<>();
//        How to try with resources
//        ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(".\\src\\main\\resources\\test9fxData.dat")));


        FileInputStream try1 = new FileInputStream(".\\src\\main\\resources\\test9fxData.dat");
        BufferedInputStream try2 = new BufferedInputStream(try1);
        ObjectInputStream try3 = new ObjectInputStream(try2);

        boolean eof = false;
        while(!eof){
            try{
                ChessPiece unit = (ChessPiece) try3.readObject();
//                System.out.println("Read piece " + unit.getName());
                piecelist.add(unit);

            } catch (EOFException e){
                eof = true;
//                System.out.println("done?");
            }
        }

        try3.close();
        try2.close();
        try1.close();




        return piecelist;
    }
}
