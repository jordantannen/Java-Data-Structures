public class TestClass {
    public static void main(String[] args)
    {
        Instructors instructor = new Instructors();
        Spartans spartan = new Spartans();
        Athenians athenian = new Athenians();

        // Print Budgets
        System.out.println("Instructor Budget: $" + instructor.getBudget());
        System.out.println("Spartan Budget: $" + spartan.getBudget());
        System.out.println("Athenian Budget: $" + athenian.getBudget());
        System.out.println("Total Budget Allocation: $" + (instructor.getBudget() + spartan.getBudget() + athenian.getBudget()));

        // Print Locations
        System.out.println("\nLocation areas for instructors-");
        System.out.println(spartan.getLocation() + " location occupancy for Spartan instructors");
        System.out.println(athenian.getLocation() + " location occupancy for Athenian instructors");
        System.out.println(instructor.getLocation() + " location occupancy for standard instructors");
        System.out.println(instructor.getSecondLocation() + " location occupancy for standard instructors");

        // Print levels of knowledge
        System.out.println("\nAll possible levels of knowledge-");
        System.out.println(instructor.getAllKnowledgeLevels());

        // Print levels of knowledge by class
        System.out.println("Levels of knowledge by class-");
        System.out.println(spartan.getKnowledge() + " knowledge level for Spartan instructors");
        System.out.println(athenian.getKnowledge() + " knowledge level for Athenian instructors");
        System.out.println(instructor.getKnowledge() + " knowledge level for standard instructors");

        // Print teaching materials
        System.out.println("\nTeaching materials needed-");
        System.out.println(instructor.getMaterials());

    }

}
