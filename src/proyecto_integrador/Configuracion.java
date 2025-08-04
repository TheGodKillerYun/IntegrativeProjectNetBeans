/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_integrador;

import Controlador.ctrConfig;
import Modelo.Consultas;
import Modelo.Funciones;
import Vista.Terminos;
import Vista.avisos;
import Vista.callCenter;
import Vista.cambioPw;
import Vista.chatAsesor;
import Vista.config;
import Vista.editarP;
import Vista.reporte;

/**
 *
 * @author danil
 */
public class Configuracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        config vista = new config();
        Consultas consulta = new Consultas();
        Terminos vista2 = new Terminos();
        avisos vista3 = new avisos();
        editarP vista4 = new editarP();
        callCenter vista5 = new callCenter();
        chatAsesor vista6 = new chatAsesor();
        cambioPw vista7 = new cambioPw();
        reporte vista8 = new reporte();
        Funciones menu = new Funciones();
        ctrConfig controlador = new ctrConfig(menu, vista, vista2, vista3, vista4,vista5,vista6, vista7,vista8, consulta); 
        
        controlador.iniciar();
        vista.setVisible(true);
    }
    
}
