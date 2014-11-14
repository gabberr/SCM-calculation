package at.fhooe.mcm.scm.model;

import java.util.ArrayList;

public class Product {
	ArrayList<Part> parts = new ArrayList();
	
	public Product(ArrayList<Part> _parts) {
		parts = _parts;
	}
	public void addPart(Part p) {
		parts.add(p);
	}
	public ArrayList<Part> getParts() {
		return parts;
	}

}
