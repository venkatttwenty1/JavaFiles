import java.io.*;
import java.util.*;


public class E {
	
	public static void main(String[] args)throws IOException {
		
		FastScanner scan = new FastScanner();
		PrintWriter output = new PrintWriter(System.out);
		int len = 200001;
		int n = scan.nextInt();
		int m[] = new int[n];
		int k[] = new int[n];
		for(int i = 0;i<n;i++) {
			m[i] = scan.nextInt();
			k[i] = scan.nextInt();
		}
		ArrayList<Pair> list = new ArrayList<>();
		double max = 0; int maxpos = 0;
		for(int pick = 1;pick<=20;pick++) {
			
			Pair exp[] = new Pair[len];
			for(int i = 0;i<len;i++) exp[i] = new Pair(0, i);
			for(int i = 0;i<n;i++) {
				if(pick <= k[i]) exp[m[i]].a += 1;
				else exp[m[i]].a += k[i]/(double)pick;
			}
			sort(exp);
//			for(Pair p : exp) System.out.println(p);
			double sum = 0;
			for(int i = 0;i<pick;i++) {
				sum+= exp[i].a;
			}
//			System.out.println(sum);
			if(sum > max) {
				max = sum;
				maxpos = pick;
			}
		}
		
		int pick = maxpos;
		Pair exp[] = new Pair[len];
		for(int i = 0;i<len;i++) exp[i] = new Pair(0, i);
		for(int i = 0;i<n;i++) {
			if(pick <= k[i]) exp[m[i]].a += 1;
			else exp[m[i]].a += k[i]/(double)pick;
		}
		sort(exp);
//		for(Pair p : exp) System.out.println(p);
		
		System.out.println(pick);
		for(int i = 0;i<pick;i++) {
			System.out.print(exp[i].b + " ");
		}
	}
	
	static class Pair implements Comparable<Pair>{
		double a;
		int b;

		public Pair(double a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			//change this
			return -Double.compare(this.a, p.a);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(a);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + b;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
				return false;
			if (b != other.b)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pair [a=" + a + ", b=" + b + "]";
		}
		
	}
	
	public static Pair[] sort(Pair arr[]) {
		List<Pair> list = new ArrayList<>();
		for(Pair i:arr) list.add(i);
		Collections.sort(list);
		for(int i = 0;i<list.size();i++) arr[i] = list.get(i);
		return arr;
	}
	
	public static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b%a, a);
	}
	
	static boolean isPrime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) if (n % i == 0) return false;
        return true;
    }
	
	public static void printArray(int arr[]) {
		for(int i:arr) System.out.print(i+" ");
		System.out.println();
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}

