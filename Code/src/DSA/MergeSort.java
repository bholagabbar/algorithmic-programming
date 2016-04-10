package DSA;

import java.io.IOException;

class MergeSort {
    static void Merge(int a[], int l[], int r[], int ll, int rl, int n) {
		int i = 0, j = 0, k = 0;
		while (k != n) {
            if (i == ll & j < rl) {
                a[k++] = a[j++];
            } else if (j == rl && i < ll) {
                a[k++] = a[i++];
            } else if (l[i] < r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
		}
	}
	
	static void Sort(int a[], int s, int e) {
		
		int n = e - s + 1;
        if (n < 2) {
            return;
        }
		int mid = (n + 1) >> 1;
		int ls[] = new int[mid];
		int rs[] = new int[mid];
		int las = 0, ras = 0;
		for (int i = 0; i < mid; i++) {
			ls[i] = a[i];
			las++;
		}
		for (int j = mid; j < n; j++) {
			rs[j - mid] = a[j];
			ras++;
		}
		Sort(ls, 0, las);
		Sort(rs, 0, ras);
		Merge(a, ls, rs, las, ras, n);
	}
	
	public static void main(String[] args) throws IOException {
		int a[] = {1, 7, 6, 100, 75, 2, 400, 6, 2, 90};
		Sort(a, 0, a.length - 1);
		for (int i : a)
			System.out.print(i + " ");
	}
}