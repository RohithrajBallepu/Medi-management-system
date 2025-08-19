package controller;

import dto.Patient;
import org.springframework.web.bind.annotation.CrossOrigin;

import dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {
	 @Autowired
	    private PatientRepository patientRepository;

	    @GetMapping
	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	    @PostMapping
	    public Patient createPatient(@RequestBody Patient patient) {
	    	 System.out.println("Received patient: " + patient);
	        return patientRepository.save(patient);
	    }

	    @GetMapping("/{id}")
	    public Patient getPatientById(@PathVariable Integer id) {
	        return patientRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient updatedPatient) {
	        return patientRepository.findById(id).map(patient -> {
	            patient.setName(updatedPatient.getName());
	            patient.setAge(updatedPatient.getAge());
	            patient.setAddress(updatedPatient.getAddress());
	            return patientRepository.save(patient);
	        }).orElse(null);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePatient(@PathVariable Integer id) {
	        patientRepository.deleteById(id);
	    }
}
