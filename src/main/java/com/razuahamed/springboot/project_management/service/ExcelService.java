package com.razuahamed.springboot.project_management.service;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService {
    public XSSFWorkbook generateDummyExcel(List<Member> members) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("active");
        headerRow.createCell(2).setCellValue("age");
        headerRow.createCell(3).setCellValue("Email");
        headerRow.createCell(0).setCellValue("Image_path");
        headerRow.createCell(1).setCellValue("name");
        headerRow.createCell(2).setCellValue("Password");

        int rowIndex = 1;
        for (Member member : members) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(member.getId());
            row.createCell(1).setCellValue(member.isActive());
            row.createCell(2).setCellValue(member.getAge());
            row.createCell(3).setCellValue(member.getEmail());
            row.createCell(4).setCellValue(member.getImagePath());
            row.createCell(5).setCellValue(member.getName());
            row.createCell(6).setCellValue("Confidential");
        }

        return workbook;
    }
}
