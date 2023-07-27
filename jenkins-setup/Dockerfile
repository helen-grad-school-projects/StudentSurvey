# This assignment was s ubmitted by Helen Glass. This Dockerfile builds a custom image with Jenkins installed,
# and also installs Docker and kubectl CLI on the image, so that jenkins is able to run docker and kubectl commands.

# Use an official Jenkins LTS as the base image
FROM jenkins/jenkins:lts

# Set user as root
USER root

# Gets all essential packages for docker installation
RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common

# Download  Docker Linux Debian distribution CLI
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -

# Adds Docker Linux Debian distribution CLI to respository
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"

# Downloads Docker
RUN apt-get update  -qq \
    && apt-get -y install docker-ce

# Adds jenkins user to docker group so it has permission to run docker commands
RUN usermod -aG docker jenkins

# Downloads the latest kubectl
RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"

# Installs the above kubectl
RUN install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

# Copies KubeConfig file to appropriate directory
COPY springboot-cluster.yml /root/.kube/config