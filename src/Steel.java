import java.util.Objects;

public  class Steel implements Comparable {

    Steel(String euName, String plName,String dinName,String aName){
        TotalSteelAmount++;
        this.euName = euName;
        this.plName = plName;
        this.dinName = dinName;
        this.aName = aName;

    }
    static int TotalSteelAmount;

    protected String description;

    protected String euName;
    protected String plName;
    protected String dinName;
    protected String aName;



    public String geteuName() {
        return euName;
    }
    public String getplName() {
        return plName;
    }
    public String getdinName() {return dinName;}
    public String getaName() {return aName;}
    public String getDescription() {return description;}


    // Comparison based on EU name!
    @Override
    public int compareTo(Object o) {
        Steel w = (Steel)o;
        return w.geteuName().compareTo(this.geteuName()) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Steel steel = (Steel) o;
        return Objects.equals(euName, steel.euName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(euName);
    }
}
