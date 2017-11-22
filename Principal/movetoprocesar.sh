#!/bin/bash

# Supposed to run on rsync-host01, change rsync-host02 to rsync-host01 to make a script that is meant to run on rsync-host02.
inotifywait -m -r --timefmt '%d/%m/%y %H:%M' --format '%T %w %f' -e create /RutaAlmacen/apk | while read date time dir file; do
        FILECHANGE=${dir}${file}
        FL=${file}
        #Change ownership of file
        echo "$FL"
        echo "$FILECHANGE"
        sleep 5
        mv $FILECHANGE  /RutaProgramas/TFG
        cd /RutaProgramas/TFG
        ./procesarapk.sh $FL
        #rm $FILECHANGE
done
