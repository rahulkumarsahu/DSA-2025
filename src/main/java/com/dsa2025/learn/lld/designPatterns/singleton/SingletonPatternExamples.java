package com.dsa2025.learn.lld.designPatterns.singleton;

public class SingletonPatternExamples {

    // Eager Initialization
    // Instance is created at the time of class loading.
    // Thread-safe by nature of classloading.
    // Problem: Instance is created even if it's never used. Wastes memory.
    private static final SingletonPatternExamples eagerInstance = new SingletonPatternExamples();

    public static SingletonPatternExamples getEagerInstance() {
        return eagerInstance;
    }

    // Lazy Initialization
    // Instance is created only when it’s needed.
    // Problem: Not thread-safe. Two threads could create two separate instances.
    private static SingletonPatternExamples lazyInstance;

    public static SingletonPatternExamples getLazyInstance() {
        if (lazyInstance == null) {
            lazyInstance = new SingletonPatternExamples();
        }
        return lazyInstance;
    }

    // Synchronized Method
    // Thread-safe because the method is synchronized.
    // Problem: Synchronization is costly. Even after the instance is created, every call is synchronized.
    private static SingletonPatternExamples syncInstance;

    public static synchronized SingletonPatternExamples getSynchronizedInstance() {
        if (syncInstance == null) {
            syncInstance = new SingletonPatternExamples();
        }
        return syncInstance;
    }

    // Double-Checked Locking
    // Improves performance by locking only the first time.
    // Problem (before Java 1.5): JVM could reorder instructions causing null issues.
    // Fix: Use `volatile` to prevent reordering and ensure visibility across threads.
    private static volatile SingletonPatternExamples doubleCheckInstance;

    public static SingletonPatternExamples getDoubleCheckedInstance() {
        if (doubleCheckInstance == null) { // First check (without lock)
            synchronized (SingletonPatternExamples.class) {
                if (doubleCheckInstance == null) { // Second check (with lock)
                    doubleCheckInstance = new SingletonPatternExamples();
                }
            }
        }
        return doubleCheckInstance;
    }

    // Private constructor to prevent external instantiation
    private SingletonPatternExamples() {
        System.out.println("Singleton instance created");
    }
}
// 49 new SingletonPatternExamples(10); int data; this.data = data
//Memory, constructor initialize, doubleCheckInstance
// Memory, doubleCheckInstance, constructor

/*
 *
 * Problem in Double-Checked Locking (Before Java 1.5)
 * You might write code like this:

 * If (instance == null) {
 *     synchronized (SomeClass.class) {
 *         if (instance == null) {
 *             instance = new SomeClass(10);  // PROBLEM HERE
 *         }
 *     }
 * }
 * It looks correct, right? But before Java 1.5, the Java Memory Model allowed the JVM to reorder instructions for optimization.
 *
 *  What does "instruction reordering" mean?
 * When you do this:
 *
 * instance = new SomeClass();
 * It’s not a single step behind the scenes. It's really like this:
 *
 * Allocate memory for the object.
 *
 * Assign memory address to instance (instance != null now!)
 *
 * Run the constructor (new SomeClass() logic).
 *
 * The problem: Step 2 (assignment) might happen before step 3 (construction)!
 *
 *  So What Goes Wrong?
 * Imagine this happens:
 *
 * Thread 1 start creating the object.
 *
 * It assigns instance = something (not null), but the constructor hasn't finished yet!
 *
 * Thread 2 checks if (instance == null) → it's not null, so it uses it.
 *
 * Now thread 2 uses an object that’s not fully initialized!
 *
 * This leads to bugs, crashes, or unique behavior.
 *
 * How volatile Fixes This
 * When you declare:
 *
 * private static volatile SomeClass instance;
 * The keyword volatile does two important things:
 *
 * Prevents instruction reordering:
 * The JVM is not allowed to move the assignment before constructor finishes.
 *
 * Ensures visibility across threads:
 * When Thread 1 sets instance, Thread 2 sees the latest value, not a stale cached one.
 *
 * So now, this is guaranteed:
 *
 * Object is fully constructed before any thread sees instance != null.
 *
 * Summary (Straightforward)
 * Without volatile	With volatile
 * JVM might reorder steps	Reordering is not allowed
 * Another thread sees incomplete object	Another thread sees fully built object
 * Risk of hard-to-find bugs	Safe multithreading behavior
 *
 *
 * Basically, kya hota hai thread 1 and thread 2 jab parallel run karte hai to jvm 1.5 ke baad reorder
 * hota hai 2,3 step reorder ho jata hai to thread 2 ko object mil jaayega but value nahi milega...
 *
 */
