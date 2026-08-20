package com.market.efair.controller;

import com.market.efair.dtos.LoginDto;
import com.market.efair.entity.Client;
import com.market.efair.exception.NotFoundException;
import com.market.efair.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String upRegisterPage(Model model){

        model.addAttribute("clientData", new Client());

        return "/user/signInPage";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client){

        clientService.registerNewClient(client);

        System.out.println("Account created successfully");

        return "redirect:/";
    }

    @GetMapping("/login")
    public String upLoginPage(Model model){
        model.addAttribute("loginData", new LoginDto());

        return "/user/client/loginPage";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto){

        try {

            Client client = clientService.makeLogin(loginDto);

            if (client == null) {

                System.out.println("PASSWORD NOT MATCH! TRY AGAIN.");

            }

        }catch (NotFoundException ex){

            System.err.println("ERROR: " + ex.getMessage());

        }

        return "redirect:/";
    }
}
