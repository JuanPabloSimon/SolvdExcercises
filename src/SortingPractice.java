import java.util.Random;
public class SortingPractice {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
	
		System.out.println("Before: ");
		printArray(array);
		
		insertionSort(array);
		
		System.out.println("After: ");
		printArray(array);
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void insertionSort(int[] inputArray) {
		for(int i = 1; i < inputArray.length; i++) {
			int currentValue = inputArray[i];
			
			int j = i - 1;
			while(j >= 0 && inputArray[j] > currentValue) {
				inputArray[j+1] = inputArray[j];
				j--;
			}
			inputArray[j + 1] = currentValue;
		}
	}
}
