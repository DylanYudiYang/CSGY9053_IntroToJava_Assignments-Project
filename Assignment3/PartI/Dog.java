//Yudi Yang, Section I, Dean Christakos, 2023.2.15, A3p1
public class Dog {
        private int age;
        private String owner;
        private String breed;
              
        public Dog() {
        	
        }
        
        public Dog(int age, String owner, String breed) {
            this.age = age;
            this.owner = owner;
            this.breed = breed;
        }

        public static boolean hasSameOwner(Dog dog1, Dog dog2) {
            return dog1.owner == dog2.owner;
        }

        public static double avgAge(Dog[] dogs) {
            int totalAge = 0;
            for (Dog dog : dogs) {
                totalAge += dog.age;
            }
            return (double) totalAge / dogs.length;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        public String toString() {
            return breed + ": Owner: " + owner + ", Age: " + age;
        }
        
        public static void main(String[] args) {
                
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
                // The dog that we are asked to create
                dogs[1] = new Dog(8, "Dexter Morgan", "Corgi");
                // Other dogs
                dogs[2] = new Dog(5, "Tony Stark", "Peter Parker");
                dogs[3] = new Dog(6, "Sam Smith", "Justin Bieber");
                dogs[4] = new Dog(2, "Bob Dylan", "Steve Rogers");
                
                // Compare owners
                System.out.println(Dog.hasSameOwner(dogs[0], dogs[1])); //false
                System.out.println(Dog.hasSameOwner(dogs[1], new Dog(4, "Dexter Morgan", "Ben"))); //true
                
                // Compute average age of dogs
                System.out.println(Dog.avgAge(dogs));
                
                // Get and set age
                System.out.println(dogs[1].getAge());
                dogs[1].setAge(9);
                System.out.println(dogs[1].getAge());
                
                // Get and set owner
                System.out.println(dogs[1].getOwner());
                dogs[1].setOwner("Taylor Swift");
                System.out.println(dogs[1].getOwner());
                
                // Get and set breed
                System.out.println(dogs[1].getBreed());
                dogs[1].setBreed("David");
                System.out.println(dogs[1].getBreed());
                
                // toString method
                System.out.println(dogs[1]);
                System.out.println(dogs[2]);
        }
}