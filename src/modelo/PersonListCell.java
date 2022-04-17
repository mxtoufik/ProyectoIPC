/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javafx.scene.control.*;

/**
 *
 * @author tange
 */
public class PersonListCell extends ListCell<Usuario>{
    
    @Override
    protected void updateItem(Usuario item, boolean empty){
        super.updateItem(item, empty);
        if(item==null || empty) setText(null);
        else setText(item.getNombre() + " ," + item.getApellidos());
    }
    
}
