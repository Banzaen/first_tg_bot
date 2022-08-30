import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Banzaen_Music_Bot";
    }


    @Override
    public String getBotToken() {
        return "5687008952:AAE-6Anllr5N2KFESkWL6VMrFtc0MMinuE8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Весна"));
        keyboardRow.add(new KeyboardButton("Лето"));

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Осень"));
        keyboardRow1.add(new KeyboardButton("Зима"));

        ArrayList<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()){
            case "Весна":
                inputFile.setMedia("AgACAgIAAxkBAANDYwiNmqdZRbncAr9Tfm9FWN-vOU4AAnDAMRvQ70lIngoWiogiQFABAAMCAANzAAMpBA");
                break;
            case "Лето":
                inputFile.setMedia("AgACAgIAAxkBAANHYwiN9kbNZ8iIKNXF6P0sEt_UYaIAAnLAMRvQ70lIvCzKL4UrceMBAAMCAANzAAMpBA");
                break;
            case "Осень":
                inputFile.setMedia("AgACAgIAAxkBAANJYwiOCa_mlil5npy4_1caPVaFaXIAAnPAMRvQ70lIFX4PsvOGeuwBAAMCAANzAAMpBA");
                break;
            case "Зима":
                inputFile.setMedia("AgACAgIAAxkBAANFYwiN4TlELFtLXOBI1FpYMD3qwggAAnHAMRvQ70lISvLSr4FMs6UBAAMCAANzAAMpBA");
                break;
        }
        sendPhoto.setPhoto(inputFile);
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
