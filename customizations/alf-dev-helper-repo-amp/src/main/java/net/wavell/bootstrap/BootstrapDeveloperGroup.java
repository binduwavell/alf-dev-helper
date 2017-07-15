package net.wavell.bootstrap;

import org.alfresco.repo.module.AbstractModuleComponent;
import org.alfresco.service.cmr.security.AuthorityService;
import org.alfresco.service.cmr.security.AuthorityType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class BootstrapDeveloperGroup extends AbstractModuleComponent {

  private static Log LOG = LogFactory.getLog(BootstrapDeveloperGroup.class);

  private static String ALFRESCO_ADMINISTRATORS = "ALFRESCO_ADMINISTRATORS";
  private static String ALFRESCO_DEVELOPERS = "ALFRESCO_DEVELOPERS";

  protected void executeInternal() throws Throwable {
    try {
      AuthorityService authorityService = this.serviceRegistry.getAuthorityService();
      boolean devAuthorityExists = authorityService.authorityExists(AuthorityType.GROUP.getPrefixString() + ALFRESCO_DEVELOPERS);
      if (!devAuthorityExists) {
        LOG.info("Creating ALFRESCO_DEVELOPERS group");
        String alfDevAuth = authorityService.createAuthority(AuthorityType.GROUP, ALFRESCO_DEVELOPERS);
        LOG.info("Adding ALFRESCO_ADMINISTRATORS to ALFRESCO_DEVELOPERS group");
        String alfAdmAuth = authorityService.getName(AuthorityType.GROUP, ALFRESCO_ADMINISTRATORS);
        authorityService.addAuthority(alfDevAuth, alfAdmAuth);
      } else {
        LOG.debug("ALFRESCO_DEVELOPERS group already exists");
      }
    } catch (Exception e) {
      LOG.error("Problem detecting or creating ALFRESCO_DEVELOPERS group", e);
    }
  }
}
