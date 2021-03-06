drop table if exists `article`;

create table `article` (
  `id`          int(11)       not null auto_increment,
  `title`       varchar(500)  not null default ''  comment '标题',
  `author`      varchar(200)  not null default ''  comment '作者',
  `summary`     varchar(3000) not null default ''  comment '摘要',
  `content`     text          not null  comment '内容',
  `keywords`    varchar(500)  not null  comment '关键字',
  `like_num`    int(10)       not null default 0  comment '喜欢数',
  `comment_num` int(10)       not null default 0  comment '评论数',
  `create_time` timestamp     not null default CURRENT_TIMESTAMP  comment '创建时间',
  `update_time` timestamp     not null default CURRENT_TIMESTAMP  comment '更新时间',
  primary key (`id`),
  unique key `uniq_id` (`id`),
  index `index_title`(`title`)
)  engine = InnoDB  default charset = utf8mb4  comment = '文章信息表';

insert into `article` values ('1', 'java反射：根据给定类名实例化类并调用其方法', '王超',
                              '实习期间遇到一个题，题目大致是从一个文件中读取内容，文件格式如下：类名:属性名=值,属性名=值……。有若干行这样的数据，要求根据文件内容实例化类并且为其属性赋值，最后调用该类方法，输出类的各属性。 ',
                              '实习期间遇到一个题，题目大致是从一个文件中读取内容，文件格式如下：类名:属性名=值,属性名=值……。有若干行这样的数据，要求根据文件内容实例化类并且为其属性赋值，最后调用该类方法，输出类的各属性。 \r\n之前一直不会如何讲给定的类实例化，学习后代码如下：\r\n\r\npackage test;\r\n\r\nimport java.lang.reflect.InvocationTargetException;\r\nimport java.lang.reflect.Method;\r\n\r\n/**\r\n * Created by wangchao on 15-3-13.\r\n */\r\npublic class Test {\r\n    public static void main(String[] args) {\r\n        try {\r\n            // 根据给定的类名初始化类\r\n            Class catClass = Class.forName(\"Cat\");\r\n            // 实例化这个类\r\n            Object obj = catClass.newInstance();\r\n            // 获得这个类的所有方法\r\n            Method[] methods = catClass.getMethods();\r\n            // 循环查找想要的方法\r\n            for(Method method : methods) {\r\n                if(\"setName\".equals(method.getName())) {\r\n                    // 调用这个方法，invoke第一个参数是类名，后面是方法需要的参数\r\n                    method.invoke(obj, \"Tom\" );\r\n                }\r\n            }\r\n            // 调用指定方法\r\n            catClass.getMethod(\"shout\").invoke(obj, null);\r\n        } catch (ClassNotFoundException e) {\r\n            e.printStackTrace();\r\n        } catch (InstantiationException e) {\r\n            e.printStackTrace();\r\n        } catch (IllegalAccessException e) {\r\n            e.printStackTrace();\r\n        } catch (InvocationTargetException e) {\r\n            e.printStackTrace();\r\n        } catch (NoSuchMethodException e) {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n\r\nclass Cat {\r\n    private String name;\r\n\r\n    public void setName(String name) {\r\n        this.name = name;\r\n    }\r\n    public void shout() {\r\n        System.out.println(\"My name is \" + this.name + \"!\");\r\n    }\r\n}',
                              'java', '30', '0', '2016-07-12 17:11:20', '2016-07-12 17:11:20');
