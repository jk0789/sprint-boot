package com.example.myapp.controller;


import com.example.myapp.model.Credential;
import com.example.myapp.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CredentialController {

    @Autowired
    private CredentialRepository credentialRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("credentials", credentialRepository.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam String ip, @RequestParam String port,
                       @RequestParam String username, @RequestParam String password) {
        Credential credential = new Credential();
        credential.setIp(ip);
        credential.setPort(port);
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        return "redirect:/";
    }
}
