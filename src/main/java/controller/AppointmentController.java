package controller;
import dto.Appointment;
import dao.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")

public class AppointmentController {
	@Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Integer id, @RequestBody Appointment updatedAppointment) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setPatient(updatedAppointment.getPatient());
            appointment.setDoctor(updatedAppointment.getDoctor());
            appointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
            appointment.setStatus(updatedAppointment.getStatus());
            return appointmentRepository.save(appointment);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentRepository.deleteById(id);
    }

}
