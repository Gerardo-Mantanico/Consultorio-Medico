package com.consultationapi.consultationapi.model.repuestaLab;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Resultado {
    private int id;
    private String nombre;
    private String ruta;
    private int idSoliitud;
    private int idExamen;
}
