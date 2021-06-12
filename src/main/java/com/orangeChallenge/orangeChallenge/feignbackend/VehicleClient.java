package com.orangeChallenge.orangeChallenge.feignbackend;

import com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Map;


@FeignClient(name = "vehicle", url = "https://parallelum.com.br/fipe/api/v1/")
public interface VehicleClient {

    @GetMapping("/carros/marcas")
    List<CarBrandClient> getCarBrand();

    @GetMapping("/carros/marcas/{marcaId}/modelos")
    CarModelYearClient getModelCar(@PathVariable("marcaId") String marcaId);

    @GetMapping("/carros/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}")
    CarValueClient getValueCar(@PathVariable("marcaId") String marcaId,
                               @PathVariable("modeloId") String modeloId,
                               @PathVariable("anoId") String anoId);
}
