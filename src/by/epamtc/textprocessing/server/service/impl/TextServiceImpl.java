package by.epamtc.textprocessing.server.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.epamtc.textprocessing.common.bean.PunctuationMark;
import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.common.bean.Word;
import by.epamtc.textprocessing.server.dao.DAOFactory;
import by.epamtc.textprocessing.server.service.TextService;
import by.epamtc.textprocessing.server.service.util.TextUtils;

public class TextServiceImpl implements TextService {
	private TextUtils textUtils = TextUtils.getInstance();

	@Override
	public Text getSourceText() {
		DAOFactory daoFactory = DAOFactory.getInstance();
		Text sourceText = daoFactory.getTextDAO().getText();
		return sourceText;
	}

	@Override
	public List<Sentence> getSentencesWithSameWords(Text text) {
		List<Sentence> resultList = new ArrayList<>();
		Set<Word> sentenceWordsSet = new HashSet<>();
		List<Word> sentenceWords;

		for (Sentence sentence : textUtils.getSentencesList(text)) {
			sentenceWords = sentence.getWords();

			sentenceWordsSet.addAll(sentenceWords);
			if (sentenceWords.size() != sentenceWordsSet.size()) {
				resultList.add(sentence);
			}
		}
		return resultList;
	}

	@Override
	public List<Word> getWordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength) {
		PunctuationMark questionSymbol = new PunctuationMark("?");
		List<Sentence> interrogativeSentencesList = new ArrayList<>();
		Set<Word> wordsOfGivenLength = new HashSet<>();

		for (Sentence sentence : textUtils.getSentencesList(text)) {
			if (sentence.getPunctuationMarks().contains(questionSymbol)) {
				interrogativeSentencesList.add(sentence);
			}
		}

		for (Sentence interrogativeSentence : interrogativeSentencesList) {
			for (Word word : interrogativeSentence.getWords()) {
				if (word.getData().length() == givenLength) {
					wordsOfGivenLength.add(word);
				}
			}
		}
		return new ArrayList<>(wordsOfGivenLength);
	}

	@Override
	public List<Sentence> getSortedSentencesByCountOfWords(Text text) {
		List<Sentence> sortedSentencesList = textUtils.getSentencesList(text);
		sortedSentencesList.sort((o1, o2) -> o1.getWords().size() - o2.getWords().size());
		return sortedSentencesList;
	}
}
