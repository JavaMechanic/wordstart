package ru.egoncharovsky.wordstart.ui.pack;

import ru.egoncharovsky.wordstart.domain.card.CardPackOld;
import ru.egoncharovsky.wordstart.domain.card.LearningCardOld;
import ru.egoncharovsky.wordstart.domain.word.Language;
import ru.egoncharovsky.wordstart.domain.word.Phrase;
import ru.egoncharovsky.wordstart.ui.ModelView;

import java.util.ArrayList;

public class EditCardsControllerImpl implements EditCardsController {

    private ModelView<EditCardsPackModel> view;
    private EditCardsPackModel model;

    public EditCardsControllerImpl(ModelView<EditCardsPackModel> view) {
        this.view = view;

        model = new EditCardsPackModel(new CardPackOld("pack", new ArrayList<LearningCardOld>() {{
            add(new LearningCardOld(
                    new Phrase("phrase", Language.EN),
                    new Phrase("фраза", Language.RU)));
        }}));

        this.view.init(model);
    }
}
