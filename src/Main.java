public class Main {
//    public static void main(String[] args) {

////        Пример 1
////        Из метода main создался фрейм в стеке с переменной value которая равна 33,
////        это значение осталось на стеке.
////        Затем вызываем метод changeValue, в него была передана по значению переменная value равная 33,
////        в этом методе мы поменяли значение переменной value на 22.
////        Далее вернулись в метод main, распечатываем значение переменной value которая равна 33.
////        Распечаталась переменная value со значением 33, т к в стеке это две разных ячейки памяти,
////        никакого обратного копирования не происходит. После завершения метода changeValue,
////        его стек-фрейм удаляется. Примитивные типы передаются по значению,
////        любые изменения затрагивают только копию переменной.
//        int value = 33;
//        changeValue(value);
//        System.out.println("value = " + value);
//    }
//
//    public static void changeValue(int value) {
//        value = 22;
//    }

////    Пример 2
////    Переменная value из метада main сохраняется на стеке, а объект Integer (33) в куче
////    (переменная value ссылается на объект 33 в куче). Вызывается переменная в методе changeValue, переменная
////    value которая создает новый фрейм в стеке, в которую передается копия ссылки на 33 (из кучи).
////    Теперь у нас 2 переменные value в стеке и обе указывают на один и тот же объект (33) в куче.
////    При выполнении value = 22; в методе changeValue, переменная value перенаправляется на новый объект 22 в куче.
////    Теперь value в changeValue указывает на 22, но value в main по прежнему указывает на 33.
////    Когда метод changeValue заканчивает выполнение, его стек фрейм удаляется, переменная value внутри него исчезает.
////    Объект 22 остается "без переменной" и он удаляется.
////    Ответ value = 33.
//    public static void main(String[] args) {
//        Integer value = 33;
//        changeValue(value);
//        System.out.println("value = " + value);
//    }
//
//    public static void changeValue(Integer value) {
//        value = 22;
//    }

////    Пример 3
////    В методе main в куче создается массив {3,4} а в стеке создается переменная value которая ссылаяется на этот массив.
////    Вызывается переменная value в методе changeValue, в стеке создается новый стек фрейм.
////    Переменная value в методе changeValue копирует ссылку на массив {3,4}.
////    Теперь у нас 2 переменные value в стеке и обе указывают на один и тот же массив {3,4} в куче.
////    При выполнении value = new Integer[]{1, 2}; в методе changeValue, переменная value указывает на новый массив {1, 2};.
////    value в методе main по прежднему указывает на старый массив {3,4} а value в changeValue теперь ссылается на новый массив {1, 2}.
////    Когда метод changeValue заканчивает выполнение, его стек фрейм удаляется, переменная value внутри него удаляется
////    сборщиком мусора.
////    Ответ value = [3, 4]
//
//    public static void main(String[] args){
//        Integer[] value = {3,4};
//        changeValue(value);
//        System.out.println("value = " + Arrays.toString(value));
//    }
//
//    public static void changeValue(Integer[] value){
//        value = new Integer[]{1, 2};
//    }

////    Пример 4
////    В методе main в куче создается массив {3,4} а в стеке создается переменная value которая ссылается на этот массив.
////    Вызывается переменная value в методе changeValue, в стеке создается новый стек фрейм.
////    Переменная value в методе changeValue копирует ссылку на массив {3,4}.
////    Теперь у нас 2 переменные value в стеке и обе указывают на один и тот же массив {3,4} в куче.
////    При выполнении value[0] = 99; в методе changeValue, изменяется существующий массив в куче.
////    value[0] стало 99, и это изменение видно и в методе main.
////    Когда метод changeValue завершается, стек фрейм changeValue удаляется, массив {99, 4} в куче остался неизменным.
////    В методе main value всё ещё указывает на тот же самый массив {99, 4}.
////    Ответ value = [99, 4]
//
//    public static void main(String[] args){
//        Integer[] value = {3,4};
//        changeValue(value);
//        System.out.println("value = " + Arrays.toString(value));
//    }
//
//    public static void changeValue(Integer[] value){
//        value[0] = 99;
//    }

////    Пример 5
////    В куче создается объект Person("Fedor", "Dostoevskiy"), в стеке переменная person содержит ссылку на этот объект.
////    Когда вызывается метод changePerson, в стеке создаётся копия ссылки переменной person и передаётся в метод changePerson.
////    Переменные person из методов main и changePerson указывает на один и тот же объект в куче.
////    При выполнении person = new Person("Lev", "Tolstoy"), в куче создается новый объект Person("Lev", "Tolstoy"),
////    переменная person в методе main остается не измененная. Переменная person внутри метода changePerson
////    теперь указывает на новый объект, но переменная person в методе main всё ещё указывает на старый объект.
////    Когда метод changePerson завершается, стек фрейм метода changePerson удаляется, переменная person внутри
////    метода changePerson исчезает. На объект Person("Lev", "Tolstoy") в куче теперь нет ссылок, он будет удален.
////    Переменная в методе main указывает на "Fedor Dostoevskiy", потому что мы изменили только локальную ссылку
////    в методе changePerson, а не сам объект.
////    Ответ person = Fedor Dostoevskiy
//    public class Person {
//        private String name;
//        private String surname;
//
//        public Person(String name, String surname){
//            this.name = name;
//            this.surname = surname;
//        }
//
//        @Override
//        public String toString(){
//            return this.name + " " + this.surname;
//        }
//    }
//
//    public static void main(String[] args){
//        Person person = new Person("Fedor","Dostoevskiy");
//        changePerson(person);
//        System.out.println("person = " + person);
//    }
//
//    public static void changePerson(Person person){
//        person = new Person("Lev", "Tolstoy")
//    }

////    Пример 6.
////    В куче создается объект Person("Fedor", "Dostoevskiy"), в стеке переменная person содержит ссылку на этот объект.
////    Когда вызывается метод changePerson, в стеке создаётся копия ссылки переменной person,
////    которая передаётся в метод changePerson.
////    Переменные person методов main и changePerson указывает на один и тот же объект в куче.
////    Мы не меняем ссылку, а изменяем поля объекта в куче, так как переменная person в методе main
////    и переменная person в методе changePerson указывают на один и тот же объект, изменения видны и в методе main.
////    Теперь объект в куче содержит "Lev Tolstoy", и эти изменения видны везде, где есть ссылка на этот объект.
////    Стек фрейм метода changePerson удаляется.
////    Переменная person внутри метода changePerson исчезает.
////    Объект в куче остался изменённым.
////    Ответ person = Lev Tolstoy
//    public class Person {
//        public String name;
//        public String surname;
//
//        public Person(String name, String surname){
//            this.name = name;
//            this.surname = surname;
//        }
//
//        @Override
//        public String toString(){
//            return this.name + " " + this.surname;
//        }
//    }
//
//    public static void main(String[] args){
//        Person person = new Person("Fedor","Dostoevskiy");
//        changePerson(person);
//        System.out.println("person = " + person);
//    }
//
//    public static void changePerson(Person person){
//        person.name = "Lev";
//        person.surname = "Tolstoy";
//    }



