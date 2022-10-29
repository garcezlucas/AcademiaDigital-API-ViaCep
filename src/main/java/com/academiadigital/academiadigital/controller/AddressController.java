package com.academiadigital.academiadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.academiadigital.academiadigital.service.api.AddressInterface;
import com.academiadigital.academiadigital.entity.Address;
import com.academiadigital.academiadigital.service.response.AddressResponse;
import com.academiadigital.academiadigital.repository.AddressRepository;

@RestController
public class AddressController{
    

    @Autowired
    private AddressInterface addressInterface;

    @Autowired
    private AddressRepository addressRepository;


    @GetMapping("/api/{cep}")
    public ResponseEntity<AddressResponse> getByCep(@PathVariable String cep){

        //Buscando resultado da API do ViaCEP
        AddressResponse response = addressInterface.getAddressByCep(cep);

        //Criando um novo registro no banco de dados

        if(response.getCep() != null){
            Address address = new Address(
                    response.getCep(),
                    response.getLogradouro(),
                    response.getComplemento(),
                    response.getBairro(),
                    response.getLocalidade(),
                    response.getUf(),
                    response.getIbge(), 
                    response.getGia(),
                    response.getDdd(), 
                    response.getSiafi()
            );
            
            addressRepository.save(address);
        }
        

        return response.getCep() != null ? ResponseEntity.ok().body(response)
        : ResponseEntity.notFound().build();
    }

    @GetMapping("/api/{uf}/{cidade}/{logradouro}")
    public ResponseEntity<List<AddressResponse>> getByDescription(
        @PathVariable("uf") String uf,
        @PathVariable("cidade") String cidade,
        @PathVariable("logradouro") String logradouro
    ){

        List<AddressResponse> addresses = addressInterface.getAddressByDescription(uf, cidade, logradouro);

        return addresses != null ? ResponseEntity.ok().body( addresses ) 
        : ResponseEntity.notFound().build();
    }

}
