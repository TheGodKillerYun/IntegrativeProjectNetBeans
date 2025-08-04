/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
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
public class CtrSelfMove {
    private bienvenido vistaBienvenido;
    private Registro vistaRegistro;
    private IniciarSesion vistaSesion;
    private Verificacion vistaVerificacion;
    private NuevaContra vistaPassword;
    private Cuentas cuenta;
    private ConsultasSM consulta;

    public CtrSelfMove(bienvenido vistaBienvenido, Registro vistaRegistro, IniciarSesion vistaSesion, Verificacion vistaVerificacion, NuevaContra vistaPassword, Cuentas cuenta, ConsultasSM consulta) {
        this.vistaBienvenido = vistaBienvenido;
        this.vistaRegistro = vistaRegistro;
        this.vistaSesion = vistaSesion;
        this.vistaVerificacion = vistaVerificacion;
        this.vistaPassword = vistaPassword;
        this.cuenta = cuenta;
        this.consulta = consulta;
        
        //Vista Bienvenido
        this.vistaBienvenido.getBtnIniciarSesion().addActionListener(e->mostrarIniciar());
        this.vistaBienvenido.getBtnregistrarse().addActionListener(e->mostrarRegistro());
        
        //Vista Registro
        this.vistaRegistro.getChkPoliticas().addActionListener(e->validarDatos());
        this.vistaRegistro.getBtnGuardar().addActionListener(e->guardarUsuario());
        this.vistaRegistro.getBtnOtraSesion().addActionListener(e->enviarAIniciarS());
        
        
        //Vista IniciarSesion
        this.vistaSesion.getBtnIniciarSesion().addActionListener(e->iniciarUsuario());
        this.vistaSesion.getBtnOtroRegistro().addActionListener(e->enviarARegistro());
        this.vistaSesion.getBtnOlvidaste().addActionListener(e->enviarAContrasenia());
        
        //Vista Verificacion
        this.vistaVerificacion.getBtnVerificar().addActionListener(e->verificar());
        this.vistaVerificacion.getBtnOtroCodigo().addActionListener(e->codigo());
        
        //Vista nueva contraseña
        this.vistaPassword.getBtnCambiar().addActionListener(e->verificarCorreo());
        this.vistaPassword.getBtnListo().addActionListener(e->recuperarContrasenia());
        this.vistaPassword.getBtnRegresar().addActionListener(e->regresarSesion());
    }
    
  
    public void inicio(){
        vistaBienvenido.setTitle("Bienvenido");
        vistaBienvenido.setLocationRelativeTo(null);
    }
    
    public void mostrarIniciar(){
        this.vistaSesion.setTitle("Iniciar Sesión");
        this.vistaSesion.setLocationRelativeTo(null);
        this.vistaSesion.setVisible(true);
        this.vistaBienvenido.dispose();
       
    }
    
    public void mostrarRegistro(){
        this.vistaRegistro.setTitle("Registrarse");
        this.vistaRegistro.setLocationRelativeTo(null);
        this.vistaRegistro.setVisible(true);
        this.vistaBienvenido.dispose();
    }
    
    public void enviarAIniciarS(){
        this.vistaSesion.getLblIncorrectos().setVisible(false);
        this.vistaSesion.setLocationRelativeTo(null);
        this.vistaSesion.setVisible(true);
        this.vistaRegistro.dispose();
    }
    
    public void enviarARegistro(){
        
        this.vistaRegistro.setLocationRelativeTo(null);
        this.vistaRegistro.setVisible(true);
        this.vistaSesion.dispose();
    }
    
    public void enviarAContrasenia(){
        this.vistaPassword.setTitle("Recuperar Contraseña");
        this.vistaPassword.setLocationRelativeTo(null);
        this.vistaPassword.setVisible(true);  
    }
    
    public void regresarSesion(){
        this.vistaSesion.getLblIncorrectos().setVisible(false);
        this.vistaSesion.setVisible(true);
        this.vistaPassword.dispose();
    }
    
    
    
     public void validarDatos(){
        String nombre = this.vistaRegistro.getTxtNombre().getText().trim();
        String correo = this.vistaRegistro.getTxtCorreo().getText().trim();
        String contrasenia = new String(this.vistaRegistro.getTxtContrasenia().getPassword()).trim();
        boolean politicas = this.vistaRegistro.getChkPoliticas().isSelected();
        
        boolean camposValidos = !nombre.isEmpty() && !correo.isEmpty() && !contrasenia.isEmpty()
                && !nombre.equals("Nombre Completo") && !correo.equals("Correo Electrónico") && !contrasenia.equals("Contraseña") 
                && politicas;
                
        this.vistaRegistro.getBtnGuardar().setEnabled(camposValidos);
        
    }
 
     
    public void guardarUsuario(){
        //Mandar a base de datos
        this.cuenta.setNombre(this.vistaRegistro.getTxtNombre().getText());
        this.cuenta.setCorreo(this.vistaRegistro.getTxtCorreo().getText());
        String contrasenia = new String(this.vistaRegistro.getTxtContrasenia().getPassword());
        this.cuenta.setContrasenia(contrasenia);
        
        if(this.consulta.registrar(cuenta)){
            
        }else{
            JOptionPane.showMessageDialog(null, "Error al registrarse");
        }
        
        this.limpiarRegistro();
        //abrir ventana de verificacion
        this.vistaVerificacion.setTitle("Verificar Cuenta");
        this.vistaVerificacion.setVisible(true);
        this.vistaVerificacion.setLocationRelativeTo(null);
        this.vistaRegistro.dispose();
        this.codigo();
    }
    
