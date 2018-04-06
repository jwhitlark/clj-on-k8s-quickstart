# Creating a cluster

## Create the cluster

``` console
$ gcloud container clusters create hello-clojure --cluster-version=1.9.6

Creating cluster hello-clojure...done.
Created [https://container.googleapis.com/v1/projects/core-XXXXXX/zones/us-west1-a/clusters/hello-clojure].
To inspect the contents of your cluster, go to: https://console.cloud.google.com/kubernetes/workload_/gcloud/us-west1-a/hello-clojure?project=core-XXXXXX
kubeconfig entry generated for hello-clojure.
NAME           LOCATION    MASTER_VERSION  MASTER_IP     MACHINE_TYPE   NODE_VERSION  NUM_NODES  STATUS
hello-clojure  us-west1-a  1.9.6-gke.0     XX.XX.XX.XX   n1-standard-1  1.9.6-gke.0   3          RUNNING
```

You can see your progress on the [GCP Kubernetes Engine Dashboard](https://console.cloud.google.com/kubernetes/list)

## Configure kubectl access

``` console
$ gcloud container clusters get-credentials hello-clojure

Fetching cluster endpoint and auth data.
kubeconfig entry generated for hello-clojure.
```

## Verify
``` console
$ gcloud container clusters list
NAME           LOCATION    MASTER_VERSION  MASTER_IP     MACHINE_TYPE   NODE_VERSION  NUM_NODES  STATUS
hello-clojure  us-west1-a  1.9.6-gke.0     XX.XX.XX.XX   n1-standard-1  1.9.6-gke.0   3          RUNNING


$ kubectl config get-contexts

CURRENT   NAME                                       CLUSTER                                    AUTHINFO                                   NAMESPACE
*         gke_core-XXXXXX_us-west1-a_hello-clojure   gke_core-XXXXXX_us-west1-a_hello-clojure   gke_core-XXXXXX_us-west1-a_hello-clojure
```


Next: [A Minimal Webapp](04-minimal-app.md)


If you need to take down your cluster, see [Cleanup](99-cleanup.md)
