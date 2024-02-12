pipeline {
    environment {
        registry = "atou26/projetdevops2"
        registryCredential = 'atou26'
        dockerImage = ''
        dockerHubUsername = 'mohamedyassine.gharbi@esprit.tn'
        dockerHubPassword = 'qsdffdsq26'
    }
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('GIT') {
            steps {
                            checkout scm
                   }
        }
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=123 -Dmaven.test.skip=true'
            }
        }
        stage('MOCKITO'){
            steps {
                sh 'mvn test'
            }
        }
        stage('NEXUS'){
            steps {
                sh 'mvn deploy'
            }
        }
        stage('Building image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":${BUILD_NUMBER}"
                }
            }
        }
        stage('Deploy image') {
                    steps {
                        script {
                            withCredentials([usernamePassword(credentialsId: registryCredential, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                                sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
                                sh "docker tag kaddemimage:v${BUILD_NUMBER} ${registry}/yassinegharbi-5infini2-g1-kaddem:kaddemimage"
                                sh "docker push ${registry}/yassinegharbi-5infini2-g1-kaddem:kaddemimage"
                            }
                        }
                    }
                }
        stage('docker-compose') {
            steps {
                sh 'docker compose up -d'
            }
        }
    }

    post {
        success {
            mail bcc: '',
            body: '''
            Dear Yassine,
            We are happy to inform you that your pipeline build was successful.
            Great work!
            -Jenkins Team -
            ''',
            cc: '',
            from: 'atou26.ag@gmail.com',
            replyTo: '',
            subject: 'Build Finished - Success',
            to: 'atou26.ag@gmail.com'
        }

        failure {
            mail bcc: '',
            body: '''
            Dear Yassine,
            We are sorry to inform you that your pipeline build failed.
            Keep working!
            -Jenkins Team -
            ''',
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
