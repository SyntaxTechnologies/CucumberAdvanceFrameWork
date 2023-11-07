package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    /**
     * Reads data from an Excel sheet and returns it as a list of maps, each representing a row with column headers as keys.
     *
     * @param sheetName The name of the sheet within the Excel file.
     * @param path      The path to the Excel file.
     * @return A list of maps, each map containing the data of a single row with the header as keys.
     */
    public static List<Map<String, String>> readExcelSheet(String sheetName, String path) {
        List<Map<String, String>> excelData = new ArrayList<>();
        // Using try-with-resources to ensure the FileInputStream is closed after use
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                Map<String, String> rowData = new LinkedHashMap<>();
                for (int colIndex = 0; colIndex < headerRow.getLastCellNum(); colIndex++) {
                    String key = headerRow.getCell(colIndex).getStringCellValue();
                    String value = currentRow.getCell(colIndex).getStringCellValue();
                    rowData.put(key, value);
                }
                excelData.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read from the Excel file: " + path);
        }
        return excelData;
    }
}
