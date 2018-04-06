# Starting, exposing and testing a Clojure app.

**TODO: Explain why a replica set, and where to find lower level docs**

## Writing the replica set

``` yaml
apiVersion: extensions/v1beta1
kind: ReplicaSet
metadata:
  name: hey-clj
  namespace: default
spec:
  replicas: 1
  template:
    metadata:
      labels:
        app: hey-clj
        version: "0.0.1"
    spec:
      containers:
        - image: <<<<fixme>>>>
          name: hey-clj
          env:
            - name: DATABASE_URL
              value: jdbc:postgresql://pg-two.jw-test.svc.cluster.local/c4?user=postgres&password=notclever
          ports:
            - containerPort: 3000  # Webapp
            - containerPort: 7000  # Repl
```
            
## Deploy the replica set

``` shell
kubectl apply -f hey-rs.yaml
```

**TODO: all below**

## Check it

## Proxy it

## Check it via proxy

## Expose it

## Check it publicly

## Cleaning up the replica set

Next: [Back to Readme](../README.md)

Now you can take down your cluster, see [Cleanup](99-cleanup.md)
