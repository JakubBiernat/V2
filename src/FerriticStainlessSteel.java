public class FerriticStainlessSteel extends Steel{

    static int SSAmount;


    FerriticStainlessSteel(String a, String b,String c,String d) {
        super( a,b,c,d);

        SSAmount++;
       super.description = "Ferritic stainless steel";
    }

    @Override
    public String toString(){return description + " :  "+geteuName();}

    }

