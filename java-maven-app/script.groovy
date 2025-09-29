def buildJar() {
  echo 'building the application...'
  sh 'mvn -f java-maven-app/pom.xml package'
}

def buildImage() {
  echo 'testing the application...'
  withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t 10012975/demo-java-maven-app:2.0 -f java-maven-app/Dockerfile java-maven-app/'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push 10012975/demo-java-maven-app:2.0'
  }
}

def deployApp() {
  echo 'deploying the application...'
}

return this
