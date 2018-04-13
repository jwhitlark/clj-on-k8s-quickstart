# Extras for the minimum example

## Health/liveliness checks

**TODO**

## K8s Dashboard

``` console
$ kubectl proxy
```
Then go to:
http://localhost:8001

## GCP K8s Cloud Console
(preferred on GCP)

https://console.cloud.google.com/kubernetes/workload

## Socket repl & Port Forward

1. Build v. 0.0.2 with this in the entrypoint
-Dclojure.server.repl="{:port 5555 :accept clojure.core.server/repl}"

2. Tag and Push the new build

3. Update the deployment with the new image

``` console
$ kubectl set image deployment/hello-clj hello-clj=gcr.io/core-XXXXXX/hey:0.0.2
```

4. Add the other port to the deployement

``` console
kubectl edit ????
```

``` yaml
ports:
  - containerPort: 3000
    protocol: TCP
  - containerPort:5555
    protocol: TCP
```
5. Forward the port

``` console
$ kubectl port-forward deployment/hello-clj 5555:5555 
```

6. Telnet to the socket REPL

``` console
telnet 127.0.0.1 5555
```

7. Look around the environment, especially DNS!
**TODO**

## SSL

**TODO**

Need to use an Ingress, which creates an HTTP(S) Load Balancer and supports global IP addresses.

https://cloud.google.com/kubernetes-engine/docs/tutorials/http-balancer

Background info:

https://cloud.google.com/kubernetes-engine/docs/tutorials/http-balancer#background

When you're ready, you can go [back to the Readme](../README.md).

Don't forget to take down your cluster, so you won't be charged for it!  See [Cleanup](99-cleanup.md)