    public void iniciarUsuario(){
        this.cuenta.setCorreo(this.vistaSesion.getTxtCorreo1().getText());
        String contrasenia = new String(this.vistaSesion.getTxtPassword().getPassword());
        this.cuenta.setContrasenia(contrasenia);
        
        if(this.consulta.iniciarsesion(cuenta)){
            this.vistaSesion.getLblIncorrectos().setVisible(false);
            JOptionPane.showMessageDialog(null, "LO demas esta en proceso");
        }else{
            this.vistaSesion.getLblIncorrectos().setVisible(true);
        }
      
        
    }
    
    public void verificarCorreo(){
        this.vistaPassword.getLblNoRegistrado1().setVisible(false);
        this.cuenta.setCorreo(this.vistaPassword.getTxtCorreoo().getText());
        if(this.consulta.correo(cuenta)){
            this.vistaPassword.getBtnListo().setVisible(true);
            this.vistaPassword.getTxtContras().setVisible(true);
            this.vistaPassword.getTxtContrasVer().setVisible(true);
            this.vistaPassword.getLblimagen().setVisible(true);
            this.vistaPassword.getLblImagen2().setVisible(true);
            this.vistaPassword.getLblImagen3().setVisible(true);
            this.vistaPassword.getLblIngresa().setVisible(true);
        }else{
            this.vistaPassword.getLblNoRegistrado1().setVisible(true);
        } 
    }
    
    public void recuperarContrasenia(){
        String contrasenia = new String(this.vistaPassword.getTxtContras().getPassword());
        String contrasenia2 = new String(this.vistaPassword.getTxtContrasVer().getPassword());
        this.cuenta.setContrasenia(contrasenia2);
        this.cuenta.setCorreo(this.vistaPassword.getTxtCorreoo().getText());
        
        
        if(contrasenia.equals(contrasenia2)){
            this.consulta.recuperarContrasenia(cuenta);
            this.vistaPassword.getLblNoCoinciden().setVisible(false);
            JOptionPane.showMessageDialog(null, "Contraseña actualizada");
            
            this.vistaSesion.getLblIncorrectos().setVisible(false);
            this.limpiarSesion();
            this.vistaPassword.dispose();     
        }else{
            this.vistaPassword.getLblNoCoinciden().setVisible(true);
        }
    }
    
    
    //Vista de verificacion
    public void verificar(){
        this.cuenta.setDigito1(Integer.parseInt(this.vistaVerificacion.getTxtDigito1().getText()));
        this.cuenta.setDigito2(Integer.parseInt(this.vistaVerificacion.getTxtDigito2().getText()));
        this.cuenta.setDigito3(Integer.parseInt(this.vistaVerificacion.getTxtDigito3().getText()));
        this.cuenta.setDigito4(Integer.parseInt(this.vistaVerificacion.getTxtDigito4().getText()));
        
        if(this.cuenta.validar() == 1){
            JOptionPane.showMessageDialog(null, "Se verificó su cuenta");
            this.limpiarDigitos();
            //this.vistaVerificacion.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Código Incorrecto, intente de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            this.limpiarDigitos();
        } 
    }
    
    public void codigo(){  
        JOptionPane.showMessageDialog(null, "Su código de verificacion es " + this.cuenta.enviarCodigo());
    }
    
    
    
    
    //Para limpiar los txt solo estetica
    
    
    private void limpiarDigitos(){
        this.vistaVerificacion.getTxtDigito1().setText("");
        this.vistaVerificacion.getTxtDigito2().setText("");
        this.vistaVerificacion.getTxtDigito3().setText("");
        this.vistaVerificacion.getTxtDigito4().setText("");
    }
    
    private void limpiarSesion(){
        
        this.vistaSesion.getTxtCorreo1().setText("");
        this.vistaSesion.getTxtPassword().setText("");
    }
   
    private void limpiarRegistro(){
        this.vistaRegistro.getTxtCorreo().setText("");
        this.vistaRegistro.getTxtNombre().setText("");
        this.vistaRegistro.getTxtContrasenia().setText("");
    }
            
}
