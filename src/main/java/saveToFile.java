import java.io.*;

public class saveToFile {


    public static boolean saveFile() throws IOException{


        FileOutputStream try1 = new FileOutputStream(".\\src\\main\\resources\\test9fxData.dat");
        BufferedOutputStream try2 = new BufferedOutputStream(try1);
        ObjectOutputStream try3 = new ObjectOutputStream(try2);

//        ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(".\\src\\main\\resources\\test9fxData.dat")));

        for (ChessPiece unit : test9fx.autochess.getPiecelist()){

            System.out.println("writing to file: " + unit.getName());

            try3.writeObject(unit);

        }
        System.out.println("File Saved");


        try3.close();
        try2.close();
        try1.close();



        return false;
    }



}
