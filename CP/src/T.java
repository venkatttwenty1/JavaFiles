import java.io.*;
import java.util.*;

public class T {

	static class Pair{
		int a;
		int b;
		public Pair(int a, int b) {
			if(b<a) {
				this.a = b;
				this.b = a;
			}
			else {
				this.a = a;
				this.b = b;
			}
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
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
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}

	}

	public static void main(String[] args)throws IOException {

		FastScanner scan = new FastScanner();
		PrintWriter output = new PrintWriter(System.out);
		int t = scan.nextInt();
		for(int tt = 0;tt<t;tt++) {

			int n = scan.nextInt(), m = scan.nextInt();
			int seen[] = new int[n+1];
			for(int i = 0;i<m;i++) {
				int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
				seen[b] = 1;
			}
			int root = -1;
			for(int i = 1;i<=n;i++) {
				if(seen[i] != 1) {
					root = i;
					break;
				}
			}
			for(int i = 1;i<=n;i++) if(i!=root) output.println(root + " " + i);
		}
		output.flush();

	}

	public static int[] sort(int arr[]) {

		List<Integer> list = new ArrayList<>();
		for(int i:arr)
			list.add(i);
		Collections.sort(list);
		for(int i = 0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
		return arr;

	}

	public static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b%a, a);
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

