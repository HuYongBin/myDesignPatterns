# 设计模式
要让你的程序尽可能的可重用。
软件需求变幻无穷，计划没有变化快，但是我们还是要寻找出不变的东西，并将它和变化的东西分离开来，这需要非常的智慧和经验。
设计模式节约开发时间，能开发出更灵活，可靠和健壮的软件。设计模式重用了概念的想法，解决方法的设计理念，考虑了他人的使用。
## 创建模式
1. 工厂方法模式(Factory)：定义了一个创建对象的接口，但由于子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。简单工厂方法一般是静态方法实现。设计原则：要依赖抽象，不要依赖具体类。
1. 抽象工厂模式(abstract factory)：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。
1. 原型模式(Prototype)：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。java实现Cloneable接口，clone()。Prototype模式允许一个对象在创建另外一个可定制的对象，根本无需知道任何如何创建的细节。
1. Builder设计模式：是为了将构建复杂对象的过程和它的部件解耦.注意： 是解耦过程和部件.
1. 单例模式(Singleton)：确保一个类只有一个实例，并提供一个全局访问点。
## 结构模式
1. 外观模式(Facade)：提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
1. 代理模式(Proxy)：为另一个对象提供一个替身或占位符以控制对这个对象的访问。  
1. 适配器模式(Adapter)：将一个类的接口，转换成客户期望的另一个接口。适配器让原本不兼容的类可以合作无间。
最少知识原则：只和你的密友谈话。（设计对象，注意交互的类有哪些！并注意是如何交互的。不要让太多的类耦合在一起)
对象方法内调用属于以下范围：该对象本身、被当做方法的参数而传递过来的对象、此方法所创建或实例化的任何对象、对象的任何组件。
1. 组合模式(Component)：允许你将对象组合成树形结构来表现“整体/部分”层次机构，组合能让你客户以一致的方式处理个别对象以及对象组合。
1. 装饰者模式(Decorator)：动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。
设计原则：类应该对扩展开放，对修改关闭。
1. Bridge模式：将抽象部分与实现部分分离,各自独立,但能动态的结合,使它们都可以独立地变化。
当一个类的子类需要扩展时，如果要在两个维度进行扩展，那么就可以使用Bridge模式。
1. 享元模式(Flyweight)：缓存(共享)可以共同的对象、属性，避免创建大量的重复对象、内容。
内部状态Entrinsic和外部状态extrinsic之分。
## 行为模式
1. 模板方法模式(Template)：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下。重新定义算法中的某些步骤。
1. 备忘录模式(Memento):是一个保存另外一个对象内部状态拷贝的对象.这样以后就可以将该对象恢复到原先保存的状态。
1. 观察者模式(Observer)：定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。
设计原则：为了交互对象之间的松耦合设计而努力。
1. 责任链模式(Chain of Responsibility)：很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织和分配责任。
1. 命令模式(Command)：解耦了发送者和接受者之间联系,将请求封转成对象，以便使用不同的请求、队列或日记来参数化其他对象。命令模式也支持可撤销的操作。
1. 状态模式(State)：允许对象在内部状态改变时改变它的行为，对象看起来好想修改了它的类。
1. 策略模式(Strategy)：定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。
设计原则：针对接口编程，而不是针对现实编程。
    找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。
    多用组合，少用继承。
1. 中介者(Mediator):用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
1. 解释器模式（Interpreter）:定义语言的文法 ,并且建立一个解释器来解释该语言中的句子。
1. 访问者模式(Visitor):作用于某个对象群中各个对象的操作. 它可以使你在不改变这些对象本身的情况下,定义作用于这些对象的新操作。
    使用访问者模式是对象群结构中(Collection) 中的对象类型很少改变。
    Java的Reflect技术解决了这个问题，因此结合reflect反射机制，可以使得访问者模式适用范围更广了。

1. 迭代器(Iterate)：提供一个方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。

控制反转(IoC,Inversion of Control)是，关于一个对象如何获取他所依赖的对象的引用，这个责任的反转
面向切面编程AOP

# 软件设计模式
purMVC
MVC、MTV、MVP
Architectural Pattern、Design Pattern、Coding Pattern

# 权限设计
基于角色的访问控制（Role-Based Access Control）
访问控制列表（Access Control List，ACL）

# JAVA API
Java多线程Future Pattern模式：当一个线程需要另一个线程的处理的结果时候，则不必一直等着处理结果，可以先处理别的事情，提前拿个Future对象，再过一段时间来获取另一个线程的处理结果。
java.util.concurrent.atomic：支持在单个变量上解除锁定的线程安全编程。替换基础类型并发修改加锁机制，通过CPU硬件实现并发修改同步  
SynchronousQueue（BlockingQueue）：是这样一种阻塞队列，其中每个 put 必须等待一个 take，反之亦然。同步队列没有任何内部容量，甚至连一个队列的容量都没有  
CountDownLatch：一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。  
CyclicBarrier：N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。  
对于CountDownLatch来说，重点是那个“一个线程”, 是它在等待， 而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。  
而对于CyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。  
ThreadLocal：线程本地变量,每个线程可以访问自己内部的副本变量  
ThreadLocalRandom.current().nextInt(10)  