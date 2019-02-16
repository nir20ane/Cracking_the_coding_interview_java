/**
 * An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest"
 * (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive
 * the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this
 * system and implement operations such as enqueue, dequeueAny, dequeueDog
 * and dequeueCat.You may use the built-in LinkedList data structure.
 */
package ccistackqueue;

import java.util.LinkedList;

public class AnimalShelter {
	
	static class Animal{
		String name;
		long timestamp;
		
		Animal(String n)
		{
			name = n;
			timestamp = System.nanoTime();
		}
	}
	
	static class Dog extends Animal
	{
		Dog(String n)
		{
			super(n);
			System.out.println(""+name+" Dog arrived shelter at "+timestamp+"");
		}
	}
	
	static class Cat extends Animal
	{
		Cat(String n)
		{
			super(n);
			System.out.println(""+name+" Cat arrived shelter at "+timestamp+"");
		}
	}
	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	public void enqueue(Animal anim)
	{
		if(anim instanceof Dog)
		{
			dogs.add((Dog) anim);
		}
		else if(anim instanceof Cat)
		{
			cats.add((Cat) anim);
		}
		else
		{
			throw new IllegalArgumentException("Animal is not a cat or dog");
		}
	}
	
	public Animal dequeueAny()
	{
		if(dogs.isEmpty() && cats.isEmpty())
		{
			throw new IllegalStateException("No animals!");
		}
		else if(dogs.isEmpty())
		{
			return dequeueCats();
		}
		else if(cats.isEmpty())
		{
			return dequeueDogs();
		}
		else if(dogs.peekFirst().timestamp < cats.peekFirst().timestamp)
		{
			return dequeueDogs();
		}
		else
		{
			return dequeueCats();
		}
	}
	
	public Cat dequeueCats()
	{
		if(cats.isEmpty()) throw new IllegalStateException("No cats!");
		return cats.removeFirst();
	}
	
	public Dog dequeueDogs()
	{
		if(dogs.isEmpty()) throw new IllegalStateException("No dogs!");
		return dogs.removeFirst();
	}
	
	public static void main(String[] args) {
		AnimalShelter as = new AnimalShelter();
		as.enqueue(new Dog("Burrow"));
		as.enqueue(new Cat("Kitty"));
		as.enqueue(new Dog("Tom"));
		as.enqueue(new Cat("Meow"));
		as.enqueue(new Dog("Jim"));
		as.enqueue(new Cat("Mingchi"));
		as.enqueue(new Dog("Colorful"));
		System.out.println(as.dequeueAny().name);
		System.out.println(as.dequeueDogs().name);
		System.out.println(as.dequeueCats().name);
		System.out.println(as.dequeueCats().name);
		System.out.println(as.dequeueDogs().name);
		System.out.println(as.dequeueAny().name);	
		//System.out.println(as.dequeueCats().name);
		System.out.println(as.dequeueDogs().name);
		//System.out.println(as.dequeueDogs().name);
	}
}
