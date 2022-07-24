public class Instructors
{
    private int budget;
    private int locationIndex;

    // This is made just for the instructors class since the lab specifies it has two locations. This is functionally
    // overwritten in the child classes.
    private int secondLocationIndex;
    private int knowledgeIndex;
    private String[] location = {"East", "West", "North", "South"};
    private String[] knowledge = {"Beginner", "Intermediate", "Advanced"};
    private String[] teachingMaterials = {"Texts", "Computers", "Software"};
    public Instructors() {
        budget = 2000;
        locationIndex = 2;
        secondLocationIndex = 3;
        knowledgeIndex = 0;
    }

    public int getBudget(){
        return budget;
    }

    public String getLocation(){
        return location[locationIndex];
    }

    public String getSecondLocation(){
        return location[secondLocationIndex];
    }

    public String getAllKnowledgeLevels(){
        StringBuilder returnStr = new StringBuilder();
        for (String item : knowledge)
            returnStr.append(item).append("\n");
        return returnStr.toString();
    }

    public String getKnowledge(){
        return knowledge[knowledgeIndex];
    }

    public String getMaterials(){
        StringBuilder returnStr = new StringBuilder();
        for (String item : teachingMaterials)
            returnStr.append(item).append("\n");
        return returnStr.toString();
    }

    public void setBudget(int budget){
        this.budget = budget;
    }

    public void setLocationIndex(int index){
        this.locationIndex = index;
    }

    public void setSecondLocationIndex(int index){
        this.secondLocationIndex = index;
    }

    public void setKnowledgeIndex(int index){
        this.knowledgeIndex = index;
    }

}
