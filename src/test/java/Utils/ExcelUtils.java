package Utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Saltar el encabezado

            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for (int j = 0; j < colCount; j++) {
                    data[i][j] = getCellValue(row.getCell(j));
                }
                i++;
            }
            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public static List<Map<String, String>> getExcelDataByHeaders(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);

            // Leer la primera fila como encabezados
            Row headerRow = sheet.getRow(0);
            int numCols = headerRow.getLastCellNum();
            List<String> headers = new ArrayList<>();

            for (int i = 0; i < numCols; i++) {
                headers.add(headerRow.getCell(i).toString().trim());
            }

            // Leer las demás filas como datos
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Saltar la fila de encabezados

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, String> rowData = new HashMap<>();

                for (int i = 0; i < numCols; i++) {
                    Cell cell = row.getCell(i);
                    String cellValue = (cell == null) ? "" : cell.toString();
                    rowData.put(headers.get(i), cellValue.trim());  // Asocia cada celda al encabezado
                }

                data.add(rowData); // Añadir fila a la lista de datos
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
