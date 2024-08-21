public class workLoad1_O {
	public static void main(String[] args) {
		int N = 2000;									//Hvor mange ganger N skal kjøres
		int sum = 0;
		
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		int[] tab = new int[N];

		for (int i = 0; i < N; i++) {							//Itererer over hvert element i arrayet tab, hvert elemnt settes til verdien 'i'(tab[i]).
			tab[i] = (int) (Math.random() * 1000);
		}	

		//Algoritme 1
		sum = 0;									//Forsikrer oss om at summen er 0 før vi starter kjøringen.
		for (int i = 0; i < N; i++) {
			System.out.println(i);							//Linær algoritme O(N)
			sum += 15;
		}
		System.out.println("Algoritme 1 tid: " + (endTime - startTime) + " ns");

		
		//Algoritme 2									//Kubisk algoritme N*N*N = (N^3)
		startTime = System.nanoTime();
		sum = 0;
		for (int i = 0; i < N; i++) {
			sum = sum + i;
			for (int j = 0; j < N ; j++) {
				sum = sum + j;
				for (int k = 0; k < N; k++) {
					sum = sum + k;
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("Algoritme 2 tid: " + (endTime - startTime) + " ns");


		//Algoritme 3
		startTime = System.nanoTime();							//Linær algoritme, med sekvensiell kjøring
		sum = 0;									//O(N)+O(N)+O(N) = O(3N)
		for (int i = 0; i < N; i++) {
			sum = sum + i;
		}
		for (int j = 0; j < N; j++) {
			sum = sum + j;
		}
		for (int k = 0; k < N; k++) {
			sum = sum + k;
		}
		endTime = System.nanoTime();
		System.out.println("Algoritme 3 tid: " + (endTime - startTime) + " ns");


		//Algoritme 4
		startTime = System.nanoTime();							//linær algoritme N*3 = (3N)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println(N);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Algoritme 4 tid: " + (endTime - startTime) + " ns");


		//Algoritme 5									//linær algoritme N/3 = (N/3)
		startTime = System.nanoTime();
		for (int i = 0; i < N; i = i + 3) {
			System.out.println(tab[i]);
		}
		endTime = System.nanoTime();
		System.out.println("Algoritme 5 tid: " + (endTime - startTime) + " ns");

		
		//Algoritme 6
		int target = 1200; 								//Elementet vi ønsker å finne
		//Binærsøk									//O(log N)	
		int result = binarySearch(tab, target);
		System.out.println("Binærsøk tid: " + (endTime - startTime) + " ns");
			if (result == -1) {
				System.out.println("Elmentet " + target + " ble ikke funnet.");
			} else {
				System.out.println("Elementet " + target + " ble funnet på index " + result);
			}
		}
		
		public static int binarySearch(int[] array, int target) {			//Logikk for å få binærsøk til å fungere
			int left = 0;
			int right = array.length - 1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				//Sjekk om target er på midten
				if (array [mid] == target) {
					return mid;
				}
				//Hvis target er større, ignorer venstre halvdel
				if (array[mid] < target) {
					left = mid + 1;
				}
				//Hvis target er mindre, ignorere høyre halvdel
				if (array[mid] > target) {
					right = mid - 1;
				}
			}
			//Returnerer -1 hvis elementet ikke er funnet
			return -1;
		}	



	}
		
			




