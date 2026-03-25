package dgtic.core.service;

import dgtic.core.model.dto.InscripcionesDTO;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public void actualizarCalificacion(InscripcionesDTO dto) {
        // Lógica de negocio para actualizar solo la calificación
        Inscripciones inscripcion = inscripcionRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("El registro de inscripción no existe"));

        inscripcion.setCalificacion(dto.getCalificacion());
        inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripciones> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    @Override
    public List<Inscripciones> obtenerInscripcionesPorAlumno(Integer usuarioId) {
        return inscripcionRepository.findByAlumnoUsuarioId(usuarioId);
    }

    @Override
    public List<Inscripciones> obtenerInscripcionesPorProfesor(Integer usuarioId) {
        return inscripcionRepository.findByGrupoProfesorUsuarioId(usuarioId);
    }
}
