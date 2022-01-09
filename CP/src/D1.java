import java.io.*;
import java.util.*;

public class D1 {
	
	public static void main(String[] args)throws IOException {
		
		FastScanner scan = new FastScanner();
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = scan.nextInt(), m1 = scan.nextInt(), m2 = scan.nextInt();
		DSU mocha = new DSU(n);
		DSU diana = new DSU(n);
		
		for(int i = 0;i<m1; i++) mocha.union(scan.nextInt(), scan.nextInt());
		for(int i = 0;i<m2;i++) diana.union(scan.nextInt(), scan.nextInt());
		
		output.write(n-Math.max(m1, m2)-1 + "\n");
		for(int i = 1;i<=n;i++) {
			for(int j = i+1;j<=n;j++) {
				if(mocha.getParent(i) != mocha.getParent(j) && diana.getParent(i) != diana.getParent(j)) {
					mocha.union(i, j);
					diana.union(i, j);
					output.write(i + " " + j + "\n");
				}
			}
		}
		output.flush();
	}
	
	static class DSU {
		private int parent[];
		private int rank[];
		int size;
		
		public DSU(int size) {
			this.size = size;
			parent = new int[size+1];
			rank = new int[size+1];
			for(int i = 1; i<=size; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		public int getParent(int node) {
			if(node == parent[node]) return node;
			return parent[node] = getParent(parent[node]);
		}
		
		public void union(int u, int v) {
			u = getParent(u);
			v = getParent(v);
			if(u==v) return;
			if(rank[u] < rank[v]) parent[u] = v;
			else if(rank[v] < rank[u]) parent[v] = u;
			else {
				parent[v] = u;
				rank[u]++;
			}
		}
		
		public boolean isSameCompoment(int u, int v) {
			if(getParent(u) == getParent(v)) return true;
			return false;
		}
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

