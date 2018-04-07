# Extras for the minimum example

## Health/liveliness checks

**TODO**

Use kubectl edit ????

   livenessProbe:
      httpGet:
        path: /healthz
        port: 8080
        httpHeaders:
        - name: X-Custom-Header
          value: Awesome
      initialDelaySeconds: 3
      periodSeconds: 3

## K8s Dashboard/Cloud console

kubectl proxy

http://localhost:8001

or (preferred on GCP)

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
Preferred, probably
    https://cloud.google.com/kubernetes-engine/docs/tutorials/http-balancer

1. Change the svc type to nodeport

``` console
kubectl expose deployment hello-clj --target-port=3000 --type=NodePort
```

2. Verify it was created  **UPDATE_ME**

``` console
kubectl get service hello-clj
NAME      TYPE       CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
web       NodePort   10.35.245.219   <none>        8080:32640/TCP   5m
```

3. Write the yaml for the ingress object

basic-ingress.yaml
``` yaml
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: basic-ingress
spec:
  backend:
    serviceName: hello-clj
    servicePort: 3000
```

4. Create the ingress object

``` console
$ kubectl apply -f basic-ingress.yaml
```

5. Hmm.  This isn't correct.....

See https://kubernetes.io/docs/concepts/services-networking/ingress/#tls

and

https://cloud.google.com/endpoints/docs/openapi/enabling-ssl

