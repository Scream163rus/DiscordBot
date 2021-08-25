package ru.zagrebin.diploma.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.LoginException;

public class BotStart {
    @Autowired
    private static MessageHandler messageHandler;

    public static void botStart() throws InterruptedException, LoginException {
        JDA jda = new JDABuilder()
                .addEventListeners(messageHandler)
                .build();
        jda.awaitReady().getCategories().get(0).getTextChannels().get(0).sendMessage("Hello world");
    }
}
