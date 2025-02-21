/*package com.example.springboot.services.TwilioService;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


    @Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    
    //Método para enviar SMS
    public void sendSms(String messageContent){
        String phoneNumber = "13997973022"; // Número do destinatário
       
        
        //inicializa o Twilio com as credenciais
        Twilio.init(accountSid, authToken);
        
        
        //Envia o SMS
      Message message = Message.creator(
            new PhoneNumber("+55" + phoneNumber), // Número do destinatário
            new PhoneNumber(twilioPhoneNumber), // Número do remetente (seu número Twilio)
            messageContent
        ).create();
    }
}
   */

