/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package study.tiago.sistemaestoque.utilities;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ribol
 */
public class Utilities {
    public void ClearScreen(JPanel container){
        Component components[] = container.getComponents();
        
        for(Component component : components){
            if (component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
