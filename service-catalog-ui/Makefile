TAG = "Makefile"

MODULE = service-catalog-ui
NODE_VERSION = v10.16.0

.PHONY: tools.install
tools.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing tools"
	@ echo "-----------------------------------------\n"

	@ npm install -g @vue/cli-service-global
	@ npm install -g @vue/cli
	@ npm install -g npm-check-updates

.PHONY: dependency.install
dependency.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing dependencies"
	@ echo "-----------------------------------------\n"

	@ npm install

.PHONY: dependency.update
dependency.update:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing dependencies"
	@ echo "-----------------------------------------\n"

	@ rm -rf node_modules/
	@ rm -rf package-lock.json
	@ ncu -u
	@ npm install

.PHONY: run
run:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ npm run serve
