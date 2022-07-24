public class Spartans extends Instructors
{
    private int budget;
    public Spartans() {
        setBudget(4000);
        setLocationIndex(0);
        setKnowledgeIndex(2);
    }

    public String getSecondLocation(){
        return getLocation();
    }

}
