#!groovy

pipeline{
   agent any

   tools {
     maven 'Maven-3.8.6'
   }

   stages {

     stage ("build") {
        steps {
           sh 'mvn clean package'
        }
     }

     stage ("sonar-analysis") {
        steps {
            withSonarQubeEnv('Sonar_Server'){
                sh 'mvn sonar:sonar'
            }
        }
     }

     stage ("quality-gate"){
        steps {
            waitForQualityGate abortPipeline : true
        }
     }

     stage ("test") {
        steps {
            sh 'mvn verify'
        }
     }

     stage ("deploy") {
        steps {
            echo "deploying"
        }
     }

   } // end of stages

}