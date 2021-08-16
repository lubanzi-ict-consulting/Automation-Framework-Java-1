package dataProvider;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class getExcelConnect {

    private static FileInputStream fileInputStream;
    private static Sheet excelConnect;
    private static String[][] dataloginList;

    public static Sheet excelConnect(String filePath, String fileName, String Datatab) throws IOException, IOException {

        fileInputStream = new FileInputStream(new File(filePath + fileName));
        Workbook testDataWorkBook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            testDataWorkBook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtensionName.equals(".xls")) {
            testDataWorkBook = new HSSFWorkbook(fileInputStream);
        }
        return testDataWorkBook.getSheet(Datatab);
    }

    public static String[][] readExcel(String filePath, String fileName, String Datatab) throws Exception {
        excelConnect = excelConnect(filePath, fileName, Datatab);
        int rowCount = excelConnect.getLastRowNum() - excelConnect.getFirstRowNum();
        Row firstRow = excelConnect.getRow(0);
        int columnCount = firstRow.getLastCellNum() - 2;
        dataloginList = new String[rowCount][columnCount];
        int ci = 0;
        for (int i = 1; i < rowCount + 1; i++, ci++) {
            Row row = excelConnect.getRow(i);
            int cj = 0;
            for (int j = 0; j < row.getLastCellNum()-2; j++, cj++) {
                //System.out.print(row.getCell(j).getStringCellValue() + "|| ");
                String datalogin = row.getCell(j).getStringCellValue();
                System.out.print("here is datainfromation "+(row.getLastCellNum()-2) + " " +ci+"  "+cj+ "  "+datalogin);
                System.out.println();
                dataloginList[ci][cj] = datalogin;
            }
        }
        return (dataloginList);
    }

    public static void writeExcel(String filePath, String fileName, String Datatab, String acutalText, String testStatus,int rowid) throws IOException {
        File file = new File(filePath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook writeExcelBook = null;
        writeExcelBook = new XSSFWorkbook(inputStream);
        Sheet sheet = writeExcelBook.getSheet(Datatab);
        //int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row fillRow = sheet.getRow(rowid);
       // Row newRow = sheet.createRow(rowCount + 1);
        //for(int j = row.getLastCellNum()-1; j < row.getLastCellNum(); j++){
        //Fill data in row
        Cell cell = fillRow.createCell(fillRow.getLastCellNum()- 2);
        Cell cell2 = fillRow.createCell(fillRow.getLastCellNum()-1);
        cell.setCellValue(acutalText);
        cell2.setCellValue(testStatus);
        //}
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        writeExcelBook.write(outputStream);
        outputStream.close();
    }

    public static void shotBackwriteExcel(String filePath, String fileName, String Datatab,String enaringAmount,String availableBlance,String status) throws IOException {
        File file = new File(filePath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook writeExcelBook = null;
        writeExcelBook = new XSSFWorkbook(inputStream);
        Sheet sheet = writeExcelBook.getSheet(Datatab);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int fistRow = sheet.getFirstRowNum()+1;
        Row fillRow = sheet.getRow(fistRow);

        //CellStyle
        CellStyle borderStyle = writeExcelBook.createCellStyle();
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);

       // Row fillRow = sheet.getRow(rowid);
        // Row newRow = sheet.createRow(rowCount + 1);
        //for(int j = row.getLastCellNum()-1; j < row.getLastCellNum(); j++){
        //Fill data in row
        System.out.println("here is last column Number:" +fillRow.getLastCellNum());


        Cell blanceCell = fillRow.createCell(fillRow.getLastCellNum()-3);
        Cell earningCell = fillRow.createCell(fillRow.getLastCellNum()-2);
        Cell statusCell = fillRow.createCell(fillRow.getLastCellNum()-1);
        blanceCell.setCellStyle(borderStyle);
        earningCell.setCellStyle(borderStyle);
        statusCell.setCellStyle(borderStyle);

        blanceCell.setCellValue(availableBlance);
        earningCell.setCellValue(enaringAmount);
        statusCell.setCellValue(status);

        //}
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        writeExcelBook.write(outputStream);
        outputStream.close();
    }

}

