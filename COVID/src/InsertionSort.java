
public class InsertionSort {

	public static void insertSort(String[] v0, int[] v1, int[] v2) {
		int n = v1.length;
		System.out.println("Por favor aguarde executando insertSort...");
		for (int j = 1; j < n; j++) {
			String key0 = v0[j];
			int key1 = v1[j];
			int key2 = v2[j];
			int i = j - 1;
			while ((i > -1) && (v1[i] > key1)) { 
				v0[i + 1] = v0[i];
				v1[i + 1] = v1[i];
				v2[i + 1] = v2[i];
				i--;
			}
			v0[i + 1] = key0;
			v1[i + 1] = key1;
			v2[i + 1] = key2;
		}
	}

	public static void insertSortStr(String[] v0, int[] v1, int[] v2) {
		int n = v0.length;
		String key0 = "";
		int key1 = 0;
		int key2 = 0;
		System.out.println("Por favor aguarde executando insertSortStr...");
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {			
				if(v0[i].compareToIgnoreCase(v0[j])<0) { 									
					key0 = v0[i];
					v0[i] = v0[j];
					v0[j] = key0;
					
					key1 = v1[i];
					v1[i] = v1[j];
					v1[j] = key1;

					key2 = v2[i];
					v2[i] = v2[j];
					v2[j] = key2;									
				}
			}
		}
	}
	

}
