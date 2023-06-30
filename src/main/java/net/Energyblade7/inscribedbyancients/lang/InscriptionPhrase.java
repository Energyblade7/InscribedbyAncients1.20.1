package net.Energyblade7.inscribedbyancients.lang;

public class InscriptionPhrase {

    private int index;
    private String displayPhrase;
    private String solutionKey;
    private byte phraseComplexity;

    public InscriptionPhrase(int index, String displayPhrase, String solutionKey, byte phraseComplexity){
        this.index = index;
        this.displayPhrase = displayPhrase;
        this.solutionKey = solutionKey;
        this.phraseComplexity = phraseComplexity;

    }
}
