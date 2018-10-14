package ru.egoncharovsky.wordstart.domain.service;

import ru.egoncharovsky.wordstart.domain.Language;
import ru.egoncharovsky.wordstart.domain.LearningCard;
import ru.egoncharovsky.wordstart.domain.Word;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LearningCardsDictionaryService {

    private static LearningCardsDictionaryService instance;

    private LearningCardsDictionaryService() {

    }

    public static LearningCardsDictionaryService getInstace() {
        if (instance == null) {
            instance = new LearningCardsDictionaryService();
        }
        return instance;
    }

    public List<LearningCard> getAll() {
        Word word1 = new Word("слово", Language.RU);
        Word word2 = new Word("word", Language.EN);

        final LearningCard card = new LearningCard(word1, word2);

        List<LearningCard> cards = new LinkedList<LearningCard>() {{
            add(card);
            add(card.reverse());
        }};

        return cards;
    }

}