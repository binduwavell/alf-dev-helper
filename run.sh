#!/bin/bash

DIR=$( cd "$( dirname "$BASH_SOURCE[0]" )" && pwd )

pushd . > /dev/null
cd "$DIR"
CWD=$( basename $DIR )
if [ "scripts" == "$CWD" ]
then
  cd ..
fi

# Downloads the spring-loaded lib if not existing and runs the full all-in-one
# (Alfresco + Share + Solr) using the runner project
springloadedfile=~/.m2/repository/org/springframework/springloaded/1.2.3.RELEASE/springloaded-1.2.3.RELEASE.jar

if [ ! -f $springloadedfile ]; then
mvn validate -Psetup
fi

MAVEN_OPTS="-javaagent:$springloadedfile -noverify -Xms4G -Xmx4G -XX:PermSize=300m" mvn install -Prun  $@

popd > /dev/null
