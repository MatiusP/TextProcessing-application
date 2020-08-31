package by.epamtc.textprocessing.server.service;

import java.util.List;

import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.common.bean.Word;

public interface TextService {

	Text getSourceText();

	List<Sentence> getSentencesWithSameWords(Text text);

	List<Word> getWordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength);

	List<Sentence> getSortedSentencesByCountOfWords(Text text);
}
