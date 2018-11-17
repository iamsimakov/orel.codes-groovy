#orel.codes.groovy

server code based on:
https://gist.github.com/renatoathaydes/2860486594cfe39e43d36bae22cf5aff

build script based on: http://stackoverflow.com/questions/9749032/create-a-groovy-executable-jar-with-gradle

build:

`gradle uberjar`

start

`java -jar build/libs/groovy-test-server-1.0.jar`

run wrk test(https://github.com/wg/wrk/wiki/Installing-Wrk-on-Linux)

`wrk -c400 -t20 -d100s -s post.lua http://127.0.0.1:4567`
