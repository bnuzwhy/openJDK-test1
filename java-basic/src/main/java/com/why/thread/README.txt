synchronized 与 Lock的对比
Lock是显示所（手动开启和关闭锁） synchronized是隐式锁，出了作用域自动释放
Lock只有代码块锁，synchronize有代码块锁和方法锁
使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性
优先使用顺序：
    Lock > 同步代码块（已经进入了方法体，分配了相应资源） > 同步方法（在方法体之外）