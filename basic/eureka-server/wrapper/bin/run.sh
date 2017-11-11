#!/bin/bash
filename=wrapper
patch=$(cd `dirname $0`; pwd)
sed  -i '/export/'d ${patch}/${filename}
sed -i "/modified/a export WRAPPER_HOME=${patch%/*}" ${patch}/${filename}

stop() {
       bash ${patch}/${filename} stop
       }

start() {
        bash ${patch}/${filename} start
        }

status() {
       bash ${patch}/${filename} status
       }

case "$1" in

    'start')
        start
        ;;

    'stop')
        stop
        ;;

    'status')
        status
        ;;
    *)
        echo "Usage: $0 {  start | stop |status }"
        exit 1
        ;;
esac

exit 0
