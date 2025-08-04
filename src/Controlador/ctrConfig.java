/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class ctrConfig {
    private Funciones menu ;
    private Consultas consulta;
    private config vista;
    private Terminos vista2;
    private avisos vista3;
    private editarP vista4;
    private callCenter vista5;
    private chatAsesor vista6;
    private cambioPw vista7;
    private reporte vista8;

    public ctrConfig(Funciones menu, config vista, Terminos vista2, avisos vista3, editarP vista4,callCenter vista5,chatAsesor vista6, cambioPw vista7,reporte vista8, Consultas consulta) {
        this.menu = menu;
        this.consulta = consulta;
        this.vista = vista;
        this.vista2 = vista2;
        this.vista3 = vista3;
        this.vista4 = vista4;
        this.vista5 = vista5;
        this.vista6 = vista6;
        this.vista7 = vista7;
        this.vista8 = vista8;
        
       this.vista2.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        }
    });
       this.vista3.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        }
    });
       this.vista4.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        }
    });
       this.vista5.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        }
    });
       
       this.vista6.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        }
    });
       
       this.vista7.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        editarPerfil();
        }
    });
       
       this.vista.getLblCondi().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        terminos();
        }
    });
       
       this.vista.getLblAvisos().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        avisos();
        }
    });
        this.vista.getLblReporte().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        generarReporte();
        }
    });
       
      this.vista.getLblEditar().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        editarPerfil();
        }
    });
      
      this.vista4.getLblActualizar().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        actualizarDatos();
        }
    });
      
      
      this.vista4.getBtnCambio().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        cambioCon();
        
        }
    });
      
      this.vista.getLblCallC().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        callCenter();
        }
    });
      this.vista7.getLblCambiar().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        cambiarPw();
        
        }
    });
      this.vista8.getLblBack().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        menu();
        
        }
    });
      
      this.vista.getLblChat().addMouseListener(new java.awt.event.MouseAdapter() {
       @Override
       public void mouseClicked(java.awt.event.MouseEvent evt) {
        chat();
        
        }
    });
      ;
      
    }
    
    public void iniciar(){
        vista.setTitle("Configuracion");
        vista.setLocationRelativeTo(null);
    }
    
    public void terminos(){
        vista2.setVisible(true);
        this.vista.dispose();
    }
    
    public void menu(){
        vista.setVisible(true);
        this.vista2.dispose();
        this.vista3.dispose();
        this.vista4.dispose();
        this.vista5.dispose();
        this.vista6.dispose();
        this.vista8.dispose();
    }
    
    public void avisos(){
        vista3.setVisible(true);
        vista.setVisible(false);
    }
    private void limpiar(){
        this.vista4.getTxtCorreo().setText(null);
        this.vista4.getTxtNombre().setText(null);
        this.vista4.getTxtTelefono().setText(null);
        this.vista4.getTxtNacimiento().setText(null);
        this.vista7.getTxtConNueva().setText(null);
        this.vista7.getTxtConRepite().setText(null);
        this.vista7.getTxtConActual().setText(null);
        this.vista7.getTxtCorreo().setText(null);
    }
   public void editarPerfil(){
        vista4.setVisible(true);
        vista.setVisible(false);
        vista7.setVisible(false);
    }
   
   public void actualizarDatos(){
        this.menu.setNombre(this.vista4.getTxtNombre().getText());
        this.menu.setCorreo(this.vista4.getTxtCorreo().getText());
        this.menu.setTelefono(this.vista4.getTxtTelefono().getText());
        this.menu.setFechaNacimiento(this.vista4.getTxtNacimiento().getText());
        
        
        if(this.consulta.editar(menu)){
            JOptionPane.showMessageDialog(null,"Se actualizó tu perfil");
        }else{
            JOptionPane.showMessageDialog(null, "Error al actualizar pefil");
        }
        this.limpiar();
   }
   
   public void cambioCon(){
        vista7.setVisible(true);
        vista4.setVisible(false);
   }
   
   public void callCenter(){
        vista5.setVisible(true);
        vista.setVisible(false);
   }
   
   public void cambiarPw(){
       
       this.menu.setConActual(this.vista7.getTxtConActual().getText());
       this.menu.setCorreo(this.vista7.getTxtCorreo().getText());
       this.menu.setConNueva(this.vista7.getTxtConNueva().getText());
       this.menu.setConRepite(this.vista7.getTxtConRepite().getText());
       
       if(!this.menu.getConNueva().equals(this.menu.getConRepite())){
           JOptionPane.showMessageDialog(null, "La nueva contraseña no coincide");
           return;
       }
       if(this.consulta.cambiar(menu)){
           JOptionPane.showMessageDialog(null, "Contraseña cambiada");
       }else{
           JOptionPane.showMessageDialog(null, "Error al cambiar contraseña");
       }
       this.limpiar();
    
   }
   
   public void chat(){
        vista6.setVisible(true);
        this.vista.dispose();
    }
   
    public void generarReporte(){
        vista8.setVisible(true);
        this.vista.dispose();
    }

    
}
