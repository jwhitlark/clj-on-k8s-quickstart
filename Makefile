
NOW = $(shell date +'%Y-%m-%d.%H:%M:%S')

cluster-info-dump:
	kubectl cluster-info dump --all-namespaces --output-directory=./cluster-state-$(NOW)
