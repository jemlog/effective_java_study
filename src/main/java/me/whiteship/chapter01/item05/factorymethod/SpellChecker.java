package me.whiteship.chapter01.item05.factorymethod;

import me.whiteship.chapter01.item05.DefaultDictionary;
import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {

    private Dictionary dictionary;

    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
    }

    public SpellChecker(Supplier<? extends DefaultDictionary> dictionaryFactory)
    {
        this.dictionary = dictionaryFactory.get();
    }
    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(() -> new DefaultDictionary());

    }

}
