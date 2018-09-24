## What is React?
>React is, in our opinion, the premier way to build big, fast Web apps with JavaScript. It has scaled very well for us at Facebook and Instagram.
  * a JavaScript library – one of the most popular ones, with over 100,000 stars on GitHub.
  * an open-source project created by Facebook.
  * be used to build user interfaces (UI) on the front end.
  * the view layer of an MVC application (Model View Controller)
## Features of React
#### One-way data binding with props
Properties (commonly, props) are passed to a component from the parent component. Components receive props as a single set of immutable values (a JavaScript object).

#### Stateful components
States hold values throughout the component and can be passed to child components through props:

#### Virtual DOM
Use "virtual Document Object Model", or "virtual DOM". React creates an in-memory data structure cache, computes the resulting differences, and then updates the browser's displayed DOM efficiently.This allows the programmer to write code as if the entire page is rendered on each change, while the React libraries only render sub components that actually change.

#### Lifecycle methods
Lifecycle methods are hooks which allow execution of code at set points during the component's lifetime.

#### JSX
Use JSX with React to describe what the UI should look like. It looks like a bunch of HTML mixed with JavaScript.React doesn’t require using JSX, but most people find it helpful as a visual aid when working with UI inside the JavaScript code.

```js
  ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById('root')
  );
```

#### Architecture beyond HTML
The basic architecture of React applies beyond rendering HTML in the browser.

## What is Vue?
