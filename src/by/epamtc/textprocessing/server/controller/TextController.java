package by.epamtc.textprocessing.server.controller;

import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Word;

import java.util.List;

public interface TextController {

    List<Sentence> getSentencesWithSameWords();

    List<Word> getWordsOfGivenLengthInInterrogativeSentence(int givenLength);

    List<Sentence> getSortedSentencesByCountOfWords();
}
