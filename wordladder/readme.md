# User Guideline of Word Ladder

## Compile

命令行输入

> `mvn compile`

![compile](img/compile.jpg)

生成class文件，存在target目录下

![target-class](img/target.jpg)

## Test


> `mvn test`

执行src/test/java下单元测试类

![test](img/test.jpg)

## Clean

命令行输入

> `mvn clean`

clean是maven工程的清理命令，执行 clean会删除target目录及内容

![clean](img/clean.jpg)

## Package

package是maven工程的打包命令，对于java工程执行package打成jar包

> `mvn package`

![package](img/package.jpg)

## Install

> `mvn install`

将maven打成jar包或war包发布到本地仓库。

![install](img/install.jpg)

## Run Ladder

* 运行Ladder后首先输入要读取的字典的地址

![dictionary](img/dict.jpg)

* 输入开始和结束的单词（输错会重新开始）

![run](img/run.jpg)