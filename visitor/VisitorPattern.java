package visitor;

// Step 1: Define Visitor Interface
interface Visitor {
	void visit(ElementA elementA);
	void visit(ElementB elementB);
}


// Step 2: Create Concrete Visitors
class ConcreteVisitor1 implements Visitor {

	@Override
	public void visit(ElementA elementA) {
        System.out.println("Visitor 1 is processing ElementA");		
	}

	@Override
	public void visit(ElementB elementB) {
        System.out.println("Visitor 1 is processing ElementB");		
	}

}

// Step 3: Define an Element Interface
interface Element {
	void accept(Visitor visitor);
}

// Step 4: Create Concrete Elements
class ElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Step 5: Client Code
public class VisitorPattern {

	public static void main(String[] args) {
		
		Element element1 = new ElementA();
		Element element2 = new ElementB();
		
		Visitor visitor = new ConcreteVisitor1();
		
		element1.accept(visitor);
		element2.accept(visitor);
	}

}
