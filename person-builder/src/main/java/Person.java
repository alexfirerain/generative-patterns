import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name, surname;
    private int age = -1;
    private String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > -1;
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        if (hasAge())
            return OptionalInt.of(age);
        return OptionalInt.empty();
    }
    public String getAddress() {
        return hasAddress() ? address : "";
    }

    public String setAddress(String address) {
        String oldAddress = getAddress();
        this.address = address;
        return oldAddress;
    }
    public void happyBirthday() {
        if (hasAge()) age++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals( person.name ) && surname.equals( person.surname ) && Objects.equals( address, person.address );
    }

    @Override
    public String toString() {
        StringBuilder fio = new StringBuilder("%s %s".formatted(name, surname));
        if (hasAge() || hasAddress()) {
            fio.append(" (");
            if (hasAge()) {
                fio.append(age);
                if (hasAddress()) fio.append(", ");
            }
            if (hasAddress()) fio.append(address);
            fio.append(")");
        }
        return fio.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }
}
