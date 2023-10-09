package com.instabug.bing.testCases;

import com.instabug.bing.base.BaseTest;
import com.instabug.bing.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void shouldBeAbleToSeeSearchInput() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.load();
        Assert.assertTrue(searchPage.isSearchInputDisplayed());
    }

    @Test(priority = 2)
    public void shouldBeAbleToAccessSearchInput() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.load();
        Assert.assertTrue(searchPage.isSearchBoxAcceptsInputs("Iphone"));
    }

    @Test(priority = 3)
    public void shouldBeAbleToReturnResultsRelevant() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.load();
        Assert.assertTrue(searchPage.isSearchResultRelevant("phones","Iphone"));
    }

    @Test(priority = 4)
    public void shouldBeAbleToShowNoResultsIncaseOfGarbageInput() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.load();
        String inputValue = "reqtr1345314124dszfas;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jvtio;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jvtio;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jvtio;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jvtio;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jvtio;ueqwhtr[op;8iv thj53op12 b56h 8901uv56403[ vtjhior3kj vg[iro13j gv[]iop13 jgh[r1890 hjb10[]892bhj[2]iopq'v hj1[]9ih v1jv";
        Assert.assertTrue(searchPage.doesSpellingMessageAppear(inputValue));
    }

    @Test(priority = 5)
    public void leadingAndTrailingSpacesShouldNotAffectResults() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.load();
        StringBuffer sp = new StringBuffer();
        sp.append(" ");
        sp.append("Iphone");
        sp.append(" ");
        Assert.assertTrue(searchPage.isSearchResultRelevant("phone",sp.toString()));
    }

}
