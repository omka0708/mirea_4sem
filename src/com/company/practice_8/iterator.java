package com.company.practice_8;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class iterator {

    public static class Word implements Iterable<Word.WordPart>{
        private final Root root;
        private Prefix prefix;
        private Suffix suffix;
        private Ending ending;
        private final int partCount;

        public Word(Root root, Prefix prefix, Suffix suffix, Ending ending) {
            this.root = root;
            this.prefix = prefix;
            this.suffix = suffix;
            this.ending = ending;
            this.partCount = 4;
        }
        public Word(Root root, Prefix prefix, Suffix suffix) {
            this.root = root;
            this.prefix = prefix;
            this.suffix = suffix;
            this.partCount = 3;

        }
        public Word(Root root, Prefix prefix) {
            this.root = root;
            this.prefix = prefix;
            this.partCount = 2;
        }
        public Word(Root root) {
            this.root = root;
            this.partCount = 1;
        }
        public Root getRoot() {
            return root;
        }
        public Prefix getPrefix() {
            return prefix;
        }
        public Suffix getSuffix() {
            return suffix;
        }
        public Ending getEnding() {
            return ending;
        }
        public int getPartCount() {
            return partCount;
        }
        public boolean hasRoot() {
            return this.root != null;
        }
        public boolean hasPrefix() {
            return this.prefix != null;
        }
        public boolean hasSuffix() {
            return this.suffix != null;
        }
        public boolean hasEnding() {
            return this.ending != null;
        }

        @Override
        public Iterator<WordPart> iterator() {
            return new WordIterator(this);
        }

        interface WordPart {
            String getWordPart();
        }
        static class Root implements WordPart {
            private final String part;

            @Override
            public String toString() {
                return "Корень";
            }

            public Root(String part) {
                this.part = part;
            }
            @Override
            public String getWordPart() {
                return part;
            }
        }
        static class Prefix implements WordPart {
            private final String part;

            @Override
            public String toString() {
                return "Приставка";
            }
            public Prefix(String part) {
                this.part = part;
            }
            @Override
            public String getWordPart() {
                return part;
            }
        }
        static class Suffix implements WordPart {
            private final String part;

            @Override
            public String toString() {
                return "Суффикс";
            }
            public Suffix(String part) {
                this.part = part;
            }
            @Override
            public String getWordPart() {
                return part;
            }
        }
        static class Ending implements WordPart {
            private final String part;

            @Override
            public String toString() {
                return "Окончание";
            }
            public Ending(String part) {
                this.part = part;
            }
            @Override
            public String getWordPart() {
                return part;
            }
        }
    }

    static class WordIterator implements Iterator<Word.WordPart>{
        private final Word word;
        private int wordPartsCount;

        public WordIterator(Word word) {
            this.word = word;
            this.wordPartsCount = word.getPartCount();
        }
        @Override
        public boolean hasNext() {
            if (wordPartsCount == 4) {
                return word.hasPrefix() || word.hasRoot() || word.hasSuffix() || word.hasEnding();
            } else if (wordPartsCount == 3) {
                return word.hasPrefix() || word.hasRoot() || word.hasSuffix();
            } else if (wordPartsCount == 2) {
                return word.hasPrefix() || word.hasRoot();
            } else if (wordPartsCount == 1) {
                return word.hasRoot();
            }
            return false;
        }

        @Override
        public Word.WordPart next() {
            if (wordPartsCount <= 0) {
                throw new NoSuchElementException("No more elements in this word!");
            }
            try {
                if (wordPartsCount == 4) {
                    return word.getEnding();
                }
                if (wordPartsCount == 3) {
                    return word.getSuffix();
                }
                if (wordPartsCount == 2) {
                    return word.getPrefix();
                }
                return word.getRoot();
            } finally {
                wordPartsCount--;
            }
        }
    }
    static void print(Word word){
        Iterator<Word.WordPart> wordIterator = word.iterator();
        if (wordIterator.hasNext()) {
            do {
                Word.WordPart part = wordIterator.next();
                System.out.println(part + ": " + part.getWordPart());
            } while (wordIterator.hasNext());
        }
        System.out.println("-------------------------------");
    }
    public static void main(String[] args){
        print(new Word(new Word.Root("беж"), new Word.Prefix("пере"), new Word.Suffix("к"), new Word.Ending("a")));
        print(new Word(new Word.Root("беж"), new Word.Prefix("пере"), new Word.Suffix("чик")));
        print(new Word(new Word.Root("ключ"), new Word.Prefix("ик")));
        print(new Word(new Word.Root("волк")));
    }
}
