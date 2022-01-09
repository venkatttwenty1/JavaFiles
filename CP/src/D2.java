import java.io.*;
import java.util.*;

public class D2 {
	
	public static void main(String[] args)throws IOException {
		
		FastScanner scan = new FastScanner();
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = scan.nextInt(), m = scan.nextInt();
		char arr[] = scan.next().toCharArray();
		int prefixSums[][] = new int[6][n+1];
		char permutations[][] = new char[6][3];
		permutations[0] = "abc".toCharArray();
		permutations[1] = "acb".toCharArray();
		permutations[2] = "bac".toCharArray();
		permutations[3] = "bca".toCharArray();
		permutations[4] = "cab".toCharArray();
		permutations[5] = "cba".toCharArray();
		for(int i=0;i<6;i++) {
			for(int j=0;j<n;j++) {
				prefixSums[i][j+1] = prefixSums[i][j] + (permutations[i][j % 3] == arr[j] ? 0 : 1);
			}
		}
		
		for(int i=0;i<m;i++) {
			int l = scan.nextInt(), r = scan.nextInt();
			int min = Integer.MAX_VALUE;
			for(int j=0;j<6;j++) {
				min = Math.min(min, prefixSums[j][r] - prefixSums[j][l-1]);
			}
			output.write(min + "\n");
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

