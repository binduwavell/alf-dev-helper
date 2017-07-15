# alf-dev-helper

This is a small project where I will collect a number of small and I hope useful utilities for developer (and to some extent administering) an Alfresco system.

During starting, if there is no ALFRESCO\_DEVELOPERS group, this will create one and add the ALFRESCO\_ADMINISTRATORS group to it.

The following actions will only be enabled for members of the ALFRESCO\_DEVELOPERS group:

- Enables the change type document library action when browsing.
- Enables the execute script document library action when browsing and when on the details screen.
- Adds a document library action that can jump directly to the node browser for the current node.

![Open in Node Browser Doc Lib Action](https://cloud.githubusercontent.com/assets/115754/20243553/d2524d00-a91a-11e6-881a-7d6da94a3412.png)

I'm very open to ideas for small and helpful tools. I do not plan to create any big and/or complex customizations in this project.

If you are interested in tools to help with your Alfresco development efforts, I would also highly recommend taking a look at another project I work on: https://github.com/binduwavell/generator-alfresco. In that project we provide a yeoman generator for scaffolding out a project using the Alfresco all-in-one archetype. We also provide a number of useful sub-generators that will help you create common extension points such as Web Scripts, behaviors, actions and content models. There are plans to add a lot more of these sub-generators (see the issues list in that project for details, and don't hesitate to raise an issue if there is something we are missing.)

In fact, this project was created with `yo alfresco`. If you have your own project created with `yo alfresco` and you wish to add the latest released alf-dev-helper to you project, you can use `yo alfresco:amp-add-common -p "Developer Helper"`.
