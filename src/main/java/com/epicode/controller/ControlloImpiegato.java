package com.epicode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.eccezione.EccezioneRisorsaMancante;
import com.epicode.modello.Impiegato;
import com.epicode.repository.ImpiegatoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class ControlloImpiegato {
	@Autowired
	private ImpiegatoRepository impiegatoRepository;
	
	
	@GetMapping("/Impiegato")
	public List<Impiegato> getAllEmployees(){
		return impiegatoRepository.findAll();
	}		
	

	@PostMapping("/Impiegato")
	public Impiegato createEmployee(@RequestBody Impiegato employee) {
		return impiegatoRepository.save(employee);
	}
	
	
	@GetMapping("/Impiegato/{id}")
	public ResponseEntity<Impiegato> getEmployeeById(@PathVariable Long id) {
		Impiegato impiegato = impiegatoRepository.findById(id)
				.orElseThrow(() -> new EccezioneRisorsaMancante("L'Impiegato non esiste con questo id: " + id));
		return ResponseEntity.ok(impiegato);
	}
	
	
	@PutMapping("/Impiegato/{id}")
	public ResponseEntity<Impiegato> updateEmployee(@PathVariable Long id, @RequestBody Impiegato employeeDetails){
		Impiegato impiegato = impiegatoRepository.findById(id)
				.orElseThrow(() -> new EccezioneRisorsaMancante("L'Impiegato non esiste con questo id :" + id));
		
		impiegato.setFirstName(employeeDetails.getFirstName());
		impiegato.setLastName(employeeDetails.getLastName());
		impiegato.setdepartmentid(employeeDetails.getdepartmentId());
		impiegato.sethireYear(employeeDetails.gethireYear());
		impiegato.setregion(employeeDetails.getregion());
		impiegato.setcity(employeeDetails.getcity());
		
		Impiegato modificaImpiegato = impiegatoRepository.save(impiegato);
		return ResponseEntity.ok(modificaImpiegato);
	}
	
	@DeleteMapping("/Impiegato/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Impiegato cancellaImpiegato = impiegatoRepository.findById(id)
				.orElseThrow(() -> new EccezioneRisorsaMancante("L'Impiegato non esiste con questo id: " + id));
		
		impiegatoRepository.delete(cancellaImpiegato);
		Map<String, Boolean> response = new HashMap<>();
		response.put("cancellato", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
