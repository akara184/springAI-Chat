package br.com.akara184.springchat.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class ReceiveMessageHandler {

    //Talvez aq eu trato as messagem que recebo de todas as maneiras
    
    public void ReceiveMessageHandler(Update update, TelegramClient telegramClient) {        
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            SendMessage message = SendMessage // Create a message object
                .builder()
                .chatId(chat_id)
                .text("Menssagem vem aq")
                .build();
            try {
                telegramClient.execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
        
        
}
            


