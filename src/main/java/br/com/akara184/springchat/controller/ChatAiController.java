package br.com.akara184.springchat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akara184.springchat.services.ChatAiService;

// Entao esse controler é basicamente onde vai passar a mensagem nao necessariamente precisa ser aq 
@RestController
@RequestMapping("/api/chat")
public class ChatAiController {

    private final ChatAiService chatService;

    public ChatAiController(ChatAiService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatAiResponse chat(@RequestBody String message) {
        return new ChatAiResponse(this.chatService.chat(message));
    }
    
    public record ChatAiResponse(String message) {
        
    }
    
}
