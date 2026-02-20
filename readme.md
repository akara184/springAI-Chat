 Spring Chat Bot

A Telegram bot integrated with Spring AI that allows users to interact with a large language model directly through Telegram.

## Stack

- Java 21
- Spring Boot 3
- Spring AI
- Google Gemini (gemini-flash)
- Telegram Bots API

## How it works

The bot receives messages from users on Telegram, forwards them to Gemini via Spring AI, and returns the response back to the user in the same chat.

## Configuration

Add the following to your `application.properties`:

```properties
spring.ai.google.genai.api-key=YOUR_GENAI_API_KEY
spring.ai.google.genai.chat.options.model=gemini-flash-latest
spring.ai.google.genai.chat.options.temperature=0.5
telegram.bot.token=YOUR_TELEGRAM_BOT_TOKEN
telegram.bot.username=YOUR_BOT_USERNAME
```

## Running

```bash
mvn spring-boot:run
```
