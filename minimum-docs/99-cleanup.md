# Cleanup

## Delete the load-balancer you created in [Starting, exposing, and testing a Clojure app.](06-start-expose-test.md)

``` console
$ kubectl delete service hello-clj
...


$ kubectl get services

(Should be empty)
```

## Delete the cluster
``` console
$ gcloud container clusters delete hello-clojure
```
