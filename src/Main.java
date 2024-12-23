class Car {
    public String model = "Стандартная";
    public String colour = "Любой";
}
class Main{
    public static void main(String[] args) {
        // Создаем новый объект Car
        Car myCar = new Car();

        //Выводим значения полей которые мы задали в конструкторе
        System.out.println("Model: " + myCar.model);
        System.out.println("Colour: " + myCar.colour);
    }
}