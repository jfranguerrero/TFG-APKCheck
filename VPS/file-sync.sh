
#!/bin/bash

# Supposed to run on rsync-host01, change rsync-host02 to rsync-host01 to make a script that is meant to run on rsync-host02.
inotifywait -m -r --timefmt '%d/%m/%y %H:%M' --format '%T %w %f' -e move /var/www/web_tfg/media/files | while read date time dir file; do
        FILECHANGE=${dir}${file}
	FL=${file}
        #Change ownership of file
        echo "$FILECHANGE"
	scp $FILECHANGE  Usuario@IPMaquinaprincipal:/rutaAplicaciones/apk
	rm $FILECHANGE
done
