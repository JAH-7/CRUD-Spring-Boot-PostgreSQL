package pe.creativity.Restfull.util;


import pe.creativity.Restfull.dto.NotaDto;
import pe.creativity.Restfull.entity.Nota;


public class Converter {
    /*Convertidor de DTO -> Entity
      Entyti -> DTO
     */

    public Nota toConvertNoteEntity(Nota noteEntity){
       // Nota noteentity = new Nota();
        //set entity values here from StudentDTO
        return noteEntity;
    }

    public NotaDto toConvertNoteDTO(NotaDto dtoNote){
       // NotaDto dtoNote = new NotaDto();
        //set dto values here from StudentEntity
        return dtoNote;
    }


}
