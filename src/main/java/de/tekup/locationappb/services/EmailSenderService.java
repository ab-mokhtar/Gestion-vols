package de.tekup.locationappb.services;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@AllArgsConstructor
@Service
public class EmailSenderService {
    private JavaMailSender javaMailSender;
    public void sendmail(String destinataire)throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("mokhtarabbes9@gmail.com");
        mimeMessageHelper.setTo(destinataire);
        mimeMessageHelper.setText("Nous avons accusons réception de la demande de réservation que vous avez effectuée \n nous vous contacterons dans les plus brefs délais");
        mimeMessageHelper.setSubject("Demande location voiture");
        javaMailSender.send(mimeMessage);
        System.out.println("email envoyée");

    }
}
