import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PieceLoader {

    private ArrayList<ChessPiece> piecelist;
    private ArrayList<String> memelist;
    private DataFormatter dataFormatter = new DataFormatter();

    public PieceLoader() throws IOException {
        piecelist = new ArrayList<>();
        memelist = new ArrayList<>();
    }

    public ArrayList<ChessPiece> loadPieces() throws IOException {

        Workbook workbook = WorkbookFactory.create(new File(test9fx.XLSX_FILE_PATH));

        Sheet sheet = workbook.getSheetAt(0);

//        System.out.println("\n Why Again?\n");

        Iterator<Row> rowIterator = sheet.rowIterator();

        //skip the headers
        rowIterator.next();

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(!memelist.add(dataFormatter.formatCellValue(cell))){
                    System.out.println("Was not able to add");
                }
            }
            if(memelist.size()==4) {
                piecelist.add(new ChessPiece(memelist.get(0), memelist.get(1), "",
                        memelist.get(2), Integer.parseInt(memelist.get(3))));
            }
            else{
                piecelist.add(new ChessPiece(memelist.get(0), memelist.get(1),
                        memelist.get(2), memelist.get(3), Integer.parseInt(memelist.get(4))));
            }
            memelist.clear();

        }

        workbook.close();
        return piecelist;
    }


}
