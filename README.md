# bootdemo

basic hello world spring boot application - curl {EXTERNAL-IP}:8080/hello

1. Uses a private docker registry 
    go to jfrog artifactory to create a free tier docker repository
      - create local, remote and virtual repository
      - select local for storing docker pushes
  
  ref
    https://jfrog.com/blog/how-to-set-up-a-private-remote-and-virtual-docker-registry/
    https://jfrog.com/screencast/artifactory-5-one-minute-setup-docker-registry-as-container-install/
    https://www.jfrog.com/confluence/display/JFROG/Getting+Started+with+Artifactory+as+a+Docker+Registry
    
2. image pull secrets config
    Setup a secret configuration for storing your private image registry credentials
    
  ref  
    https://jamesdefabia.github.io/docs/user-guide/kubectl/kubectl_create_secret_docker-registry/
    
 3. build commands - manual CI
      docker pull dockr.jfrog.io/mido-docker/arm64v8/openjdk:11-jre-slim
      mvn compile jib:buildTar
      docker load < /home/ubuntu/com-learn/projects/bootdemo/target/jib-image.tar
      docker push dockr.jfrog.io/mido-docker/bootdemo:latest   
 
 4. deploy commands - manual CD
      kubectl apply -f k8s-deployment.yml
      kubectl apply -f k8s-service.yml
 
 5. skaffold CI/CD - for build and deploy automation
     skaffold build
     skaffold deploy
 
