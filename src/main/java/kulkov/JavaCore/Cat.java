package kulkov.JavaCore;

public class Cat {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// Constructor.
	public Cat(String name) {
		this.setName(name);
	}
}
