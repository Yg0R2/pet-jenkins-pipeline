#!/usr/bin/env groovy

def call(Map args) {
    def defaultArgs = [script: '', returnStdout: false] << args

    return call((String) defaultArgs.script, (boolean) defaultArgs.returnStdout)
}

def call(String script, boolean returnStdout = false) {
    if (isUnix()) {
        return sh(script: script, returnStdout: returnStdout)
    }
    else {
        def result = bat(script: script, returnStdout: returnStdout)

        if (result as boolean) {
            result = result.trim().readLines().drop(1).join(" ")
        }

        return result
    }
}
