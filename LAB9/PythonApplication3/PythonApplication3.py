from human import Human
from student import Student

def main():
    person1 = Human("Alice", 25)
    person2 = Student("Bob", 20, "S12345")

    person1.introduce()
    person2.introduce()
    person2.study("Math")

if __name__ == "__main__":
    main()

