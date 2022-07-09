# Pod commands

## Pod basic commands

create a separate terminal split pane with watch on pods
```s
$ watch kubectl get pods -o wide
```

### Applicaiton overview
1. Nginx                
2. Hello App 
3. mysql 

```s
$ kubectl get pods
# To check Yaml file syntax and do a dry run use below command
$ kubectl create -f hello-pod.yaml --dry-run=client

$ kubectl apply -f nginx.yaml
$ kubectl apply -f mysql-pod.yaml
$ kubectl apply -f hello-pod.yaml

$ kubectl get pods -o wide
$ kubeclt describe pod docker-mysql
$ kubectl logs docker-mysql

# get inside container of a pod
$ kubectl exec docker-mysql -it -- bash
    $ ps -aux   # notice the PID 1

# get into the node to hit API endpoints
$ minikube ssh 
# curl -i <Pod Ip>:<application port>/
$ curl -i 172.17.0.3:8080/
$ curl -i 172.17.0.3:8080/meta
$ curl -X POST 172.17.0.3:8080/actuator/shutdown
$ curl -i 172.17.0.3:8080/actuator/health
$ curl -i 172.17.0.3:8080/actuator/info


# get into the hello-pod pod to hit API endpoints
$ kubectl exec hello-service -it -- sh
$ wget -qO- 172.17.0.3:8080/
$ wget -qO- 172.17.0.3:8080/meta
$ wget -qO- 172.17.0.3:8080/actuator/health

# add ENV variable to POD and see the change
$ kubectl apply -f mysql-pod.yaml
$ kubectl exec docker-mysql -it -- bash
    $ echo $VERSION

# notice STATUS and RESTART count in watch pane

```

### create multi container pod
```s
$ kubectl apply -f multi-container.yaml
# notice READY column 2/2 - where as other pods are 1/1
$ kubectl describe pod multi-container

# get into one of the container
$ kubectl exec multi-container -it -- bash   
# default to 1st
$ cat /usr/share/nginx/html/index.html

# get into one specific container 2nd
$ kubectl exec multi-container -c 2nd -it -- bash
$ cat /html/index.html

```

### Run pod directly without yaml
```s
# Run pod directly
$ kubectl run demo --image=http
# Get yaml from pod directly
$ kubectl get pod demo -o yaml

# Get documentation for varipus resourses
$ kubectl explain pod
$ kubectl explain rs
$ kubectl explain rs.status



```