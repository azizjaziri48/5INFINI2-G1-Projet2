pipeline {
    agent any
    stages {
        stage('Github') {
            steps {
                checkout scm
            }
        }

        stage('Compiler') {
            steps {
                sh 'mvn clean compile'
            }
        }

stage('Sonarqube') {
               steps {
                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=123'
                     }

        }
             stage('Junit/Mockito') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
         stage('Nexus') {
                                 steps {
                                        sh 'mvn deploy -DskipTests=true'
                                             }
                                      }

stage('Docker images')
                 {
                      steps {
                         sh 'docker build -t kaddemimage:v${BUILD_NUMBER} -f Dockerfile ./'
                               }

                 }
                 stage('DockerHub') {
                                                              steps {

                                                         sh "docker login -u atou26 -p qsdffdsq26"
                                                         sh "docker tag kaddemimage:v${BUILD_NUMBER} atou26/projetdevops2:kaddemimage"
                                                         sh "docker push  atou26/projetdevops2:kaddemimage"
                                                              }
                                        }

 }

    post {
            success {
                mail bcc: '',
                body: '''
                'Dear Yassine ,
                we are happy to inform you that your pipeline build was successful.
                Great work!
                    -Jenkins Team - ''',
                cc: '',
                from: 'atou26.ag@gmail.com',
                replyTo: '',
                subject: 'Build Finished - Success',
                to: 'atou26.ag@gmail.com'
            }

            failure {
                mail bcc: '',
                body: '''
                'Dear Yassine,
                we are sorry to inform you that your pipeline build failed.
                Keep working!
                    -Jenkins Team - ''',
                cc: '',
                from: 'atou26.ag@gmail.com', replyTo: '',
                subject: 'Build Finished - Failure', to: 'atou26.ag@gmail.com'
            }

            always {
                emailext attachLog: true, body: '', subject: 'Build finished', from: 'atou26.ag@gmail.com', to: 'atou26.ag@gmail.com'
                cleanWs()
            }

        }


 }