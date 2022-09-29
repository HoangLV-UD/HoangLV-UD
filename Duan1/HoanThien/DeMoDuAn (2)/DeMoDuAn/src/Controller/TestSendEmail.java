/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 *
 * @author ADMIN
 */
public class TestSendEmail {

    public static void main(String[] args) {
        String to = "chungntph13390@fpt.edu.vn";
        String from = "nguyenthaichung0809@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("Day la dong Subject!");
            message.setText("Day la message thuc su");
            Transport.send(message);
            System.out.println("Gui message thanh cong....");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
