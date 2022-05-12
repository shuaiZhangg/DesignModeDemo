package com.zhangshuai.designMode.abstractFactory;

/**
 * @Description: TODO
 * @Author: Shuai Zhang
 * @Date: 2022-04-30
 */

public class AbstractFactory {
    public static void main(String[] args) {
        IDatabase database = new MysqlDataBase();
        IConnection connection = database.getConnection();
        connection.Connection();
        ICommand command = database.getCommand();
        command.Command();
        IClose close = database.getClose();
        close.close();
    }
}

interface IConnection {
    void Connection();
}

interface ICommand {
    void Command();
}
interface IClose{
    void close();
}
interface IDatabase{

    //一个则为工厂模式 多个则为抽象工厂模式
    IConnection getConnection();
    ICommand getCommand();
    IClose getClose();
}

class MysqlConnection implements IConnection{

    @Override
    public void Connection() {
        System.out.println("Mysql connected...");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void Command() {
        System.out.println("Mysql Command...");
    }
}
class MysqlClose implements IClose{

    @Override
    public void close() {
        System.out.println("Mysql close...");
    }
}
class MysqlDataBase implements IDatabase{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }

    @Override
    public IClose getClose() {
        return new MysqlClose();
    }
}

class OracleConnection implements IConnection{

    @Override
    public void Connection() {
        System.out.println("Oracle connected...");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void Command() {
        System.out.println("Oracle Command...");
    }
}

class OracleClose implements IClose{

    @Override
    public void close() {
        System.out.println("Oracle close...");
    }
}
class OracleDatabase implements IDatabase{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }

    @Override
    public IClose getClose() {
        return new OracleClose();
    }
}