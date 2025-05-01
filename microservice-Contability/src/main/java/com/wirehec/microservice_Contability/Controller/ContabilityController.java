package com.wirehec.microservice_Contability.Controller;

import com.wirehec.microservice_Contability.Controller.DTO.ContabilityDTO;
import com.wirehec.microservice_Contability.Entity.ContabilityEntity;
import com.wirehec.microservice_Contability.Service.Impl.ContabilityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contability")
@Slf4j
public class ContabilityController {

    @Autowired
    private ContabilityServiceImpl contabilityService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<ContabilityDTO> contabilityDTOs = contabilityService.findAll()
                .stream()
                .map(contability -> ContabilityDTO.builder()
                        .idContabilidad(contability.getIdContabilidad())
                        .presupuestomensual(contability.getPresupuestomensual())
                        .beneficio(contability.getBeneficio())
                        .gasto(contability.getGasto())
                        .build()
                )
                .toList(); // Collect the stream into a list
        return ResponseEntity.ok(contabilityDTOs);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveContability(@RequestBody ContabilityDTO contabilityDTO) {
        ContabilityEntity contabilityEntity = ContabilityEntity.builder()
                .idContabilidad(contabilityDTO.getIdContabilidad())
                .presupuestomensual(contabilityDTO.getPresupuestomensual())
                .beneficio(contabilityDTO.getBeneficio())
                .gasto(contabilityDTO.getGasto())
                .build();
        ContabilityEntity savedContability = contabilityService.saveContability(contabilityEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContability);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContability(@PathVariable Long id, @RequestBody ContabilityDTO contabilityDTO) {
        ContabilityEntity contabilityEntity = ContabilityEntity.builder()
                .idContabilidad(id)
                .presupuestomensual(contabilityDTO.getPresupuestomensual())
                .beneficio(contabilityDTO.getBeneficio())
                .gasto(contabilityDTO.getGasto())
                .build();
        ContabilityEntity updatedContability = contabilityService.saveContability(contabilityEntity);
        return ResponseEntity.ok(updatedContability);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContability(@PathVariable Long id) {
        contabilityService.deleteContability(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
