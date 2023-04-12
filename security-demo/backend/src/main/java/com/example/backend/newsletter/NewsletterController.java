package com.example.backend.newsletter;

import com.example.backend.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsletterController {

    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }
    @GetMapping(path ="/noAuth/getAllNewsletter")
    public List<Newsletter> getAllNewsletter(){
        return newsletterService.getAllNewsletter();
    }
    @PostMapping(path = "/noAuth/addNewsletter")
    public Newsletter addNewNewsletter (@RequestBody Newsletter newsletter) {
        return newsletterService.addNewsletter(newsletter);}
}
