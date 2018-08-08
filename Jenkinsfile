node {
    def mvnHome
    stage('checkout') {
        git 'https://github.com/lukmir/JenkinsPipelineExample.git'
        mvnHome = tool 'M3'
    }

    stage('Build & Unit test') {
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvnw' -Dmaven.test.failure.ignore clean package"
        } else {
            bat(/"${mvnHome}\bin\mvnw.cmd" -Dmaven.test.failure.ignore clean package/)
        }
        junit '**/target/surefire-reports/TEST-*.xml'
    }

    stage('Archive') {
        archive 'target/*.jar'
    }


}