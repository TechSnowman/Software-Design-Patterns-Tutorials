package visitor;

// Step 1: Define the Visitor Interface
interface MuseumVisitor {
	void visit(AncientArtifact artifact);
	void visit(Painting painting);
}

// Step 2: Create Concrete Visitors
class StudentVisitor implements MuseumVisitor {

	@Override
	public void visit(AncientArtifact artifact) {
		System.out.println("Student is taking notes on the ancient artifact.");		
	}

	@Override
	public void visit(Painting painting) {
		System.out.println("Student is sketching the painting.");
	}
	
}

class TouristVisitor implements MuseumVisitor {

	@Override
	public void visit(AncientArtifact artifact) {
		System.out.println("Tourist is taking pictures of the ancient artifact.");
	}

	@Override
	public void visit(Painting painting) {
		System.out.println("Tourist is takin a selfie with the painting.");
	}
	
}

class ResearcherVisitor implements MuseumVisitor {

	@Override
	public void visit(AncientArtifact artifact) {
		System.out.println("Researcher is analyzing the origin of the artifact.");
	}

	@Override
	public void visit(Painting painting) {
		System.out.println("Researcher is examining the brush strokes of the painting.");
	}
	
}

// Step 3: Define the Exhibit Interface
interface Exhibit {
	void accept(MuseumVisitor visitor);
}

// Step 4: Create Concrete Exhibits
class AncientArtifact implements Exhibit {
	@Override
	public void accept(MuseumVisitor visitor) {
		visitor.visit(this);
	}
}

class Painting implements Exhibit {
	@Override
	public void accept(MuseumVisitor visitor) {
		visitor.visit(this);
	}
}

public class Museum {

	public static void main(String[] args) {

		Exhibit artifact = new AncientArtifact();
		Exhibit painting = new Painting();
		
		MuseumVisitor student = new StudentVisitor();
		MuseumVisitor tourist = new TouristVisitor();
		MuseumVisitor researcher = new ResearcherVisitor();
		
		System.out.println("Student Visits:");
        artifact.accept(student);
        painting.accept(student);
        System.out.println();

        System.out.println("Tourist Visits:");
        artifact.accept(tourist);
        painting.accept(tourist);
        System.out.println();

        System.out.println("Researcher Visits:");
        artifact.accept(researcher);
        painting.accept(researcher);
		
		
	}

}
