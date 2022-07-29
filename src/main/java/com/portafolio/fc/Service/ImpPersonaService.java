package com.portafolio.fc.Service;

import com.portafolio.fc.Entity.Persona;
import com.portafolio.fc.Interface.IPersonaService;
import com.portafolio.fc.Repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    //traigo el repositorio para que me lea los campos que tengo y trabajo sobre eso
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        //devuelvo la lista de personas
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }
  
    @Override
    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    
    @Override
    public Persona findPersona(int id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
