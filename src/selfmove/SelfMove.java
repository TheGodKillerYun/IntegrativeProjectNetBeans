/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selfmove;

import controlador.CtrSelfMove;
import modelo.ConsultasSM;
import modelo.Cuentas;
import vistas.IniciarSesion;
import vistas.NuevaContra;
import vistas.Registro;
import vistas.Verificacion;
import vistas.bienvenido;

/**
 *
 * @author NuevoUser
 */
public class SelfMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bienvenido vistaBienvenido = new bienvenido();
        Registro vistaRegistro = new Registro();
        IniciarSesion vistaSesion = new IniciarSesion();
        Verificacion vistaVerificacion = new Verificacion();
        NuevaContra vistaPassword = new NuevaContra();
        Cuentas cuenta = new Cuentas();
        ConsultasSM consulta = new ConsultasSM();
        CtrSelfMove controlador = new CtrSelfMove(vistaBienvenido, vistaRegistro,vistaSesion, vistaVerificacion, vistaPassword, cuenta, consulta );
       
        
        controlador.inicio();
        vistaBienvenido.setVisible(true);
        
    }
    
}
