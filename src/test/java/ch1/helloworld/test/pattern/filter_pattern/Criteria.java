package ch1.helloworld.test.pattern.filter_pattern;

import java.util.List;

public interface Criteria {
	
	public List<Person> meetCriteria(List<Person> persons);
	
}
