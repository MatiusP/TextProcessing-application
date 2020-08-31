package by.epamtc.textprocessing.server.controller.handler;

import by.epamtc.textprocessing.server.controller.ControllerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class UserCommandHandler {
    private static Map<String, Supplier<Object>> commands = new HashMap<>();

    private UserCommandHandler() {
    }

    static {
        commands.put("sentencesWithSameWords",
                () -> ControllerFactory.getInstance().getTextController().getSentencesWithSameWords());
        commands.put("wordsOfGivenLengthInInterrogativeSentence",
                () -> ControllerFactory.getInstance().getTextController().getWordsOfGivenLengthInInterrogativeSentence(4));
        commands.put("sortedSentencesByCountOfWords",
                () -> ControllerFactory.getInstance().getTextController().getSortedSentencesByCountOfWords());
    }

    public static Object executeUserCommand(String userAction) {
        return commands.get(userAction).get();
    }
}
