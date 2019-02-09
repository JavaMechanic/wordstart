package ru.egoncharovsky.wordstart.domain.card;

import ru.egoncharovsky.wordstart.domain.SimpleRepository;
import ru.egoncharovsky.wordstart.domain.word.Translation;

import java.util.List;

public interface LearningCardRepository extends SimpleRepository<LearningCardOld> {

    List<LearningCardOld> findCardsFor(Translation translation);
}
