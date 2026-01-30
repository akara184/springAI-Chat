package br.com.akara184.springchat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import br.com.akara184.springchat.config.BotConfig;


@SpringBootApplication
public class SpringchatApplication  {
   
	public static void main(String[] args) throws TelegramApiException {      
        SpringApplication.run(SpringchatApplication.class, args);
 

    
 

}


class BotRunner implements CommandLineRunner {
    
    private final BotConfig botConfig;
    
    public BotRunner(BotConfig botConfig) {
        this.botConfig = botConfig;
    }
    
    @Override
    public void run(String... args) {
        System.out.println("Nome: " + botConfig.getName());
        System.out.println("Token: " + botConfig.getToken());
    }
}}
