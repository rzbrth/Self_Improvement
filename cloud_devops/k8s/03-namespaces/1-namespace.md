# Namespaces

- It's logical or virtual divison of the kubernetes clustur for each team or application that is deployed
  on kubernetes clustur.
- Each namespace will have respourse quota like cpu, storage, limits etc.
- By default resource will get creted in default namespace.

```s
$ kubectl get ns
$ kubectl create ns <namespcae-name>
# Create Namespace
$ kubectl create ns mynamespace
# Use Namespace
$ kubectl apply -f hello-pod.yaml --namespace mynamespace

$ kubectl get pods 
# Above will return No resources found in default namespace.
$ kubectl get pods --namespace mynamespace
# Delete Pod
$ kubectl delete pod hello-service --namespace=mynamespace
# Get default configuration
$ kubectl config view

# Change mimikube configuration to use custom namespace instead of using default one
$ kubectl config set-context --current --namespace mynamespace

# It will return pods having namespace mynamespace
$ kubectl get pods




```
