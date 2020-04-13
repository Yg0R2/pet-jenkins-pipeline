#!/usr/bin/env groovy

def call() {
    if (isUnix()) {
        sh 'printenv'
    }
    else {
        bat 'SET'
    }
}
