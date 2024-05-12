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
        pdfFileDownloadService.load("http://118.179.119.118/report/Default.aspx?token=YXUydgOXe0RSgIrCqV6WTmeglTJJWpGDLAZuWMges5O7cRU3d3y0zhKh%2F1Q0FZx7YLA3MEnX8Q6kB0goWMfAcTMEHKe2OWnkFTegs2LK191IPV8ZknHHTQHVxazjVJ5iSpGp9KeEN6VuRFK2cpMwLxvQXkS1Ei8xo1tKiGRvZExTP6o0PJTn0z9cpUxCjyyNdnywbGPjujyrMKMt3qUvjiXlIX6t%2FStfvRY9%2BTkSo9EODuvnPJTK479CvmnXp8P0Ll6u0BZPPB9t2kiKgdSBSTchmg%2Fk8OWQWFZ4tU7z12iYlCD5BFai%2BaegbjdUrfM1hWcT%2BN85EznXBkFbC1me2FnwGNTHzg9nHXae4yHrTUDP8M%2FQUEEqAmIuG1dtn%2BPEid7BVDXsiJtV7acWmx3ak58ldmGByOGAtk%2BSzYe1gxloHtrlGb6XLAioUQkEBmB3aLH8%2F%2BM8F0q17p9tG6h%2BYefWq8bFNHOUtDgwKtRynn9TjekJ9J54s0qt7TMFgmpmnnSPDs4LFX%2FqOGwYAgpufsIfInY61v3rt1nverWj50PIbqXg8YK7gqQDaH7PXXtC0SSJgkoL4iC3JzQUhRJQaDwvL%2For4mM71auYnkw2khb99dk2YzRtI1Xf53SyGylvyeONlGtI6mxrO6U8kc3f%2BhmSe5KTLJRQVVHwCqgANVOBu8IvKsXzO4g8bfu5hgU7m4ug6F3CQDjShAl20aRTqSnxlavEzOmPO0HXczfdUiYxMygU%2F9BpWEHEZtSU8s1d");
        return "save-pdf";
    }
}
