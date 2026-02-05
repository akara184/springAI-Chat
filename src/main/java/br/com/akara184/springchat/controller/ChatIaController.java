package br.com.akara184.springchat.controller;

import java.util.Map;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatIaController {

    private final GoogleGenAiChatModel chatModel;

    @Autowired
    public ChatIaController(GoogleGenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message") String message) {
        return Map.of("generation", chatModel.call(message));
        
    }

}
