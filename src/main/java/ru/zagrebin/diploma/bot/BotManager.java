package ru.zagrebin.diploma.bot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Service;
import javax.security.auth.login.LoginException;


@Service
public class BotManager {
    private MessageHandler messageHandler;
    public BotManager(MessageHandler messageHandler){
        this.messageHandler = messageHandler;
    }
    public void start() throws LoginException, InterruptedException {
    JDA jda = new JDABuilder().createDefault("ODA5Nzc0MTM1NzY0NzEzNDky.YCZ-7g.AaJvAjb1-wLpNZzCHe5CiPwZPmc")
            .addEventListeners(messageHandler)
            .build().awaitReady();
        jda.awaitReady().getTextChannelsByName("text", true).get(0).sendMessage("HI");
}
}
