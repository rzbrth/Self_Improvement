# Install Docker
echo "===============Installing Docker========"
apt-get update
apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
apt-get update
apt-get install -y docker-ce docker-ce-cli containerd.io
sudo usermod -aG docker $USER && newgrp docker
echo "===============Docker Installed========"

# Install Java
echo "===============Installing Java========"
apt-get update
apt-get install -y default-jre
apt-get install -y default-jdk
echo "===============Java Installed========"

# Install Minikube
echo "===============Installing K8========"
wget https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo cp minikube-linux-amd64 /usr/local/bin/minikube
sudo chmod 755 /usr/local/bin/minikube
minikube start

snap install kubectl --classic
echo "===============K8s Installed========"
