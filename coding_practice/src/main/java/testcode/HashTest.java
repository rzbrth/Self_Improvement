package testcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashTest {

	String a;
	HashTest(String s){
		this.a = s;
	}
	
	 @Override
	public int hashCode() {
		return Objects.hash(a);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashTest other = (HashTest) obj;
		return Objects.equals(a, other.a);
	}

	public static void main(String[] args) {
		 
		 HashTest h1= new HashTest("x");
		 HashTest h2= new HashTest("x");
		 HashTest h3=h1;

		 Set<HashTest> st = new HashSet<>();
		 st.add(h1);
		 st.add(h2);
		 
		 System.out.println(st.size());
		 
	 }
}
