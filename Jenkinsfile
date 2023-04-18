#!groovy

pipeline{
   agent any

   tools {
     maven 'mvn'
   }

   stages {

     stage ("build") {
        steps {
           sh 'mvn clean install'
        }
     }

        stage ("sonar"){
            steps{
                script{
                withSonarQubeEnv('sonarQube') {
            sh 'mvn clean verify sonar:sonar -Dsonar.projectName=sonarIntegratedSCMProject -Dsonar.projectKey=sonarIntegratedSCMProject'
                }
        }
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
