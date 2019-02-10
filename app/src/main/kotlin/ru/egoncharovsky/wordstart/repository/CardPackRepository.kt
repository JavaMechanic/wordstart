package ru.egoncharovsky.wordstart.repository

import ru.egoncharovsky.wordstart.domain.card.CardPack
import java.util.concurrent.atomic.AtomicLong

object CardPackRepository : MockRepository<CardPack, Long>() {

    private val cardRepo = LearningCardRepository

    init {
        insert(CardPack(1L, "pack1", setOf(cardRepo.get(1L), cardRepo.get(3L))))
    }

    private val sequence = AtomicLong(2L)
    fun create(entity: CardPack): CardPack {
        entity.id = sequence.getAndAdd(1)
        return insert(entity)
    }
}