package dao;

import dto.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
