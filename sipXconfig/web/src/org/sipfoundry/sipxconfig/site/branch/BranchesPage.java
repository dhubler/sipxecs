/*
 *
 *
 * Copyright (C) 2009 Pingtel Corp., certain elements licensed under a Contributor Agreement.
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the LGPL license.
 *
 *
 */
package org.sipfoundry.sipxconfig.site.branch;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.Bean;
import org.apache.tapestry.annotations.InjectObject;
import org.apache.tapestry.annotations.InjectPage;
import org.sipfoundry.sipxconfig.branch.BranchManager;
import org.sipfoundry.sipxconfig.components.SipxBasePage;
import org.sipfoundry.sipxconfig.components.SipxValidationDelegate;
import org.sipfoundry.sipxconfig.site.common.BreadCrumb;

public abstract class BranchesPage extends SipxBasePage {

    public static final String PAGE = "branch/BranchesPage";

    public abstract void setBranches(List branches);

    @InjectObject("spring:branchManager")
    public abstract BranchManager getBranchManager();

    @InjectPage(EditBranch.PAGE)
    public abstract EditBranch getEditBranchPage();

    @Bean
    public abstract SipxValidationDelegate getValidator();

    public abstract Integer getGroupId();

    public abstract String getQueryText();

    public abstract Integer getSelectedGroupId();

    public abstract boolean getSearchMode();

    public IPage addBranch() {
        EditBranch page = getEditBranchPage();
        page.setBranchId(null);
        page.setReturnPage(getPage(), getBreadCrumbs());
        return page;
    }

    public IPage editBranch(Integer branchId) {
        EditBranch page = getEditBranchPage();
        page.setBranchId(branchId);
        page.setReturnPage(getPage(), getBreadCrumbs());
        return page;
    }

    private List<BreadCrumb> getBreadCrumbs() {
        List<BreadCrumb> breadCrumbs = new ArrayList<BreadCrumb>();
        breadCrumbs.add(new BreadCrumb(getPage().getPageName(), "&title", getMessages()));
        return breadCrumbs;
    }
}
