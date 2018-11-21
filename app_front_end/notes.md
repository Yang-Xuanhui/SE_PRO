# Notes about Learning Front-End Web Development with React

## Set up Development Environment: Git and Node

### Git

### Node.js and NPM

Installing an NPM Module

* Install an NPM module, lite-server, that allows you to run a Node.js based development web server and serve up your project files. To do this, type the following at the prompt:

    `npm install lite-server --save-dev`

* Next, open package.json in your editor and modify it as shown below. Note the addition of two lines, line 7 and line 9.
  
  ```json
  {
  "name": "git-test",
  "version": "1.0.0",
  "description": "This is the Git and Node basic learning project",
  "main": "index.html",
  "scripts": {
    "start": "npm run lite",
    "test": "echo \"Error: no test specified\" && exit 1",
    "lite": "lite-server"
  },
  "repository": {
    "type": "git",
    "url": "git+https://jogesh_k_muppala@bitbucket.org/jogesh_k_muppala/git-test.git"
  },
  "author": "",
  "license": "ISC",
  "homepage": "https://bitbucket.org/jogesh_k_muppala/git-test#readme",
  "devDependencies": {
    "lite-server": "^2.2.2"
  }
}
```


## Reference

[course](https://www.coursera.org/learn/front-end-react/home/welcome)