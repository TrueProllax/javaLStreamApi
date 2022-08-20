package llax.stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import llax.stream.department.Employee;
import llax.stream.department.Position;
import org.junit.Test;

import llax.stream.department.Position;
import llax.stream.station.Planet;
import llax.stream.station.HabitatStatus;


public class TestFormulas {
    
    // F = x(<10) * 3 + 11 (L=4)
    
    @Test
    public void Formula1(){
        IntStream stream = IntStream.of(3,4,11,12,9,5,6);
        stream
                .filter(x -> x < 10)
                .map(x -> x * 3 + 11)
                .limit(4)
                .forEach(System.out::println);    
    }
    
    
    
    private  List<Employee> emps = List.of(
            new Employee("Michael", "Smith",   243,  43, Position.CHEF),
            new Employee("Jane",    "Smith",   523,  40, Position.MANAGER),
            new Employee("Jury",    "Gagarin", 6423, 26, Position.MANAGER),
            new Employee("Jack",    "London",  5543, 53, Position.WORKER)
    );
    
    // Вывести сотрудников с возрастом больше 30 и с позицией MANAGER
    @Test
    public void Formula2(){
        Stream<Employee> stream = emps.stream();
        stream
                .filter(emp -> emp.getAge() > 30)
                .filter(emp -> emp.getPosition() == Position.MANAGER)
                .forEach(System.out::println);
    }
    
    
    
    private List<Planet> pl = List.of(
            new Planet(1L,"Кингон",10000.6, HabitatStatus.LIVABLE),
            new Planet(2L,"Тичар",9999.6, HabitatStatus.RESCTRICTION),
            new Planet(3L,"Канур",8777.122, HabitatStatus.LIVABLE),
            new Planet(4L,"Тимар",13000.35, HabitatStatus.RESCTRICTION),
            new Planet(5L,"Барун",25999.35, HabitatStatus.UNSUITABLE)
    );
    
    // Создать новый лист с планетами, масса которых превышает 10 000
    @Test
    public void Formula3(){
        Stream<Planet> stream = pl.stream();
        
        List<Planet> plMore10 = stream
                .filter(pl -> pl.getMass() > 10000.0)
                .toList();
        
        plMore10.forEach(System.out::println);
    }
    
    // Создать список планет приходных дл жизни
    @Test
    public void Formula4(){
        Stream<Planet> stream = pl.stream();
        
        List<Planet> plForLive = stream
                .filter(pl -> (pl.getHabitatStatus() == HabitatStatus.LIVABLE) || 
                        (pl.getHabitatStatus() == HabitatStatus.RESCTRICTION))
                .toList();
        
        plForLive.forEach(System.out::println);
    }
    
    
    // Получить случайные цифры, где первая известна
    private Random random = new Random();
    
    @Test
    public void Iterate(){
        Stream.iterate(2, x -> x = random.nextInt(100))
            .limit(6)
            .forEach(System.out::println);
        
    }
    
    // Получить случайные цифры
    @Test
    public void Generate(){
        Stream.generate(() -> random.nextInt())
            .limit(6)
            .forEach(System.out::println);
    }
    
    // Создание стрима с помощью Builder
    @Test
    public void Builder(){
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
            .add(9)
            .add(10)
            .build()
            .forEach(System.out::println);
    }
    
    // Сортировка
    @Test
    public void Sorter() {
        Stream.of(120, 410, 85, 32, 314, 12)
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
        
    }
    
    // takeWhile
    @Test
    public void takeWhile(){
        Stream.of(1,2,3,5,6,3,1)
            .takeWhile(x -> x < 3)
            .forEach(System.out::println);
    }
    
    // forEach
    
    @Test
    
    public void forEach(){
        Stream.of(120, 410, 85, 32, 314, 12)
            .forEach(x -> System.out.format("%s, ", x));
    }
}
