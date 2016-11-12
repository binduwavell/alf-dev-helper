#!/bin/bash

DIR=$( cd "$( dirname "$BASH_SOURCE[0]" )" && pwd )

pushd . > /dev/null
cd "$DIR"
CWD=$( basename $DIR )
if [ "scripts" == "$CWD" ]
then
  cd ..
fi

MAVEN_OPTS="-Xms4G -Xmx4G -XX:PermSize=300m" mvn install -Prun  $@

popd > /dev/null