insert into `article` values
  ('2', '常用Linux命令总结', '王超', '实习期间经常和linux打交道，在linux下处理数据。在这里总结一下实习期间经常用到的命令以及方法，以备不时之需。不是很全。',
   '1、cat\r\n很常用的文件查看和拼接命令，使用很简单，使用-n可以在前面添加行号，最后重定向到目标文件。\r\n[plain] view plain copy\r\ncat file1  # 打印文件内容到屏幕  \r\ncat -n file1 file2 > out1  # 拼接文件内容并重定向到目标文件，并在文件前添加行号  \r\n2、cd\r\n最常用的命令，到指定文件目录下。这里说几个小技巧。\r\n[plain] view plain copy\r\ncd //  # 到系统文件夹下  \r\ncd /  # 到根目录下  \r\ncd -  # 到上一个工作目录下  \r\ncd ..  # 到上一级目录下  \r\ncd ~  # 到当前用户home目录下  \r\n3、cut\r\n最常用的就是文件切割叻，比如按照某分隔符切割出指定列\r\n[plain] view plain copy\r\ncut -f n-m -d \'\\t\' file1  # 将文件每行按照\\t分割并去出每行的n-m列（默认分隔符\\t)  \r\ncat -f 1,2,4- file1  # 将文件第三列去除  \r\n\r\n4、sort\r\n文件排序，常用参数有：\r\n-r    降序\r\n-o    指定输出文件，可重定向自己\r\n-n    依数字大小排序（默认以字典序排序）\r\n-t    指定分隔符（默认\\t）\r\n-k    指定按照哪列排序\r\n[plain] view plain copy\r\nsort file1 > out1  # 将文件按照第一列字典序排序并重定向到out1  \r\n5、uniq\r\n将上或下的重复行合并为一行，常和sort一起使用，用于文本去重，必须先排序再去重\r\n[plain] view plain copy\r\ncat file | sort | uniq  # 文本去重  \r\n\r\n6、join\r\n将两个文件按照某重复列拼接，并按照指定格式输出，常用参数有：\r\n-t    指定分隔符\r\n-1    指定第一个文件某列\r\n-2    指定第二个文件某列\r\n-o    指定输出格式\r\n-a1    显示第一个文件所有内容\r\n-a2    显示第二个文件所有内容\r\n-e    指定没join到的内容以指定内容补齐\r\n[plain] view plain copy\r\njoin -t $\'\\t\' -1 1 -2 2 file1 file2 -o 1.2 -o 2.1 > out1  # 将file1第一列和file2第二列拼接，输出格式为file1第二列和file2第一列（两个文件欲join列必须已排序）  \r\n\r\n7、sed\r\n在线的文本编辑命令，这个命令我用的并不是很多，但是这个命令很强大！\r\n这里列出一个网上写的很好的一篇博文：\r\nhttp://www.cnblogs.com/edwardlost/archive/2010/09/17/1829145.html\r\n感谢作者！\r\n8、grep\r\n很好用的文本搜索命令，支持强大的正则表达式，我经常用的命令如下：\r\n-n    显示出所在行号\r\n[plain] view plain copy\r\ngrep \'正则表达式\' file1  \r\n\r\n9、export\r\n设置环境变量命令，在公司常用于更改语言。\r\n[plain] view plain copy\r\nexport  LC_ALL=zh_CN.UTF-8  \r\n\r\n\r\n10、top\r\n和windows下的任务管理器挺像的。动态显示当前进程等。\r\n11、ls\r\n最常用，按照指定条件列出当前目录文件及文件夹。\r\n12、iconv\r\nlinux下的文件转码命令，\r\n-c    忽略无效字符\r\n-f    原编码\r\n-t    输出编码\r\n[plain] view plain copy\r\niconv -c -f gbk -t utf8 > out  # 将原gbk编码文件转换为utf8编码文件，忽略错误字符  \r\n\r\n\r\n13、df\r\n查看磁盘剩余情况的命令（因为公司服务器好多人在用，经常磁盘爆满）。\r\n14、du\r\n查看文件夹大小，默认递归，常用的命令：\r\n[plain] view plain copy\r\ndu -h  --max-depth=1  # 查看当前目录下文件夹大小  \r\n\r\n\r\n15、cp\r\n本地复制命令。\r\n[plain] view plain copy\r\ncp file1 file2  # 复制file1并命名为file2  \r\n\r\n\r\n16、mv\r\n移动文件命令，也可用于重命名文件。\r\n[plain] view plain copy\r\nmv file1 dir/  # 将file1移动到dir/文件夹里  \r\nmv file1 file2  # 将file1重命名为file2  \r\n\r\n\r\n17、mkdir\r\n新建文件夹命令，很简单\r\n18、rm\r\n删除文件或文件夹命令\r\n-r    递归删除\r\n-f    强制删除\r\n[plain] view plain copy\r\nrm -fr dir/  # 强制删除dir/文件夹  \r\n\r\n\r\n19、ssh\r\n远程登陆服务器命令。\r\n[plain] view plain copy\r\nssh user@192.168.1.1  # 以user用户身份远程登陆ip为192.168.1.1的服务器  \r\n\r\n\r\n20、scp\r\n在各服务器间复制文件\r\n[plain] view plain copy\r\nscp user@192.168.1.1:/data/file1 ./  # 将192.168.1.1服务器上的/data/file1文件复制到本地目录下  \r\nscp ./file1 user@192.168.1.1:/data/  # 将本地目录file1文件复制到192.168.1.1服务器上的/data/文件夹下  \r\n\r\n\r\n21、wc\r\n统计文件的字符个数、行数、比特数。\r\n\r\n22、paste\r\n横向拼接文件，和cat正好相反\r\n23、echo\r\n打印出指定字符。\r\n-e    不忽略转义字符，\\n就是换行等\r\n24、date\r\n查看当前日期和时间，可以按照指定格式格式化\r\n[plain] view plain copy\r\ndate -d 2-days-ago +%Y%m%d  # 打印出两天前的日期，格式是yyyy-mm-dd  \r\n\r\n\r\n25、pwd\r\n显示当前工作目录绝对路径\r\n26、find\r\n查找文件，常用于找指定文件\r\n[plain] view plain copy\r\nfind -name \"abc\"  # 递归查找当前文件夹下名字为abc的文件  \r\n\r\n\r\n27、chmod\r\n更改文件权限\r\n28、head\r\n查看文件头几行\r\n[plain] view plain copy\r\nhead -n 1 file1  # 查看文件第一行  \r\n\r\n\r\n39、tail\r\n查看文件最后几行，和head正好相反\r\n[plain] view plain copy\r\ntail -n 1 file1  # 查看文件最后一行  \r\n\r\n\r\n30、awk（另开文章详解）\r\n超级好用的文本处理命令！可以自成一门语言了！\r\n31、vim（另开文章详解）\r\n超级好用的编辑器！',
   'linux,shell', '591', '0', '2016-07-12 17:12:00', '2016-07-12 17:12:00');
