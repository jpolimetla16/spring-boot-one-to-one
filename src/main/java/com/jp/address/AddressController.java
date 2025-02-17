package com.jp.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.user.UserRepository;

@RestController
@RequestMapping("/address")
public class AddressController {
	
   @Autowired	
   private AddressRepository addressRepository;
   
   @Autowired
   private UserRepository userRepository;
	
   @GetMapping("/{id}")
   public AddressEntity getAddress(@PathVariable Integer id) {
	   return addressRepository.findById(id).orElse(null);
   }
   
   @PostMapping
   public AddressEntity saveAddress(@RequestBody AddressEntity addressEntity) {
	   System.out.println(addressEntity.getUsers());
	   return addressRepository.save(addressEntity);
   }
}
