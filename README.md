# bgc-ui

A [re-frame](https://github.com/Day8/re-frame) application 
designed to calculate bicycle gears for fixed gear, internal
gear and deraileur gear bikes.

This uses the clojure [bicycle-gear-calc library](http://github.com/ericgebhart/bike-gear-calc/)


Created with this template.

`lein new re-frame prod-inv-ui +re-com +cider +garden +10x +test`

## Development Mode

### Start Cider from Emacs:

Refer to the [shadow-cljs Emacs / CIDER documentation](https://shadow-cljs.github.io/docs/UsersGuide.html#cider).

The mentioned `dir-local.el` file has been created.

### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

### Run application:

```
lein clean
lein dev
```

shadow-cljs will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:8280](http://localhost:8280).

### Run tests:

Install karma and headless chrome

```
npm install -g karma-cli
```

And then run your tests

```
lein clean
lein run -m shadow.cljs.devtools.cli compile karma-test
karma start --single-run --reporters junit,dots
```

## Production Build

