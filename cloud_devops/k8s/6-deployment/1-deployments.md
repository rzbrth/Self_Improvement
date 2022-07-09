# Deployments

# It guarentee us zero downtime.
# Deploy deployment
```s
$ kubectl apply -f hello-deployment.yaml
# observe deployment, replicaset and pods - along with our previous service and endpoints getting attached to new pods

# how to see all revisions of dployment
$ kubectl rollout history deployment/hello-service
# notice all 3 revisions deployed so far, however, the field change-cause is empty
# how to set change cause
$ kubectl annotate deployment hello-service kubernetes.io/change-cause="my message" --record=false --overwrite=true
$ kubectl rollout history deployment/hello-service
$ kubectl rollout history deployment/hello-service --revision=3

$ export GIT_COMMIT=$(git log -1 --format=%h)
$ kubectl annotate deployment hello-service kubernetes.io/change-cause="$GIT_COMMIT" --record=false --overwrite=true
$ kubectl rollout history deployment/hello-service

$ kubectl apply -f hello-deployment-annotation.yaml
$ kubectl rollout history deployment/hello-service

# rollback
$ kubectl rollout undo deployment/hello-service
$ kubectl rollout history deployment/hello-service
# notice reuse of previous replicaset
$ kubectl rollout undo deployment/hello-service --to-revision=1
$ kubectl rollout history deployment/hello-service

```

# Deployment strategies
```s
# Scale deployments
$ kubectl scale deployments hello-service --replicas=10

# RollingUpdate is default strategy
$ kubectl apply -f hello-deployment-rolling-strategy.yaml
# notice slow updates and no downtime, however both version co-exists at given point of time

$ kubectl apply -f hello-deployment-recreate-strategy.yaml
# notice downtime, all gone and recreated

```
