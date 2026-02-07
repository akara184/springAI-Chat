package br.com.akara184.springchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@SpringBootApplication
public class SpringchatApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(SpringchatApplication.class, args);

    }
}



