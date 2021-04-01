#! /bin/sh
sed -i 's/tagVersion/'"$GIT_TAG_NAME"'/g' ${WORKSPACE}/app.conf
