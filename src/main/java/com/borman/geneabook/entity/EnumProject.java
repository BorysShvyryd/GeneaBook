package com.borman.geneabook.entity;

//enum Gender { MALE, FEMALE, UNKNOWN }
enum Sex {

    MALE('M'),
    FEMALE('F');

    private final Character sexCode;

    Sex(Character sexCode) {
        this.sexCode = sexCode;
    }

    public Character getCode() {
        return this.sexCode;
    }
}

//public enum RelationShip {
//
//}

//enum PARENTS {FATHER, MATHER, STEPFATHER, STEPMOTHER}

//enum SISTERS_BROTHERS {SISTER, BROTHER}

//enum MARRIED_COUPLE {HUSBAND, WIFE}

//enum CHILDREN {SON, DAUGHTER}

//enum FAMILY_TIES {
//    ASCENDING_LINE(1),
//    MARRIED_COUPLE(2),
//    DOWNWARD_LINE(3);
//
//    private final int family_ties_code;
//
//    FAMILY_TIES(int family_ties_code) {
//        this.family_ties_code = family_ties_code;
//    }
//
//    public int getFamilyTiesCode() {
//        return family_ties_code;
//    }
//}

//enum LANG {
//
//    ENGLISH("EN"), POLISH("PL"), RUSSIAN("RU"), UKRAINIAN("UK"), CZECH("CZ");
//
//    private final String lang;
//
//    LANG(String lang) { this.lang = lang; }
//
//    public String getLang() { return lang; }
//
//}

//enum UserRoleEnum {
//
//    ADMIN,
//    USER,
//    ANONYMOUS;
//
//    UserRoleEnum() {
//    }
//
//}

// ANCESTORS предки,
// family ties родинні зв'язки́,
// kinship спорідненість (в шлюбі)


//    Висхідна́ лінія    Ascending line
//
//    Низхідна́ лінія Downward line


//       Генеалогія — історія роду, родини, а також допоміжна дисципліна, що вивчає історію окремих родів
//        Рід — генетично пов'язані одне з одним покоління, які ведуть походження від одного предка
//        Спорідненість (кровна спорідненість) — відношення між людьми, які засновані на наявності спільних предків
//        Пряма спорідненість — відношення між предками та нащадками
//        Висхідна́ лінія — низка поколінь від особи до предків.
//        Низхідна́ лінія — низка поколінь від особи до нащадків
//        Бічна спорідненість (непряма спорідненість) — відношення між нащадками спільних предків
//        Свояцтво — спорідненість за шлюбом, між родичами чоловіка і дружини.
//        Чоловіча лінія — низка поколінь предків або нащадків виключно чоловічої статі (батько, дід по батькові, прадід — батько діда по батькові тощо)
//        Жіноча лінія — низка поколінь предків або нащадків виключно жіночої статі (мати, баба по матері, прабаба — мати баби по матері тощо)
//        Ступінь спорідненості — одиниця близькості спорідненості, визначається як народження однієї особи від другої, а також стосунки подружжів. Так, до родичів першого ступеня прямої спорідненості належать батько, мати, син, дочка, подружжя. До родичів другого — діди, баби, внуки, внучки. У бічній спорідненості першого ступеня не виділяють, до другого відносять рідних та неповнорідних братів та сестер, до третього — дядьків, тіток, племінників та племінниць, до четвертого — двоюрідних братів та сестер, двоюрідних дідів, баб, внуків та внучок