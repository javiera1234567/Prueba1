/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import vista.BandejaEntrada;
import vista.NuevoMensaje;

/**
 *
 * @author cristian
 */
public class BandejaEntradaController {

    private BandejaEntrada vBandejaEntrada;

    public BandejaEntradaController(BandejaEntrada vBandejaEntrada) {
        this.vBandejaEntrada = vBandejaEntrada;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ingresar")) {
            NuevoMensaje ven = new NuevoMensaje();
            ven.setVisible(true);
        }
    }

}

 

