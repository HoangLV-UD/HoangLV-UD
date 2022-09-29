/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class ClockThread extends Thread{
    private JLabel label;

    public ClockThread(JLabel label) {
       this.label = label;
    }
   
    @Override
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a");
        while(true){
            Date now = new Date();
            String st = sdf.format(now);
            label.setText(st);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
