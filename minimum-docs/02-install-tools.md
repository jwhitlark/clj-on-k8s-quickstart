# Installing tools

## Installing Clojure and Lein

While the final image will be built in a multi-stage docker container, development is much easier with local tools.

## Installing Clojure

See the [Clojure Getting Started Guide](https://clojure.org/guides/getting_started).

## Installing Lein

See [Installing Leiningen](https://leiningen.org/#install).  I recommend you install it via your preferred [Package Manager](https://github.com/technomancy/leiningen/wiki/Packaging) if possible.

## Installing Docker

See the [Docker Install Guide](https://docs.docker.com/install/)

## Installing gcloud and kubectl

The [Kubernetes Engine Quickstart](https://cloud.google.com/kubernetes-engine/docs/quickstart) shows how to quickly install the tools you need, and run a minimal generic app to verify your setup.  **Be sure to follow the instructions for Local Shell.**

### Set default project

gcloud config set project [PROJECT_ID]

### Set default compute zone

gcloud config set compute/zone [COMPUTE_ZONE]

I use us-west1-a

## Expected versions

### Docker

``` shell
# Docker version
Client:
 Version:       18.03.0-ce
 API version:   1.37
 Go version:    go1.9.4
 Git commit:    0520e24
 Built: Wed Mar 21 23:06:22 2018
 OS/Arch:       darwin/amd64
 Experimental:  false
 Orchestrator:  swarm
 
 ...
```

### Clojure

``` shell
# clj
Clojure 1.9.0
```

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
