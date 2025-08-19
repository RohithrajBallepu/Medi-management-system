package dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity

public class Appointment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne
	    private Patient patient;

	    @ManyToOne
	    private Doctor doctor;

	    private LocalDateTime appointmentDateTime;

	    private String status;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public LocalDateTime getAppointmentDateTime() {
			return appointmentDateTime;
		}

		public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
			this.appointmentDateTime = appointmentDateTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", appointmentDateTime="
					+ appointmentDateTime + ", status=" + status + "]";
		}
		

}
