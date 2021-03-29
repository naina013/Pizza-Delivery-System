#! /bin/sh
sed -i 's/tagVersion/'"$GIT_TAG_NAME"'/g' ${WORKSPACE}/${BUILD_ID}/conf/app.conf
