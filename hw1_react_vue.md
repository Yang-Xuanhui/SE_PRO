## What is React?
>React is, in our opinion, the premier way to build big, fast Web apps with JavaScript. It has scaled very well for us at Facebook and Instagram.
  * a JavaScript library – one of the most popular ones, with over 100,000 stars on GitHub.
  * an open-source project created by Facebook.
  * be used to build user interfaces (UI) on the front end.
  * the view layer of an MVC application (Model View Controller)
## Features of React
### One-way data binding with props
Properties (commonly, props) are passed to a component from the parent component. Components receive props as a single set of immutable values (a JavaScript object).

### Stateful components
States hold values throughout the component and can be passed to child components through props:

### Virtual DOM
Use "virtual Document Object Model", or "virtual DOM". React creates an in-memory data structure cache, computes the resulting differences, and then updates the browser's displayed DOM efficiently.This allows the programmer to write code as if the entire page is rendered on each change, while the React libraries only render sub components that actually change.

### JSX
Use JSX with React to describe what the UI should look like. It looks like a bunch of HTML mixed with JavaScript.React doesn’t require using JSX, but most people find it helpful as a visual aid when working with UI inside the JavaScript code.

```js
  ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById('root')
  );
```

### Architecture beyond HTML
The basic architecture of React applies beyond rendering HTML in the browser.

## What is Vue? 
* Vue.js is a JavaScript front-end framework that was built to organize and simplify web development.

* The project focuses on making ideas in web UI development (components, declarative UI, hot-reloading, time-travel debugging, etc.) more approachable. It attempts to be less opinionated and thus easier for developers to pick up. 

## Features of Vue
### Templates
Vue uses an HTML-based template syntax that allows you to declaratively bind the rendered DOM to the underlying Vue instance’s data.
### Reactivity
 Models are just plain JavaScript objects. When you modify them, the view updates.Each component keeps track of its reactive dependencies during its render, so the system knows precisely when to re-render, and which components to re-render.
### Components
Divide the whole app into small, self-contained, and often reusable components to make development manageable
### Transitions
* automatically apply classes for CSS transitions and animations
* integrate third-party CSS animation libraries, such as Animate.css
* use JavaScript to directly manipulate the DOM during transition hooks
* integrate thir
## Compare between React & Vue

## Pros & Cons of Virtual DOM

## Referance
https://en.wikipedia.org/wiki/React.js

https://www.taniarascia.com/getting-started-with-react/

https://reactjs.org/

https://en.wikipedia.org/wiki/Vue.js

https://cn.vuejs.org/

[浅谈Virtual DOM] https://blog.csdn.net/lm278858445/article/details/80181927

https://baijiahao.baidu.com/s?id=1608099200125495014&wfr=spider&for=pc
