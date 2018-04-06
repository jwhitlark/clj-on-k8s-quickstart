
NOW = $(shell date +'%Y-%m-%d.%H:%M:%S')

cluster-info-dump:
	kubectl cluster-info dump --all-namespaces --output-directory=./cluster-state-$(NOW)

cluster-info-dump-jw-test:
	kubectl cluster-info dump -n=jw-test --output-directory=./cluster-state-jw-test-$(NOW)
