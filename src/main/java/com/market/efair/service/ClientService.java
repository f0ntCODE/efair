package com.market.efair.service;

import com.market.efair.dtos.LoginDto;
import com.market.efair.entity.Client;
import com.market.efair.exception.NotFoundException;
import com.market.efair.repository.ClientRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
        

    }

    /**
     * CREATE A NEW CLIENT ACCOUNT IN THE SYSTEM
     * @param clientData contains all of {@link Client} params to create an account. All user info must be valid.
     *
     * **/

    @Transactional
    public void registerNewClient(Client clientData){

            /*CAN I ADD A BUILDER DESIGN PATTERN HERE?*/
            Client client = new Client(
                    clientData.getName(),
                    clientData.getEmail(),
                    clientData.getPassword(),
                    clientData.getCPF(),
                    clientData.getAddress(),
                    clientData.getBirthDate()
            );

            clientRepo.save(client);

    }


    public Client makeLogin(LoginDto loginDto){

        Client found = clientRepo.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Email not found"));

        if(isPassMatch(loginDto.getPassword(), found)){

            System.out.println("WELCOME!");

            return found;
        }

        return null;

    }

    private boolean isPassMatch(String pass, Client client){

        return (pass.equals(client.getPassword()));

    }
}
