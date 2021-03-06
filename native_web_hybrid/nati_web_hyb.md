# **Comparation between Native app, Web app and Hybrid app**

![relationship of native, web and hybrid apps](https://github.com/Yang-Xuanhui/SE_PRO/blob/master/native_web_hybrid/relationship.png "relationship")

## **NATIVE**

Based on the **local operating systems** of smart phones, such as iOS, Android and WP.They are third-party applications using native programs to write and run. The commonly developed languages are **Java**, **C++**, etc.

## **WEB**

Web App is a kind of framework type of App development mode (HTML5 App framework development mode).It is **based on browser**.

This pattern usually consists of  two sections, "HTML5 cloud website" and "App client". The App application clients only need to install the application of framework part, and the application goes to the cloud to fetch data to mobile phone users every time users open the App.

## **HYBRID**

Hybrid App is **a combination of Native App and Web App**. It is to build a browser in the Native App to render the appropriate functional pages in the form of web pages.There are a lot of apps that are starting to adopt this approach, such as the Subscriptions in WeChat, which is presented as a Web page.

News APP and video APP generally adopt Native framework and Web content.

## **Pros & Cons**

![compare](https://github.com/Yang-Xuanhui/SE_PRO/blob/master/native_web_hybrid/compare.png "compare")

### Native 

  + Advantages:

    1. Provide the best user experience, the best user interface, smooth interaction
    2. Local resources can be accessed
    3. Mobile hardware devices, such as cameras and microphones, can be called

  + Disadvantages:
  
    1. High development costs.

       *Each mobile operating system needs independent development projects to provide different experiences for different platforms.*
    2. Slow release of new releases.
    
       *Downloads are user controlled, and many users don't want to download updates (for example, there are still many 1.0 users and you may have to maintain the 1.0 API).*
    3. App store release review cycle is long.
    
       *Android takes between one and three days, while iOS takes longer.*

### Web
  
   + Advantages:
  
        1. No need to install the package
        2. Overall light weight, low development cost
        3. The user is not required to update manually. The app developer will update directly in the background, and the new version will be pushed to the user, which is more convenient for business development
        4. Browser-based, cross-platform
   + Disadvantages:

        1. The page jumps arduous, unsteady sense is stronger.
   
           *When the speed of the network is limited, there are many times when the card or card dead phenomenon, interaction effect is limited*
        2. Security is relatively low and data can be easily compromised or hijacked
   
### Hybrid

  + Such apps combine the advantages of Native and Web apps:
  
        1. On the premise of realizing more functions, the app installation package should not be too large
        2. Open a web page within the application without the hassle of jumping to the browser
        3. When the main functional areas are relatively stable, the added functional areas adopt web form, which makes the iteration more convenient
  + Hybrid App strives to create an experience similar to Native App, but it is still limited by many factors, such as technology, network speed, etc. It is't perfect.
  
## **Development Process of Web Application**

### Step 1: analysis

The first step in developing a web application is to analyze your requirements.You should now define a list of features your application should provide as fully as possible.If you're doing this for a client, you need to understand what they want (make sure each of you knows what the other is saying).From your discussion, you can summarize requirements and software specifications.

### Step 2: design

Once you figure out what the web application needs to do, you can start designing.This step is usually repeated many times, each time you refine the design.

This step will let you know what your application will look like in the end.

At the end of this step, you basically know how your web application is organized.What's on the login page, how the user moves from the home page to each page.

### Step 3: implement and select a framework

Now that we know what we're going to develop, we need to do it. It's a lot of work, and you spend most of your time on it.The first decision you have to make is how to proceed, what kind of technology to adopt, what kind of framework.You have a lot of choice. You need to choose one that suits you.

List of most commonly used frameworks:

1. ASP.NET

2. The framework for any process on PHP

3. Python with Django

4. Ruby on Rails

### Step 4: polish

Now that the application has been developed, individual modules are integrated.You need to test to make sure that the requirements and software specifications you defined in step 1 are implemented (this problem is kept in mind throughout your development).You want to make sure that stupid users can't break your application by trying to do something you haven't done yet .You also want to make sure that your application works correctly in all browsers (hopefully not IE6).

### Step 5: release and follow up

This last step (but not the end of it) is to release your app so that users can actually use it. If you like, release a Beta first, so that only a small number of users can see the big problems in your application (because there are bound to be bugs in your application) and they can help you improve the quality of your application.Instead of adding features, focus on making your current program stable.

As you go through the beta phase, your application has become so solid that you can start thinking about how you can make it better by listening to feedback from users and experimenting with your application yourself. Find out where the discord is and get rid of it. Each subsequent iteration will go through the five steps above.

## **REFERENCE**

https://blog.csdn.net/qq_33748378/article/details/51320890?utm_source=blogxgwz0

https://www.jianshu.com/p/24bf070a4dcb

[web应用程序-百度百科](https://baike.baidu.com/item/web%E5%BA%94%E7%94%A8%E7%A8%8B%E5%BA%8F/2498090?fr=aladdin)
