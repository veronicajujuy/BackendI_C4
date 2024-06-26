package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
