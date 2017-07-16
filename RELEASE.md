# Release

Following is the process for bumping versions and pushing to sonotype.

```
mvn --batch-mode clean release:prepare -Drelease.rel.org.alfresco.maven:customizations=1.0.0 -Drelease.dev.org.alfresco.maven:customizations=1.0.0-SNAPSHOT
mvn release:clean
git checkout HEAD~1
GPG_TTY=$(tty)
export GPG_TTY
mvn -Prelease clean deploy
```

- You will be prompted for the GPG passphrase. This has to do with the GPG\_TTY setting.
  - It seams like this should have been pulled from my settings.xml but for now this is
    the workaround.

## Publish on Maven Central

The docs are [here](http://central.sonatype.org/pages/releasing-the-deployment.html).

- Navigate to `https://oss.sonatype.org`
- Click "Staging Repositories" in the left menu
- Find repositories with names that start "netwavell-####"
- Release the repository(ies)
- It will take upto 2 hours until the assets are available on Maven central
