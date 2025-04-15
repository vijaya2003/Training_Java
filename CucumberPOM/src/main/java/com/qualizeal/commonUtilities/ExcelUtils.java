package com.qualizeal.commonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String[][] returnExcelData(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
 
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
 
        String[][] data = new String[rowCount - 1][colCount];
 
        for (int i = 1; i < rowCount; i++) {
        	if (sheet.getRow(i) != null) {
        		for (int j = 0; j < colCount; j++) {
                    DataFormatter formatter = new DataFormatter();
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }        	}
        }
 
        wb.close();
        return data;
    }
    
        private boolean isRowEmpty(String[] row) {
        for (String cell : row) {
            if (cell != null && !cell.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
