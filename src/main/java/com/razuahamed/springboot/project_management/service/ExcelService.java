package com.razuahamed.springboot.project_management.service;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    private MemberRepository memberRepository;
    public ExcelService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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

    public void updateMemberFromExcel(MultipartFile memberList) {
        /*
         * id , active, age, email, imagePath, name, Password
         * */
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(memberList.getInputStream());
            XSSFSheet membersSheet = workbook.getSheetAt(0); // there can be many sub sheet
            int totalCount = 0, totalUpdatedResult = 0;
            for (Row member : membersSheet) {
                if (member.getRowNum() == 0 || member.getCell(0) == null) {
                    continue; // Skip header or incomplete first row
                }
                String id = member.getCell(0).getStringCellValue();
                String active = member.getCell(1).getStringCellValue();
                String age = member.getCell(2).getStringCellValue();
                String email = member.getCell(3).getStringCellValue();
                String imagePath = member.getCell(4).getStringCellValue();
                String name = member.getCell(5).getStringCellValue();
                String password = member.getCell(6).getStringCellValue();
                Member member1 = new Member();
                member1.setId(Long.parseLong(id));
                member1.setAge(Integer.parseInt(age));
                member1.setEmail(email);
                member1.setName(name);
                member1.setPassword(password);
                member1.setImagePath(imagePath);
                member1.setActive(Boolean.parseBoolean(active));
                memberRepository.save(member1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
