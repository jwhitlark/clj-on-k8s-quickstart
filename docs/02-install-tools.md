# Installing tools

## Installing Clojure and Lein

While the final image will be built in a multi-stage docker container, development is much easier with local tools.

## Installing gcloud and kubectl

[Kubernetes Engine Quickstart](https://cloud.google.com/kubernetes-engine/docs/quickstart) shows how to quickly install the tools you need, and run a minimal generic app to verify your setup.  **Be sure to follow the instructions for Local Shell**

## Expected versions

### gcloud
``` shell
# gcloud -v
Google Cloud SDK 195.0.0
bq 2.0.30
core 2018.03.23
gsutil 4.29
```

### kubectl

``` shell
# kubectl version
Client Version: version.Info{Major:"1", Minor:"9", GitVersion:"v1.9.3", GitCommit:"d2835416544f298c919e2ead3be3d0864b52323b", GitTreeState:"clean", BuildDate:"2018-02-09T21:51:06Z", GoVersion:"go1.9.4", Compiler:"gc", Platform:"darwin/amd64"}
<Will not have server version until later in the tutorial>
```

Next: [Create a cluster](03-create-cluster.md)
