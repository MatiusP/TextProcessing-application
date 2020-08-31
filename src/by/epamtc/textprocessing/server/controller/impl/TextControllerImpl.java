package by.epamtc.textprocessing.server.controller.impl;

import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.common.bean.Word;
import by.epamtc.textprocessing.server.controller.TextController;
import by.epamtc.textprocessing.server.service.ServiceFactory;
import by.epamtc.textprocessing.server.service.TextService;

import java.util.List;

public class TextControllerImpl implements TextController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private TextService textService = serviceFactory.getTextService();
    private final Text sourceText = textService.getSourceText();

    @Override
    public List<Sentence> getSentencesWithSameWords() {
        return textService.getSentencesWithSameWords(sourceText);
    }

    @Override
    public List<Word> getWordsOfGivenLengthInInterrogativeSentence(int givenLength) {
        return textService.getWordsOfGivenLengthInInterrogativeSentence(sourceText, givenLength);
    }

    @Override
    public List<Sentence> getSortedSentencesByCountOfWords() {
        return textService.getSortedSentencesByCountOfWords(sourceText);
    }
}
