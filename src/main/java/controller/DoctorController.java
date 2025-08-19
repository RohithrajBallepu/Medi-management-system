package controller;
import dto.Doctor;
import dao.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	 @Autowired
	    private DoctorRepository doctorRepository;

	    @GetMapping
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    @PostMapping
	    public Doctor createDoctor(@RequestBody Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }

	    @GetMapping("/{id}")
	    public Doctor getDoctorById(@PathVariable Integer id) {
	        return doctorRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor updatedDoctor) {
	        return doctorRepository.findById(id).map(doctor -> {
	            doctor.setName(updatedDoctor.getName());
	            doctor.setSpecialization(updatedDoctor.getSpecialization());
	            doctor.setContact(updatedDoctor.getContact());
	            return doctorRepository.save(doctor);
	        }).orElse(null);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteDoctor(@PathVariable Integer id) {
	        doctorRepository.deleteById(id);
	    }
}
