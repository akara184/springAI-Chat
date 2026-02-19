package br.com.akara184.springchat.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import br.com.akara184.springchat.services.ChatAiService;

@Component
public class SendMessageHandler {

     private final ReceiveMessageHandler receiveMessageHandler;
     private final ChatAiService chatAiService; 
    
    
    public SendMessageHandler(ReceiveMessageHandler receiveMessageHandler, ChatAiService chatAiService) {
        this.receiveMessageHandler = receiveMessageHandler;
        this.chatAiService = chatAiService;
    }
    
    public void sendMessage(Update update, TelegramClient telegramClient) {        
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            String userBotMessage = receiveMessageHandler.ReceiveMessage(update);
            String aiResponse = chatAiService.chat(userBotMessage); // manda pro Spring AI
            
            SendMessage message = SendMessage // Create a message object
                .builder()
                .chatId(chat_id)
                .text(aiResponse)
                .build();
            try {
                telegramClient.execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
        
        
}
            


