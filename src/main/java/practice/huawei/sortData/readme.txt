对一个数据a进行分类，分类方法为：
此数据a（四个字节大小）的四个字节相加%一个给定的值b，如果得到的结果小于一个给定的值c，则此结果即为数据a的类型；
如果得到的结果大于或者等于c，则此结果无效即为数据a的类型无效。
比如一个数据a=0x01010101,b=3,按照分类方法计算（0x01+0x01+0x01+0x01）%3=1,所以如果c=2，则此a的类型是1，如果c=1，则此a的类型是无效。
输入12个数据，第一个数据为c，第二个数据为b，剩余10个数据为需要分类的数据a。
计算数据最多的类型（有效类型）有多少个数据。