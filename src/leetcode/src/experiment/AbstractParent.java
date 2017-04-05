package experiment;

public abstract class AbstractParent {

	public final String TEST = "PARENT";
	
	public static void main(String[] args) {
		AbstractParent p = new Child();
		System.out.println(p.TEST);
	}

}
