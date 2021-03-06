package com.aj.factory_method_pattern;

/**
 * @author aka_after_jason
 * @date 2020-11-10 12:35
 */

/**
 * 工厂三兄弟之工厂方法模式
 * 在简单工厂模式中只提供一个工厂类，该工厂类处于对产品类进行实例化的中心位置，它需要知道每一个产品对象的创建细节，
 * 并决定何时实例化哪一个产品类。简单工厂模式最大的缺点就是当有新产品要加入到系统时，必须修改工厂类，需要在其中加入必要的业务逻辑
 * 这违背了"开闭原则"。此外，在简单工厂模式中，所有的产品都由同一个工厂创建，工厂类职责较重，业务逻辑较为复杂，具体产品与工厂类
 * 之间的耦合度高，严重影响了系统的灵活性和扩展性，而工厂方法模式则可以很好的解决这一问题。
 *
 * 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，系统提供一个与产品等级结构对应
 * 的工厂等级结构。
 *
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 *             工厂方法模式又简称为工厂模式，又可称作为虚拟构造器模式或多态工厂模式。
 *             工厂方法模式是一种类创建型模式
 *
 * 工厂方法模式结构中包含如下几个角色：
 * Product(抽象产品)：它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
 * ConcreteProduct(具体产品)：它实现了抽象产品的接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品之间一一对应。
 * Factory(抽象工厂)：在抽象工厂类中，声明了工厂方法，用于返回一个产品。抽象工厂方法是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
 * ConcreteFactory(具体工厂)：它是抽象工厂的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例
 *
 * 与简单工厂模式相比，工厂方法模式最重要的区别是引入了抽象工厂角色，抽象工厂可以是接口，也可以抽象类或具体类。
 */


import com.aj.tools.XMLUtil;

/**
 * 工厂方法模式的客户端
 */
public class Factory_Method_Introduce {

    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        //factory = new DatabaseLoggerFactory(); // 这一步也可以将类名写入配置文件，然后读取配置文件，通过java反射机制得到类名
        factory = (LoggerFactory) XMLUtil.getBean();
        logger = factory.createLogger();
        logger.writeLog();
    }
}

/**
 * 工厂方法模式总结：
 *
 * 工厂方法模式是简单工厂模式的延伸，它继承了简单工厂模式的优点，同时还弥补了简单工厂模式的不足。工厂方法模式是使用频率最高的设计模式之一，
 * 是很多开源框架和API类库的核心模式
 *
 * 主要优点：
 * 1. 在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，
 *    无需关心创建细节，甚至无需知道具体产品的类名
 *
 * 2. 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够让工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在
 *    具体工厂内部。工厂方法模式之所以被称为多态工厂模式，就正是因为所有的具体工厂类都具有同一抽象父类
 *
 * 3. 使用工厂方法模式的另一个优点就是在系统加入新产品时，无需修改抽象工厂和抽象产品提供的接口，无需修改客户端，
 *    也无需修改其他的具体工厂和具体产品，而只需要添加一个具体工厂和具体产品就可以了，完全符合"开闭原则"。
 */