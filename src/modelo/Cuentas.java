/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author NuevoUser
 */
public class Cuentas {
    private String codigo;
    private int digito1;
    private int digito2;
    private int digito3;
    private int digito4;
    
    private String nombre;
    private String correo;
    private String contrasenia;
    
    private String confirmarC;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDigito1() {
        return digito1;
    }

    public void setDigito1(int digito1) {
        this.digito1 = digito1;
    }

    public int getDigito2() {
        return digito2;
    }

    public void setDigito2(int digito2) {
        this.digito2 = digito2;
    }

    public int getDigito3() {
        return digito3;
    }

    public void setDigito3(int digito3) {
        this.digito3 = digito3;
    }

    public int getDigito4() {
        return digito4;
    }

    public void setDigito4(int digito4) {
        this.digito4 = digito4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getConfirmarC() {
        return confirmarC;
    }

    public void setConfirmarC(String confirmarC) {
        this.confirmarC = confirmarC;
    }

    
    
    
    //VALIDA LOS DIGITOS INGRESADOS
    public int validar(){
        if(this.digito1 == 2 && this.digito2 == 7 && this.digito3 == 2 && this.digito4 == 7){
            return 1;    
        }else{
            return 0;
        }
    }
    
    
    
    //CODIGO DE VERIFICACION PARA MENSAJE
    public String enviarCodigo(){
        return "2727";
    }
}
