package com.razuahamed.springboot.project_management.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
    public XSSFWorkbook generateDummyExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Password");
        headerRow.createCell(2).setCellValue("Roll");
        headerRow.createCell(3).setCellValue("Email");
        return workbook;
    }
}