insert into `article` values ('3', '使用java读取url网络文件', '王超', '使用java读取url文件',
                              '使用java读取url文件\r\n\r\n使用简单的url方法读取网络中的文件，代码如下，一看便知：\r\n\r\n[java] view plain copy\r\nimport java.io.BufferedReader;  \r\nimport java.io.IOException;  \r\nimport java.io.InputStreamReader;  \r\nimport java.net.URL;  \r\n  \r\n/** \r\n * @author: wangchao.wang \r\n * @date: 2015-07-22 14:47:00 \r\n */  \r\npublic class Test {  \r\n    private static final String URL = \"www.baidu.com\";  \r\n  \r\n    public static void main(String[] args) throws IOException {  \r\n        URL url = new URL(URL);  \r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));  \r\n        String s;  \r\n        while ((s = reader.readLine()) != null) {  \r\n            System.out.println(s);  \r\n        }  \r\n        reader.close();  \r\n    }  \r\n}  \r\n记在博客中方便查看。',
                              'java,网络', '69', '0', '2016-07-12 17:12:36', '2016-07-12 17:12:36');

drop table if exists `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(500) NOT NULL DEFAULT '' COMMENT '加密后密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_id` (`id`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员信息表';

drop table if exists `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL DEFAULT '' COMMENT '标题',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '地址',
  `like_num` int(10) NOT NULL DEFAULT '0' COMMENT '喜欢数',
  `comment_num` int(10) NOT NULL DEFAULT '0' COMMENT '评论数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_id` (`id`),
  KEY `index_title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图片信息表';