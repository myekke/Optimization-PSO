

public class Myselectionsort {

        public static double[] doSelectionSort(double[] arr){

            for (int i = 0; i < arr.length - 1; i++)
            {
                int index = i;
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[j] < arr[index])
                        index = j;

                double smallerNumber = arr[index];
                arr[index] = arr[i];
                arr[i] = smallerNumber;
            }
            return arr;
        }

        public static double doit(double a[]){

            double[] arr2 = doSelectionSort(a);
            for(double i:arr2){
                return i;

            }
            return 0;
        }
    }

