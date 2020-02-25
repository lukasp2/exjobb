import java.io.FileInputStream;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRW {
    private static Workbook wb;
    private static Sheet sheet;
    private static FileInputStream ifs;
    private static FileOutputStream ofs;
    private static Row row;
    private static Cell cell;

    ExcelRW(String filename) {
	ifs = new FileInputStream(filename);
	wb = WorkbookFactory.create(ifs);
	sheet = wb.getSheetAt(0);
    }
    
    public static float readCell(int x, int y) {
	row = sheet.getRow(y);
	cell = row.getCell(x);

	return cell.getNumericCellValue();
    }
}
