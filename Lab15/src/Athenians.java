public class Athenians extends Instructors
{
    public Athenians() {
        setBudget(3000);
        setLocationIndex(1);
        setKnowledgeIndex(1);
    }

    public String getSecondLocation(){
        return getLocation();
    }
}
