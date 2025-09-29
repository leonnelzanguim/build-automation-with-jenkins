def buildApp() {
  echo 'building the application...'
}

def buildApp() {
  echo 'testing the application...'
}

def deployApp() {
  echo 'deploying the application...'
  echo "deploying version ${params.VERSION}"
}

return this
