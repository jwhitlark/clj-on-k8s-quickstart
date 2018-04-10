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

## Looking at logs

``` console
$ kubectl get pods

NAME                         READY     STATUS    RESTARTS   AGE
hello-clj-5cc48f6f69-mvqqb   1/1       Running   0          25m

$ kubectl logs hello-clj-5cc48f6f69-mvqqb

2018-04-06 23:27:39.671:INFO::main: Logging initialized @1852ms
2018-04-06 23:27:39.888:INFO:oejs.Server:main: jetty-9.2.z-SNAPSHOT
2018-04-06 23:27:39.928:INFO:oejs.ServerConnector:main: Started ServerConnector@6b6fb701{HTTP/1.1}{0.0.0.0:3000}
2018-04-06 23:27:39.929:INFO:oejs.Server:main: Started @2109ms
```

**TODO:Show how to navigate to stackdriver page**
https://console.cloud.google.com/logs/viewer

GKE Container,hello-clojure,default 

## Fixing mistakes
``` console
kubectl delete svc,deployment hello-clj
```

That does it for the minimum, but I recommend you look at the [Minimum Extras](07-minimum-extras.md) or you can go [back to the Readme](../README.md).

Don't forget to take down your cluster, so you won't be charged for it!  See [Cleanup](99-cleanup.md)



