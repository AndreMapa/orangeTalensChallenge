package com.orangeChallenge.orangeChallenge.controller;

import com.orangeChallenge.orangeChallenge.dto.Request.UserRequest;
import com.orangeChallenge.orangeChallenge.dto.Request.VehicleRequest;
import com.orangeChallenge.orangeChallenge.dto.Response.UserResponse;
import com.orangeChallenge.orangeChallenge.dto.Response.VehicleResponse;
import com.orangeChallenge.orangeChallenge.feignbackend.VehicleClient;
import com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign.*;
import com.orangeChallenge.orangeChallenge.models.Error;
import com.orangeChallenge.orangeChallenge.models.User;
import com.orangeChallenge.orangeChallenge.repository.UserRepository;
import com.orangeChallenge.orangeChallenge.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleClient vehicleClient;

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/users")
    public ResponseEntity<?> postUser(@RequestBody @Valid UserRequest userRequest){
        if(userRepository.existsByCpf(userRequest.getCpf())|| userRepository.existsByEmail(userRequest.getEmail())){
            Error error = new Error("The Cpf or Email don't exists, please insert a new Cpf or Email",
                    HttpStatus.BAD_REQUEST.value(),null);
            return ResponseEntity.badRequest().body(error);
        }
        UserResponse userResponse = new UserResponse(userRepository.save(userRequest.toModel()));
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> postVehicle(@RequestBody @Valid VehicleRequest vehicleRequest){

        Optional<User> user = userRepository.findById(vehicleRequest.getIdUser());
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        VehicleResponse vehicleResponse = new VehicleResponse(vehicleRepository.save(vehicleRequest.toModel(user.get())),
                getValueCar(vehicleRequest.getMarca(), vehicleRequest.getModelo(), vehicleRequest.getAno()));
        return new ResponseEntity<>(vehicleResponse, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){

        if(!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userRepository.findById(id));
    }

    private String getCodBrand(String brand){
        List<CarBrandClient> vehicleClientBrand = vehicleClient.getCarBrand();
        Optional<CarBrandClient> vehicleBrandOptional = vehicleClientBrand.stream()
                .filter(vehicle -> vehicle.getNome().equals(brand)).findFirst();
        if(vehicleBrandOptional.isEmpty()){
            return null;
        }
        return vehicleBrandOptional.get().getCodigo();
    }

    private String getValueCar(String brand, String model, String year){
        String brandId = getCodBrand(brand);
        CarModelYearClient vehicleClientModelYear = vehicleClient.getModelCar(brandId);

        Optional<CarModelClient> vehicleModelOptional = vehicleClientModelYear.getModelos().stream()
                .filter(carBrandClient -> carBrandClient.getNome().equals(model)).findFirst();

        Optional<CarYearClient> vehicleYearOptional = vehicleClientModelYear.getAnos().stream()
                .filter((carBrandClient -> carBrandClient.getNome().equals(year))).findFirst();

        Map<String, String> vehicle = new HashMap<>();
        vehicleModelOptional.ifPresent(carModelClient -> vehicle.put("modeloId", carModelClient.getCodigo()));
        vehicleYearOptional.ifPresent(carYearClient -> vehicle.put("anoId", carYearClient.getCodigo()));

        CarValueClient valor = vehicleClient.getValueCar(brandId,vehicle.get("modeloId"), vehicle.get("anoId"));

        return valor.getValor();
    }
}
