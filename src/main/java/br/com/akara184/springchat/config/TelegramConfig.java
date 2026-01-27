package br.com.akara184.springchat.config;

import com.pengrad.telegrambot.TelegramBot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "telegram.bt")
public class TelegramConfig {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Bean
    public TelegramBot telegramBot() {
        return new TelegramBot(token);
        bot.setUpdatesListener(updates -> {
                // ... process updates
                // return id of last processed update or confirm them all
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
                // Create Exception Handler
            }, e -> {
                if (e.response() != null) {
                    // got bad response from telegram
                    e.response().errorCode();
                    e.response().description();
                } else {
                    // probably network error
                    e.printStackTrace();
                }
            });


    }

}
