package br.com.akara184.springchat.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import br.com.akara184.springchat.config.BotConfig;


@Service
public class BotService extends TelegramLongPollingBot {  

    private BotConfig bot;


    public BotService(BotConfig bot){
        super(bot.getToken());
        this.bot = bot;
    }
 

    @Override
    public String getBotUsername() {
        return bot.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();

        System.out.println(user.getFirstName() + " wrote " + msg.getText());
    }
  

        
}
