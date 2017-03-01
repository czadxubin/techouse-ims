package test;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassA {
	@Autowired
	public ClassB b;
	public ClassA() {
	}
}
