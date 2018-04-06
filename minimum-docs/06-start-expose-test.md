# Starting, exposing and testing a Clojure app.

## Run it

``` console
$ kubectl run hello-clj --image gcr.io/core-XXXXXX/hey:0.0.1 --port 3000 --env="MY_NAME=Python"

deployment "hello-clj" created
```

### See what you've got

``` console
kubectl get deployments
NAME        DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
hello-clj   1         1         1            1           1m
```

#### More detail

``` console
k describe deployment hello-clj
Name:                   hello-clj
Namespace:              default
CreationTimestamp:      Fri, 06 Apr 2018 16:27:36 -0700
Labels:                 run=hello-clj
Annotations:            deployment.kubernetes.io/revision=1
Selector:               run=hello-clj
Replicas:               1 desired | 1 updated | 1 total | 1 available | 0 unavailable
StrategyType:           RollingUpdate
MinReadySeconds:        0
RollingUpdateStrategy:  1 max unavailable, 1 max surge
Pod Template:
  Labels:  run=hello-clj
  Containers:
   hello-clj:
    Image:  gcr.io/core-XXXXXX/hey:0.0.1
    Port:   3000/TCP
    Environment:
      MY_NAME:  Python
    Mounts:     <none>
  Volumes:      <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      True    MinimumReplicasAvailable
OldReplicaSets:  <none>
NewReplicaSet:   hello-clj-5cc48f6f69 (1/1 replicas created)
Events:
  Type    Reason             Age   From                   Message
  ----    ------             ----  ----                   -------
  Normal  ScalingReplicaSet  16s   deployment-controller  Scaled up replica set hello-clj-5cc48f6f69 to 1
```

## Optional: Port-forward to it to test before exposing it

**TODO**

## Expose it

``` console
$ kubectl expose deployment hello-clj --type "LoadBalancer"

service "hello-clj" exposed
```

## Connect from outside

Keep running until External-IP changes from <pending> to an ip.

``` console
kubectl get svc hello-clj
NAME        TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
hello-clj   LoadBalancer   10.39.249.199   XX.XX.XX.XX   3000:31655/TCP   30s
```

Then navigate to http://External-IP:3000

## Fixing mistakes
``` console
kubectl delete svc,deployment hello-clj
```

Next: [Back to Readme](../README.md)

Now you can take down your cluster, see [Cleanup](99-cleanup.md)
