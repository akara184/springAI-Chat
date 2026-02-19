package br.com.akara184.springchat.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ReceiveMessageHandler {

    
    //Talvez aq eu trato as messagem que recebo de todas as maneiras

    public String ReceiveMessage(Update update) {        
        if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getText(); //Consigo pegar a mensagem do cha            
        }
        return "";
    }
        
        
}
            


