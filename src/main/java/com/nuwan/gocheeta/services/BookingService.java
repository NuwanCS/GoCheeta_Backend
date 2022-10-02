package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.BookingDBUtils;
import com.nuwan.gocheeta.model.BaseEntity;
import com.nuwan.gocheeta.model.Booking;
import com.nuwan.gocheeta.model.User;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuwan
 */
public class BookingService extends AbstractService<Booking> {

    private static final AbstractDbUtil utils = new BookingDBUtils();
    private static final AbstractService service = new UserService();

    public BookingService() {
        super(utils);
    }

    @Override
    public boolean add(Booking t) throws SQLException {
        final boolean add = utils.add(t);

        if (add) {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.mailtrap.io");
            prop.put("mail.smtp.port", "2525");
//            prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

            final String username = "568b470ace6831";
            final String password = "bec9793385f643";

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress("smpg.nuwan@gmail.com"));
                User user = (User) service.getOne(t.getCustomer());
                
                message.setRecipients(
                        Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
                message.setSubject("Mail Subject");

                String msg = "Booking is successfull";

                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);

                message.setContent(multipart);

                Transport.send(message);

            } catch (AddressException ex) {
                Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return add;
    }

}
