pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Compile') {
            steps {
                echo 'Compiling Java source code...'
                // This creates the Calculator.class file
                bat 'javac Calculator.java'
            }
        }
        stage('Test Run (Optional)') {
            steps {
                echo 'Listing files to verify compilation...'
                bat 'dir'
            }
        }
        stage('Execute') {
            steps {
                echo 'Starting Calculator Application...'
                /* NOTE: Running a GUI app (Swing) in Jenkins is tricky 
                   because Jenkins runs as a background service. 
                   This command will run the logic, but you might not see the window 
                   pop up on your desktop.
                */
                bat 'java Calculator'
            }
        }
    }
    post {
        success {
            echo 'Java Build Successful!'
        }
        failure {
            echo 'Build Failed. Ensure JDK is installed on the Jenkins Machine.'
        }
    }
}
