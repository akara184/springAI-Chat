 Spring Chat Bot

A Telegram bot integrated with Spring AI that allows users to interact with a large language model directly through Telegram.

### Configuration
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

To do: 
- [ ] I will create audio audio transcript 
- [ ] Maybe text to speech
- [ ] Long term memory
- [ ] better interaction with users 
