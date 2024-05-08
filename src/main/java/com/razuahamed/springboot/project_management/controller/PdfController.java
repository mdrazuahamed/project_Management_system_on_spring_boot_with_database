package com.razuahamed.springboot.project_management.controller;

import com.razuahamed.springboot.project_management.service.PdfFileDownloadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    private PdfFileDownloadService pdfFileDownloadService;

    public PdfController(PdfFileDownloadService pdfFileDownloadService){
        this.pdfFileDownloadService = pdfFileDownloadService;
    }

    @GetMapping("/save")
    public String savePdf(Model model) {
        pdfFileDownloadService.load("https://www.orimi.com/pdf-test.pdf");
        return "save-pdf";
    }
}
