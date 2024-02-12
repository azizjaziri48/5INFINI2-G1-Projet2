pipeline {
    agent any
    stages {
        stage('stage 1 github') {
            steps {
                checkout scm
            }
        }

        stage('stage 2 compiler') {
            steps {
                sh 'mvn clean compile'
            }
        }

stage('stage 3 sonarqube') {
               steps {
                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=123'
                     }

        }
             stage('stage 4 JUNIT/MOCKITO') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
         stage('stage 5 nexus') {
                                 steps {
                                        sh 'mvn deploy -DskipTests=true'
                                             }
                                      }

stage('stage 6 Docker images')
                 {
                      steps {
                         sh 'docker build -t kaddemimage:v${BUILD_NUMBER} -f Dockerfile ./'
                               }

                 }
                 stage('dockerhub') {
                                                              steps {

                                                         sh "docker login -u atou26 -p qsdffdsq26"
                                                         sh "docker tag kaddemimage:v${BUILD_NUMBER} atou26/atou26-5infini2-g5-kaddem:kaddemimage"
                                                         sh "docker push  atou26/atou26-5infini2-g5-kaddem:kaddemimage"
                                                              }
                                        }

 }

    post {
        success {
            echo 'Build successfully'
        }
        failure {
            echo 'failed '
        }
    }
 }