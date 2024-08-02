package hn.unah.lenguajes.escuela.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.escuela.modelos.Maestro;
import hn.unah.lenguajes.escuela.servicios.MaestroServicio;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/maestros")
public class MaestroControlador {

    @Autowired
    public MaestroServicio maestroServicio;

    @GetMapping("/obtener/todos")
    public List<Maestro> obtenerTodos(){
        return this.maestroServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public Maestro crearMaestro(@RequestBody Maestro nvoMaestro) {
        return this.maestroServicio.crearNuevoMaestro(nvoMaestro);
        
    }
    
}
