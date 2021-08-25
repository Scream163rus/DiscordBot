package ru.zagrebin.diploma.config;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.zagrebin.diploma.bot.BotManager;
import javax.security.auth.login.LoginException;

@Component
public class ApplicationStartupConfig {
    private BotManager botManager;
    ApplicationStartupConfig(BotManager botManager){
        this.botManager = botManager;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws LoginException, InterruptedException {
        botManager.start();
    }
}
