#!/usr/bin/env groovy

def call(Map args) {
    def defaultArgs = [tasks: [], params: [], returnStdout: false] << args

    return call((List<String>) defaultArgs.tasks, (List<String>) defaultArgs.params, (boolean) defaultArgs.returnStdout)
}

def call(List<String> tasks, List<String> params = [], boolean returnStdout = false) {
    params.add('--stacktrace')

    def command = isUnix() ? './gradlew' : './gradlew.bat'

    return exec(script: "${command} ${tasks.join(' ')} ${params.join(' ')}", returnStdout: returnStdout)
}
