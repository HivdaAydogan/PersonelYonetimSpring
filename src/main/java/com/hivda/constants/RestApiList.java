package com.hivda.constants;

public class RestApiList {
    /**
     * Projeler genellikle belli sunucular ve belli portlar üzerinde çalışırlar.
     * Büyük projelerde ekiler ayrışır ve farklı ekipler farklı end pointler ile
     * istek atarlar. Bu ayrışmayı daha kontrollü yapmak için sabitleri yönetmek
     * iyi bir fikirdir.
     */
    public static final String API = "/api";

    public static final String TEST = "/test";

    public static final String PROD = "/prod";

    public static final String VERSION = "/v1";


    public static final String PERSONEL = API+VERSION+"/personel";

    public static final String DEPARTMAN = API+VERSION+"/departman";

    public static final String PERSONELDEPARTMAN = API+VERSION+"/personeldepartman";


    public static final String SAVE = "/save";

    public static final String UPDATE = "/update";

    public static final String DELETE = "/delete";

    public static final String FINDALL = "/findall";

}
