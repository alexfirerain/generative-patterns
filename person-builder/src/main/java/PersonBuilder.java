public class PersonBuilder {

    private String  intendedName = null,
                    intendedSurname = null,
                    intendedAddress = null;
    private int intendedAge = -1;

    public PersonBuilder setName(String name) {
        intendedName = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        intendedSurname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0)
            throw new IllegalArgumentException("Отрицательный возраст не дозволяется!");
        intendedAge = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        intendedAddress = address;
        return this;
    }

    public boolean readyToBuild() {
        return intendedName != null && intendedSurname != null;
    }

    public Person build() throws IllegalStateException {
        if (!readyToBuild())
            throw new IllegalStateException("Имя и фамилия являются обязательными полями!");
        return new Person(intendedName, intendedSurname, intendedAge, intendedAddress);
    }
}
