node('master') {

    stage('checkout') {
        scm checkout
    }

    stage('Build & Unit test') {
        bat 'mvn clean verify -DskipITs=true'
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.*'
    }


}