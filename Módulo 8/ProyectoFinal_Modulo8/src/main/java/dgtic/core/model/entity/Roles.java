package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Relación Bidireccional: Un Rol tiene muchos Usuarios
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<Usuarios> usuarios;

    @Override
    public String toString() {
        return "Roles{id=" + id + ", nombre='" + nombre + "'}";
    }
}