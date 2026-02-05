package br.com.akara184.springchat.services;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import br.com.akara184.springchat.config.BotConfig;

class BotService implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private BotConfig botConfig;
    
    public BotService(BotConfig botConfig) {
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
        
    }


        
}
