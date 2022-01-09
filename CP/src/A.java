
import java.io.*;
import java.util.*;


 
public class A {
	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		List<user> arr=new ArrayList<user>();
		for(int i=0;i<n;i++)
		{
			int id=sc.nextInt();
			String name=sc.next();
			user B=new user(id,name);
			arr.add(B);
		}
		for(user t: arr)
		{
			System.out.print(t.id + " "+ t.name+"\n");
		}
		sc.close();
	}

	static class user
	{
		private int id;
		private String name;
		public user() {
		}
		public user(int id, String name) {
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}	
		public void setName(String name) {
			this.name = name;
		}
	
	}

}