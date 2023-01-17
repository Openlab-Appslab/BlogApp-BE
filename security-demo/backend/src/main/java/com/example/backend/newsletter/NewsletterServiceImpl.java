package com.example.backend.newsletter;

import com.example.backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsletterServiceImpl implements NewsletterService {


    private final NewsletterRepository repository;

    @Autowired
    public NewsletterServiceImpl(NewsletterRepository repository){
        this.repository = repository;
    }

    @Override
    public Newsletter addNewsletter(Newsletter newsletter) {
        return repository.save(newsletter);
    }

    @Override
    public Optional<Newsletter> getNewsletterByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public Newsletter updateNewsletter(Newsletter newsletter) {
        return this.repository.save(newsletter);
    }

    @Override
    public List<Newsletter> getAllNewsletter() {
        List<Newsletter> listOfNewsletter = new ArrayList<>();

        for (Newsletter newsletter: repository.findAll()){

                listOfNewsletter.add(newsletter);
            }

        return listOfNewsletter;
    }
}
