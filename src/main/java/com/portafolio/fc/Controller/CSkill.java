package com.portafolio.fc.Controller;

import com.portafolio.fc.Dto.dtoSkill;
import com.portafolio.fc.Entity.Skill;
import com.portafolio.fc.Security.Controller.Mensaje;
import com.portafolio.fc.Service.SSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "*")


public class CSkill {
    @Autowired
    SSkill sSkill;
    
    @GetMapping ("/lista")
    public ResponseEntity <List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoski){
        if(StringUtils.isBlank(dtoski.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre de la Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreS(dtoski.getNombreS()))
            return new ResponseEntity(new Mensaje("La Habilidad ingresada ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(dtoski.getImgSkill(), dtoski.getNombreS(), dtoski.getProgress());
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Nueva Habilidad Agregada Correctamente"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoSkill dtoski){
        if(!sSkill.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreS(dtoski.getNombreS())
            && 
           sSkill.getByNombreS(dtoski.getNombreS()).get().getId() !=id)
                return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoski.getNombreS()))
            return new ResponseEntity(new Mensaje("El Nombre de la Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreS(dtoski.getNombreS());
        skill.setImgSkill(dtoski.getImgSkill());
        skill.setProgress(dtoski.getProgress());
            sSkill.save(skill);
            return new ResponseEntity(new Mensaje("Habilidad Actualizada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sSkill.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        sSkill.delete(id);
            return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }
}
