package br.com.akara184.springchat.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.BotSession;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.AfterBotRegistration;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import br.com.akara184.springchat.config.BotConfig;
import br.com.akara184.springchat.handler.SendMessageHandler;


@Service
public class BotService implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private BotConfig botConfig;
    private SendMessageHandler sendMessageHandler;
    
    public BotService(BotConfig botConfig, SendMessageHandler sendMessageHandler) {
        this.sendMessageHandler = sendMessageHandler;
        this.botConfig = botConfig;
        telegramClient = new OkHttpTelegramClient(getBotToken());
    }
   
    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        sendMessageHandler.sendMessage(update, telegramClient);
    }

    @AfterBotRegistration
    public void afterRegistration(BotSession botSession) {
        System.out.println("Registered bot running state is: " + botSession.isRunning());
        System.out.println("Bot Token:  " + getBotToken());
        System.out.println("Bot Name:  " +  botConfig.getUsername());
    }
        
}
