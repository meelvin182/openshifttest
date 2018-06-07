package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;


@Component
public class DegrodikiBot extends TelegramLongPollingBot {

@Autowired
TextUpdater textUpdater;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(textUpdater.toString());
       System.out.println(textUpdater);
        String message = update.getMessage().getText();

/*        try {
            textUpdater.writeSendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String getBotUsername() {
        return "degrodikiBot";
    }

    @Override
    public String getBotToken() {
        return "596552081:AAErSYYPJOHFOu913SshAXYdVVboD2BE8TY";
    }
}
