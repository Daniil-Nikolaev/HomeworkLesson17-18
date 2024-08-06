import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //1.
        System.out.println("Введите дату рождения в формате YYYY-MM-DD:");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        System.out.println(LocalDate.parse(date).plusYears(100));
        //2.
        int[] arr = new int[]{1,-2,3,-4,-5,6,7,-8,9};
        Predicate<Integer> p = i -> i > 0;
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .filter(p)
                .toList();
        System.out.println(list);
        //3.
        System.out.println("Введите сумму в формате ** BYN");
        String sum= sc.nextLine();
        Function<String,Double> f = i -> Integer.parseInt(sum.split(" ")[0])/3.27;
        System.out.println(f.apply(sum)+" $");
        //4.
        System.out.println("Введите сумму в формате ** BYN");
        String sum1= sc.nextLine();
        Consumer<String> s= i->System.out.println(Integer.parseInt(sum.split(" ")[0])/3.27+" $");
        s.accept(sum1);
        //5.
        System.out.println("Введите строку");
        String str= sc.nextLine();
        Supplier<String> sup =()->{
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        };
        System.out.println(sup.get());
        //6.
        List<Integer> list1 = List.of(1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9);
        int result= list1.stream()
                .distinct()
                .filter(i->i%2==0)
                .reduce(0,Integer::sum);
        System.out.println(result);


    }
}