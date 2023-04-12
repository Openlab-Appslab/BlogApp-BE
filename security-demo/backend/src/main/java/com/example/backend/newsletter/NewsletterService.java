package com.example.backend.newsletter;

import java.util.List;
import java.util.Optional;


public interface NewsletterService {

        Newsletter addNewsletter(Newsletter newsletter);

        Optional<Newsletter> getNewsletterByEmail(String email);

        Newsletter updateNewsletter(Newsletter newsletter);

    List<Newsletter> getAllNewsletter();
}
