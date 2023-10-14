package net.Energyblade7.inscribedbyancients.util.translation;


public class TranslationNexus {
    public static final TranslationKey[] alphaDictionary = new TranslationKey[]{
       new TranslationKey("p/e%", "key.translation.iron"),
       new TranslationKey("we&", "key.translation.mines"),
       new TranslationKey("we*", "key.translation.mine"),
       new TranslationKey("l#", "key.translation.fish"),
       new TranslationKey("/v", "key.translation.for"),
       new TranslationKey("up@", "key.translation.sale"),
       new TranslationKey("up*", "key.translation.trading"),
       new TranslationKey("f/p*", "key.translation.forge"),
       new TranslationKey("p^", "key.translation.order"),
       new TranslationKey("l^", "key.translation.water"),
       new TranslationKey("e^", "key.translation.earth"),
       new TranslationKey("j/l*", "key.translation.swim"),
       new TranslationKey("sec", "key.translation.mountain"),
       new TranslationKey("/", "key.translation.of"),
       new TranslationKey("p#", "key.translation.people"),
       new TranslationKey(")v", "key.translation.to"),
       new TranslationKey("g/e%", "key.translation.gold"),
       new TranslationKey("e$", "key.translation.stone"),
       new TranslationKey("v^", "key.translation.go")
};

    public static final InscriptionPhrase[] alphaAnthology = new InscriptionPhrase[]{
            new InscriptionPhrase(new String[]{",p/e%","<we&"}, new int[][]{
              {7,0,8},
              {10,12,1}
            }),
            new InscriptionPhrase(new String[]{",l#","/v",",up@"}, new int[][]{
              {3,9,11},
              {13,15,4},
              {5,2,11}
            }),
            new InscriptionPhrase(new String[]{",up*","<l#","/v","<p/e%"}, new int[][]{
              {10,6,11},
              {14,3,11},
              {4,18,8},
              {17,16,0}
            })
   };

}
