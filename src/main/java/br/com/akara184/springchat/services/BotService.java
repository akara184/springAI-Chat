package br.com.akara184.springchat.services;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    
    private final TelegramBot bot;

  
    public BotService(TelegramBot bot) {
        this.bot = bot;
    }
   
    
}
