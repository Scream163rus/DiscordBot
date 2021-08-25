package ru.zagrebin.diploma.bot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.zagrebin.diploma.service.MafiaService;
import ru.zagrebin.diploma.service.ServiceBunker;
import java.util.concurrent.TimeUnit;

@Component
public class MessageHandler extends ListenerAdapter {
    private ServiceBunker serviceBunker;
    private MafiaService mafiaService;

    public  MessageHandler(ServiceBunker serviceBunker, MafiaService mafiaService){
        this.serviceBunker = serviceBunker;
        this.mafiaService = mafiaService;
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        messageHandlerMafia(event);
        messageHandlerHelp(event);
        messageHandlerAnotherMessage(event);
        messageHandlerBunker(event);

    }
    public void messageHandlerMafia(@NotNull MessageReceivedEvent event){
        if (event.getMessage().getContentDisplay().split(" ")[0].equalsIgnoreCase("!Mafia")) {
            mafiaService
                    .InitMassRole(Integer.parseInt(event.getMessage().getContentDisplay().split(" ")[1]));
            event
                    .getJDA()
                    .getVoiceChannelsByName("Mafia", true)
                    .get(0)
                    .getMembers().forEach(member ->
            {
                    if(event.getMember() == member)    {
                        sendPrivateMessage(member, "Ваша роль: Ведущий");
                    }
                    else
                    sendPrivateMessage(member, "Ваша роль: " +  mafiaService.randomRoleMafia());});

        }
    }
    public void messageHandlerBunker(@NotNull MessageReceivedEvent event){
    if (event.getMessage().getContentDisplay().split(" ")[0].equalsIgnoreCase("!Bunker") && event.getMessage().getContentDisplay().split(" ").length == 1) {
        event
                .getJDA()
                .getVoiceChannelsByName("Bunker", true)
                .get(0)
                .getMembers().forEach(member -> sendPrivateMessage(member,  serviceBunker.initPlayerCard()));
        messageOnChat(event, serviceBunker.initBunkerCard());

    }
    if (event.getMessage().getContentDisplay().split(" ")[0].equalsIgnoreCase("!Bunker") && event.getMessage().getContentDisplay().split(" ").length == 2){
        switch (event.getMessage().getContentDisplay().split(" ")[1]){
            case "Здоровье" :
                sendPrivateMessage(event.getMember(), "Новое здоровье: " + serviceBunker.getRandomHealth());
            case "Багаж" :
                sendPrivateMessage(event.getMember(), "Новый багаж" + serviceBunker.getRandomBaggage());
            case "Фобия" :
                sendPrivateMessage(event.getMember(), "Новая фобия" + serviceBunker.getRandomPhobia());
            case "Хобби" :
                sendPrivateMessage(event.getMember(), "Новое хобби" + serviceBunker.getRandomHobby());
            case "БИО" :
                sendPrivateMessage(event.getMember(), "Новая биологическая характеристика" + serviceBunker.getRandomBiologicalCharacteristics());
            case "Проффесия" :
                sendPrivateMessage(event.getMember(), "Новая профессия" +  serviceBunker.getRandomProfessions());
            case "Характер" :
                sendPrivateMessage(event.getMember(), "Новый характер" + serviceBunker.getRandomHumanQuality());

        }
    } }
    public void messageHandlerHelp(@NotNull MessageReceivedEvent event) {
        if (!event.getMember().getUser().isBot()) {
            if (event.getMessage().getContentDisplay().split(" ")[0].equalsIgnoreCase("!Help")) {
                if (event.getMessage().getContentDisplay().split(" ").length == 1) {
                    messageOnChat(event,"'!Help bunker' информация об игре бункер\n" +
                                    "'!Help mafia' информация об игре мафия \n" +
                                    "'!Mute/Unmute 'имя игрока'' отключение/включение микрофона пользователю \n" +
                                    "'!Ban 'имя пользователя' 'срок бана(в днях)' 'причина бана'' блокировка игрока на сервере\n" +
                                    "'!Kick 'имя пользователя' 'причина кика'' удаление пользователя с сервера\n" +
                                    "'!MuteAll/UnMuteAll' выключение/включение микрофонов всем пользователей в вашем голосовом чате\n");

                } else switch (event.getMessage().getContentDisplay().split(" ")[1]) {
                    case "mafia":
                        messageOnChat(event,"Данный бот предоставляет возможность раздачи ролей в игре 'Мафия' " +
                                        "на кол-во игроков от 8 до 12, для начала игры напишите '!Mafia 'кол-во игроков''");
                        break;
                    case "bunker":
                        messageOnChat(event,"Функционал данного бота позволяет генерировать каротчки персонажей, а так же самого" +
                                        " бункера в настольной игре 'Бункер' поддерживает дальнейшую" +
                                        " раздачу их игрокам находящимся в комнате игры 'Бункер', " +
                                        "а так же дальнейшую поддержку игры при помощи команд(нужно для использования кароточек действия):\n" +
                                        "'!Bunker здоровье' замена здоровья\n" +
                                        "'!Bunker Багаж' замена багажа \n" +
                                        "'!Bunker Фобия' замена фобии\n" +
                                        "'!Bunker Хобби' замена хобби\n" +
                                        "'!Bunker БИО' замена биологической характеристики\n" +
                                        "'!Bunker Проффесия' замена профессии\n" +
                                        "'!Bunker Характер' замена черты характера");
                }
            }
        }
    }
    public void messageHandlerAnotherMessage(@NotNull MessageReceivedEvent event) {
        switch (event.getMessage().getContentDisplay().split(" ")[0]) {
            case "!Mute":
                try {
                    mute(event, true);
                }
                catch (ArrayIndexOutOfBoundsException e) {

                    messageOnChat(event,"Укажите имя пользователя !Mute 'имя'");
                }
                break;
            case "!UnMute":
                try {
                    mute(event, false);
                } catch (ArrayIndexOutOfBoundsException e) {
                    messageOnChat(event,"Укажите имя пользователя !UnMute 'имя'");
                }
                break;
            case "!MuteAll":
                muteAll(event,true);
                break;
            case "!UnMuteAll":
                muteAll(event,false);
                break;
                case "!Ban":
                try {
                    event
                            .getJDA()
                            .getCategories()
                            .forEach(category -> category.getVoiceChannels().forEach(voiceChannel -> voiceChannel.getMembers().forEach(member ->
                    {
                        if (member.getUser().getName().equalsIgnoreCase(event.getMessage().getContentDisplay().split(" ")[1])) {
                            member
                                    .ban(Integer.parseInt(event.getMessage().getContentDisplay().split(" ")[2]),
                                            event.getMessage().getContentDisplay().split(" ")[3]).submit();
                        }
                    })));
                } catch (ArrayIndexOutOfBoundsException e) {
                    messageOnChat(event,"!Ban 'имя пользователя' 'срок бана(в днях)' 'причина бана' ");

                }
                    break;
            case "!Kick":
                try {
                    event
                            .getJDA()
                            .getCategories()
                            .forEach(category -> category.getVoiceChannels().forEach(voiceChannel -> voiceChannel.getMembers().forEach(member ->
                    {
                        if (member.getUser().getName().equalsIgnoreCase(event.getMessage().getContentDisplay().split(" ")[1])) {
                            member.kick(event.getMessage().getContentDisplay().split(" ")[2]).submit();
                        }
                    })));
                } catch (ArrayIndexOutOfBoundsException e) {
                    messageOnChat(event,"!Kick 'имя пользователя' 'причина кика' ");
                }
                break;

        }
    }
    public void mute(@NotNull MessageReceivedEvent event, boolean mute){
            event
                    .getJDA()
                    .getCategories().forEach(category ->
                    category.getVoiceChannels().forEach(voiceChannel ->
                            voiceChannel.getMembers().forEach(member ->
                            {
                                if (member.getUser().getName().equalsIgnoreCase(event.getMessage().getContentDisplay().split(" ")[1])) {
                                    member
                                            .mute(mute)
                                            .submit();
                                }
                            })));

    }
    public void muteAll(@NotNull MessageReceivedEvent event, boolean mute){
        event
                .getJDA()
                .getCategories()
                .forEach(category -> category.getVoiceChannels().forEach(voiceChannel -> voiceChannel.getMembers().forEach(member -> member.mute(mute).submit())));

    }
    public void messageOnChat(@NotNull MessageReceivedEvent event, String message){
        event
                .getTextChannel()
                .sendMessage(message)
                .timeout(5, TimeUnit.SECONDS).submit();
    }
    public void sendPrivateMessage(Member member, String message) {

        member.getUser().openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(message).queue();
        });

    }
}
