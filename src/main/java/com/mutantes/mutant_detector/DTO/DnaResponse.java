package com.mutantes.mutant_detector.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DnaResponse {
    //NO tiene campos ya que solo devolvemos 200 o 403
    // Pero existe para el dia que se quiera agregar "mensaje" o "id" sea más facil

}
