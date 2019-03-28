# Task-1

## **Analysis of The Home Page Loading of SJTU and Compare with Three Other Universities**

### **Loading Summary** and **Details** of Four Universities (Chrome)

#### Network

* **SJTU**

![sjtu](img/load_sjtu.JPG)

![sjtu](img/detail_sjtu.JPG)

* **Tsinghua University** (THU)

![thu](img/load_thu.JPG)

![thu](img/detail_thu.JPG)

* **Fudan University** (FDU)

![fdu](img/load_fdu.JPG)

![fdu](img/detail_fdu.JPG)

* **Tongji University** (TJU)

![tju](img/load_tju.JPG)

![tju](img/detail_tju.JPG)

#### Performance

* **SJTU**

![sjtu](img/sjtu.JPG)

* **THU**

![thu](img/thu.JPG)

* **FDU**

![fdu](img/fdu.JPG)

* **TJU**

![tju](img/tju.JPG)

### **Analysis** - Why the Home Page Loading of SJTU Is Much Slower

**Many files need to be loaded**

*e.g.*  Many css, js files and images needed to be loaded from server and it takes much time.

But other home pages load less files or load these files from memory cache or disk memory.

* **SJTU**
![sjtu](img/css_sjtu.JPG)
![sjtu](img/js_sjtu.JPG)
![sjtu](img/img_sjtu.JPG)

* **THU**

less css and js files
![thu](img/css_thu.JPG)
![thu](img/js_thu.JPG)

load from memory cache
![thu](img/img_thu.JPG)

### **Optimization Solution**

1. Combine scripts and stylesheets to reduce HTTP requests.

2. Use memory cache

3. Compress the files (img, css etc.)

### Home Page

[SJTU](https://www.sjtu.edu.cn/)

[THU](http://www.tsinghua.edu.cn/publish/thu2018/index.html)

[FDU](http://www.fudan.edu.cn/mindex.html)

[TJU](https://www.tongji.edu.cn/)

### Reference

[Chrome开发者工具详解(2)-Network面板](https://www.cnblogs.com/LibraThinker/p/5981346.html)

[全新Chrome Devtools Performance使用指南](https://blog.csdn.net/hualusiyu/article/details/78616468)

[DOMContentLoaded 与 Load 区别](https://www.cnblogs.com/caizhenbo/p/6679478.html)

[from memory cache与from disk cache](https://www.jianshu.com/p/8332da83955d)

[前端提升页面加载速度](https://blog.csdn.net/qiqi_77_/article/details/79423111)