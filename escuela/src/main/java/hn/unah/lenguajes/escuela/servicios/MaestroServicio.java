package hn.unah.lenguajes.escuela.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.escuela.modelos.Cursos;
import hn.unah.lenguajes.escuela.modelos.Direccion;
import hn.unah.lenguajes.escuela.modelos.Maestro;
import hn.unah.lenguajes.escuela.repositorios.DireccionRepositorio;
import hn.unah.lenguajes.escuela.repositorios.MaestroRepositorio;

@Service
public class MaestroServicio {

    @Autowired
    public MaestroRepositorio maestroRepositorio;

    @Autowired
    public DireccionRepositorio direccionRepositorio;

    public List<Maestro> obtenerTodos(){
        return this.maestroRepositorio.findAll();

    }

    public Maestro crearNuevoMaestro(Maestro nvoMaestro){
        if(this.maestroRepositorio.existsById(nvoMaestro.getCodigoMaestro())){
            return null;
        }

        Direccion direccion = nvoMaestro.getDireccion();
        if(direccion !=null ){
            direccion.setMaestro(nvoMaestro);
        }
            
        List<Cursos> cursos = nvoMaestro.getCurso();
        if(cursos != null){
            for(Cursos curso:cursos){
               curso.setMaestro(nvoMaestro); 
            }            
        }
        
        return this.maestroRepositorio.save(nvoMaestro);   

      


    }

   


    
}
