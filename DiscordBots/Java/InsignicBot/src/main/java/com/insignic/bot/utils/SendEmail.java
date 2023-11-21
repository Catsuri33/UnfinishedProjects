package com.insignic.bot.utils;

import com.insignic.bot.database.DatabaseManager;
import net.dv8tion.jda.api.entities.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

public class SendEmail {

    public static String emailFrom = "verify.insignic@gmail.com";
    public static String passwordEmailFrom = "33590Loulou*";
    private static Random randomCode = new Random();
    private static Integer emailCode = randomCode.nextInt(999999 - 100000) + 100000;

    public static Message prepareMessage(Session session, String emailTo, User user){

        Message message = new MimeMessage(session);

        try {

            DatabaseManager.instance.setEmailCode(user.getIdLong(), emailCode.toString());

            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject("InsignicAccounts Email Verification");
            message.setContent(
                    emailVerificationCode,
                    "text/html");
            return message;

        } catch (MessagingException e) {

            e.printStackTrace();
            return null;

        }

    }

    private static String emailVerificationCode = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
            "<head>\n" +
            "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
            "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
            "<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
            "<!--[if !mso]><!-->\n" +
            "<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
            "<!--<![endif]-->\n" +
            "<title></title>\n" +
            "<!--[if !mso]><!-->\n" +
            "<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
            "<!--<![endif]-->\n" +
            "<style type=\"text/css\">\n" +
            "\t\tbody {\n" +
            "\t\t\tmargin: 0;\n" +
            "\t\t\tpadding: 0;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\ttable,\n" +
            "\t\ttd,\n" +
            "\t\ttr {\n" +
            "\t\t\tvertical-align: top;\n" +
            "\t\t\tborder-collapse: collapse;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t* {\n" +
            "\t\t\tline-height: inherit;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\ta[x-apple-data-detectors=true] {\n" +
            "\t\t\tcolor: inherit !important;\n" +
            "\t\t\ttext-decoration: none !important;\n" +
            "\t\t}\n" +
            "\t</style>\n" +
            "<style id=\"media-query\" type=\"text/css\">\n" +
            "\t\t@media (max-width: 520px) {\n" +
            "\n" +
            "\t\t\t.block-grid,\n" +
            "\t\t\t.col {\n" +
            "\t\t\t\tmin-width: 320px !important;\n" +
            "\t\t\t\tmax-width: 100% !important;\n" +
            "\t\t\t\tdisplay: block !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.block-grid {\n" +
            "\t\t\t\twidth: 100% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.col {\n" +
            "\t\t\t\twidth: 100% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.col>div {\n" +
            "\t\t\t\tmargin: 0 auto;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\timg.fullwidth,\n" +
            "\t\t\timg.fullwidthOnMobile {\n" +
            "\t\t\t\tmax-width: 100% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col {\n" +
            "\t\t\t\tmin-width: 0 !important;\n" +
            "\t\t\t\tdisplay: table-cell !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack.two-up .col {\n" +
            "\t\t\t\twidth: 50% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num2 {\n" +
            "\t\t\t\twidth: 16.6% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num3 {\n" +
            "\t\t\t\twidth: 25% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num4 {\n" +
            "\t\t\t\twidth: 33% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num5 {\n" +
            "\t\t\t\twidth: 41.6% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num6 {\n" +
            "\t\t\t\twidth: 50% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num7 {\n" +
            "\t\t\t\twidth: 58.3% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num8 {\n" +
            "\t\t\t\twidth: 66.6% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num9 {\n" +
            "\t\t\t\twidth: 75% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.no-stack .col.num10 {\n" +
            "\t\t\t\twidth: 83.3% !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.video-block {\n" +
            "\t\t\t\tmax-width: none !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.mobile_hide {\n" +
            "\t\t\t\tmin-height: 0px;\n" +
            "\t\t\t\tmax-height: 0px;\n" +
            "\t\t\t\tmax-width: 0px;\n" +
            "\t\t\t\tdisplay: none;\n" +
            "\t\t\t\toverflow: hidden;\n" +
            "\t\t\t\tfont-size: 0px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.desktop_hide {\n" +
            "\t\t\t\tdisplay: block !important;\n" +
            "\t\t\t\tmax-height: none !important;\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t</style>\n" +
            "</head>\n" +
            "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;\">\n" +
            "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
            "<table bgcolor=\"#FFFFFF\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
            "<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
            "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
            "<div style=\"background-color:transparent;overflow:hidden\">\n" +
            "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 500px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; width: 100%; background-color: transparent;\">\n" +
            "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
            "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:500px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"500\" style=\"background-color:transparent;width:500px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
            "<div class=\"col num12\" style=\"min-width: 320px; max-width: 500px; display: table-cell; vertical-align: top; width: 500px;\">\n" +
            "<div style=\"width:100% !important;\">\n" +
            "<!--[if (!mso)&(!IE)]><!-->\n" +
            "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
            "<!--<![endif]-->\n" +
            "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
            "<div style=\"color:#555555;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
            "<div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 14px;\">\n" +
            "<p style=\"text-align: center; line-height: 1.2; word-break: break-word; font-size: 30px; mso-line-height-alt: 36px; margin: 0;\"><span style=\"font-size: 30px; color: #3498db;\">InsignicAccounts</span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "<!--[if mso]></td></tr></table><![endif]-->\n" +
            "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
            "<div style=\"color:#555555;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
            "<div style=\"line-height: 1.2; font-size: 12px; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; color: #555555; mso-line-height-alt: 14px;\">\n" +
            "<p style=\"font-size: 18px; line-height: 1.2; word-break: break-word; text-align: center; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">Hello, here is your verification code for your Insignic account:</span></p>\n" +
            "<p style=\"font-size: 18px; line-height: 1.2; word-break: break-word; text-align: center; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 22px; margin: 0;\"><span style=\"font-size: 18px;\">" + emailCode.toString() + "</span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "<!--[if mso]></td></tr></table><![endif]-->\n" +
            "<!--[if (!mso)&(!IE)]><!-->\n" +
            "</div>\n" +
            "<!--<![endif]-->\n" +
            "</div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
            "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<!--[if (IE)]></div><![endif]-->\n" +
            "</body>\n" +
            "</html>";

}
