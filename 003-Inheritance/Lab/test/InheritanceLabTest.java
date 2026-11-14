import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static support.Console.run;

import java.util.List;

import org.junit.Test;

public class InheritanceLabTest {
    @Test
    public void singleInheritance() throws Exception {
        SingleInheritance.Dog dog = new SingleInheritance.Dog();
        assertEquals("eating...\nbarking...", run(() -> { dog.eat(); dog.bark(); }, ""));
    }

    @Test
    public void multipleInheritance() throws Exception {
        MultipleInheritance.Puppy puppy = new MultipleInheritance.Puppy();
        assertEquals("eating...\nbarking...\nweeping...", run(() -> { puppy.eat(); puppy.bark(); puppy.weep(); }, ""));
    }

    @Test
    public void hierarchicalInheritance() throws Exception {
        HierarchicalInheritance.Cat cat = new HierarchicalInheritance.Cat();
        HierarchicalInheritance.Dog dog = new HierarchicalInheritance.Dog();
        assertEquals("eating...\nmeowing...\nbarking...", run(() -> { cat.eat(); cat.meow(); dog.bark(); }, ""));
    }

    @Test
    public void randomArrayListReturnsAndRemovesAnElement() {
        RandomArrayList.RandomArrayList<String> list = new RandomArrayList.RandomArrayList<>();
        list.addAll(List.of("a", "b", "c"));
        String element = list.getRandomElement();
        assertTrue(List.of("a", "b", "c").contains(element));
    }

    @Test
    public void stackOfStrings() {
        StackOfStrings.StackOfStrings stack = new StackOfStrings.StackOfStrings();
        assertTrue(stack.isEmpty());
        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.peek());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertFalse(!stack.isEmpty());
    }
}
