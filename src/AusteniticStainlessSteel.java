public class AusteniticStainlessSteel extends Steel{
    static int SASAmount;


    AusteniticStainlessSteel(String a, String b, String c, String d) {
        super( a,b,c,d);
        SASAmount++;
        super.description = "Austenitic Stainless Steel";
    }

    @Override
    public String toString(){return description + " :  "+geteuName();}


}
